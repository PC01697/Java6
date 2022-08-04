package pc01815.Normal_J6.Controller.TaiKhoan;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import pc01815.Normal_J6.Services.AccountsService;

@Controller
public class taiKhoan {
	@Autowired
	AccountsService accountService;
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
				acc.setPhoto("NULL");
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
}
