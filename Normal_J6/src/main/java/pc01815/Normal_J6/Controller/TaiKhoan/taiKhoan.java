package pc01815.Normal_J6.Controller.TaiKhoan;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Entity.Authorities;
import pc01815.Normal_J6.Entity.Roles;
import pc01815.Normal_J6.Repository.AccountsRepository;
import pc01815.Normal_J6.Repository.AuthoritiesRepository;
import pc01815.Normal_J6.Repository.RolesRepository;


@Controller
public class taiKhoan {
	@Autowired
	HttpServletRequest req;
	@Autowired
	HttpServletResponse resp;
	@Autowired
	AccountsRepository accountDAO;
    @Autowired
    AuthoritiesRepository authDAO;
    @Autowired
    RolesRepository rolesDAO;
//    @Autowired
//	BCryptPasswordEncoder pe;
	static String mail;
    static int  randomInt;
    static int  passmoi;
    static String name;
	@RequestMapping("/login")
	public String login() {

		return "TaiKhoan/login";
	}
	
	@GetMapping("/register")
	public String register(Model m) {
		Accounts acc = new Accounts();
		m.addAttribute("acc", acc);

		return "TaiKhoan/SignUp";
	}

	@PostMapping("/register")
	public String Postregister(Model m, @Validated @ModelAttribute("acc") Accounts acc, Errors errors,
			@RequestParam("NLpassword") String NLpass) {
		if (errors.hasErrors()) {
			m.addAttribute("tb", "Vui lòng sửa các lỗi sau:");

		} else {
			Integer kt = 0;
			Accounts account = accountDAO.findByUsername(acc.getUsername());
			if (account != null) {
				kt++;
				m.addAttribute("ktTonTai", "User đã tồn tại.");
			}
			if (accountDAO.findByEmail(acc.getEmail()) != null) {
				kt++;
				m.addAttribute("ktEmail", "Email đã tồn tại");
			}
			if (!NLpass.equals(acc.getPassword())) {
				kt++;
				m.addAttribute("ktPass", "Mật khẩu không khớp");
			}
			if(kt==0) {
				BCryptPasswordEncoder pe =new BCryptPasswordEncoder();
				List<Authorities> list = new ArrayList<>();
				
				Roles roles = rolesDAO.findByName("USER");
				
				acc.setAuthoritieses(list);

				acc.setPassword(pe.encode(acc.getPassword()));
				
				accountDAO.save(acc);
				Authorities auth = new Authorities();
				auth.setAccounts(acc);
				auth.setRoles(roles);
				authDAO.save(auth);
				m.addAttribute("tb","Đăng ký thành công");
			}

		}

		return "TaiKhoan/SignUp";
	}
	
	@GetMapping("/fogetPass")
	public String forgetPass() {
		
		return "TaiKhoan/FogetPass";
	}
	public void Mail(Model m,String email,String nd,String tieude) {
		Properties props = new Properties(); 
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true"); 
		props.setProperty("mail.smtp.host", "smtp.gmail.com"); 
		props.setProperty("mail.smtp.ssl.trust","smtp.gmail.com");
		props.setProperty("mail.smtp.ssl.protocols","TLSv1.2");
		props.setProperty("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new Authenticator() { 
			protected PasswordAuthentication getPasswordAuthentication() {
		
			String username = "trungttpc01815@fpt.edu.vn";
			String password = "zloucbkhuqdcuwfd";
			return new PasswordAuthentication(username, password);
			}
		});
		
		MimeMessage mime = new MimeMessage(session);
		
		try {
			Multipart mailmultipart = new MimeMultipart();
			
			MimeBodyPart bodytext = new MimeBodyPart();
			
			
			bodytext.setText(nd,"utf-8");
			
			
			mailmultipart.addBodyPart(bodytext);
	
			mime.setFrom(new InternetAddress("trungttpc01815@fpt.edu.vn"));
			mime.setRecipients(Message.RecipientType.TO,email);
			mime.setSubject(tieude,"utf-8");
			mime.setReplyTo(mime.getFrom());
			mime.setContent(mailmultipart);
			
			Transport.send(mime);
			m.addAttribute("tbforgotPassword", "Vui lòng kiểm Email!");
			
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.addAttribute("tbforgotPassword", "Gửi Mã thất bại");
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.addAttribute("tbforgotPassword", "Gửi Mã thất bại");
			
		}	
	}
	@PostMapping("/fogetPass")
	public String forgetPass(Model m,@RequestParam("username")String username,@RequestParam("email") String email) {
		Accounts acc = accountDAO.findByUsername(username);
		m.addAttribute("username", username);
		m.addAttribute("email", email);
		if(acc != null && acc.getEmail().equalsIgnoreCase(email)) {
			
			for(int i=0;i<1;i++) {
	            double random = Math.random();		             
	           random =random *1000000;   
	              randomInt =(int) random;                
		}
			String nd ="Nhập mã "+randomInt+" để xác nhận đổi mật khẩu";
			this.Mail(m,email,nd,"Mã xác nhận");
			name = username;
			mail = email;
			return "TaiKhoan/MaOTP";
		}else {
			m.addAttribute("tbforgotPassword","Tên đăng nhập hoặc email không chính xác");
			return "TaiKhoan/FogetPass";
		}
		
	}
	
	@PostMapping("/XacThuc")
	public String xacThuc(Model m,@RequestParam("otp") int maXN ) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		m.addAttribute("maXN", maXN);
		if(maXN != randomInt) {
			m.addAttribute("tbforgotPassword","Mã xác nhận không đúng!");
		 System.out.println("mã:"+randomInt);
		}else {
			Accounts acc = accountDAO.findByUsername(name);
			for(int i=0;i<1;i++) {
	            double random = Math.random();		             
	           random =random *1000000;   
	              randomInt =(int) random;                
		}
			String nd ="Mật khẩu mới của bạn là:"+randomInt;
			this.Mail(m,mail,nd,"Mật khẩu mới");
			acc.setPassword(pe.encode(randomInt+""));
			accountDAO.save(acc);
			m.addAttribute("tbforgotPassword","Vui lòng đăng nhập với mật khẩu mới!");
			//abc
		}
		return "TaiKhoan/login";
	}

	@GetMapping("/changePass")
	public String changePass(Model m) {
		m.addAttribute("username",req.getRemoteUser());
		return "TaiKhoan/ChangePass";
	}
	@PostMapping("/changePass")
	public String changePass(Model m,@RequestParam("passwordcu") String passCu,
			@RequestParam("passwordMoi") String passMoi,@RequestParam("passwordXN") String XNPass) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		
		m.addAttribute("username",req.getRemoteUser());
		
		Accounts acc = accountDAO.findByUsername(req.getRemoteUser());
		if(acc != null) {
			if(passMoi.isEmpty() || passMoi.isEmpty() || XNPass.isEmpty()) {
				m.addAttribute("tb","Các dòng đang trống");
			}else {
				if(pe.matches(passCu,acc.getPassword())) {
					if(pe.matches(passMoi,acc.getPassword())) {
						m.addAttribute("tb","Mật khẩu này đã đổi trước đó");
						
					}else {
						if(passMoi.equals(XNPass)) {
							acc.setPassword(pe.encode(passMoi));
							accountDAO.save(acc);
							m.addAttribute("tb","Đổi mật khẩu thành công");
						}else {
							m.addAttribute("tb","Xác nhận mật khẩu không đúng");
						}
					}
					
				
				}else {
					m.addAttribute("tb","Mật khẩu cũ không đúng");
				}
			}
			
			
		}else {
			m.addAttribute("tb","Username không tồn tại");
		
		}
		return "TaiKhoan/ChangePass";
	}
	
	@GetMapping("/editProfile")
	public String edit(Model m) {
		m.addAttribute("username",req.getRemoteUser());
		Accounts acc = accountDAO.findByUsername(req.getRemoteUser());
		if(acc != null) {
			m.addAttribute("pass",acc.getPassword());
			m.addAttribute("fullname",acc.getFullname());
			m.addAttribute("email", acc.getEmail());
		}
		return "TaiKhoan/EditProfile";
	}
	
	@PostMapping("/editProfile")
	public String edit(Model m,@RequestParam("password") String pass,@RequestParam("fullname") String fullname,
			@RequestParam("email") String email
			) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		m.addAttribute("username",req.getRemoteUser());
		Accounts acc = accountDAO.findByUsername(req.getRemoteUser());
		if(acc != null) {
			m.addAttribute("pass",acc.getPassword());
			m.addAttribute("fullname",acc.getFullname());
			m.addAttribute("email",acc.getEmail());
			if(!pass.isEmpty() && !fullname.isEmpty() && !email.isEmpty()) {
				acc.setPassword(pe.encode(pass));
				acc.setFullname(fullname);
				acc.setEmail(email);
				accountDAO.save(acc);
				m.addAttribute("tb","Cập nhật thành công");
				
			}else {
				m.addAttribute("tb","Cập nhật thất bại");
			}
		}
		return "TaiKhoan/EditProfile";
	}
}
