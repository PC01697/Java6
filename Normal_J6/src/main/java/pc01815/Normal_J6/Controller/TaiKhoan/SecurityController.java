package pc01815.Normal_J6.Controller.TaiKhoan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
     
	@RequestMapping("/security/login/form")
	public String loginForm(Model m) {
		m.addAttribute("tb","Vui lòng đăng nhập!!");
		return "TaiKhoan/login";
	}
	@RequestMapping("/security/login/success")
	public String loginSucess(Model m) {
		m.addAttribute("tb","Đăng nhập thành công");
		return "TaiKhoan/login";
	}
	@RequestMapping("/security/login/error")
	public String loginError(Model m) {
		m.addAttribute("tb","Sai thông tin đăng nhập!!");
		return "TaiKhoan/login";
	}
	@RequestMapping("/security/unauthoried")
	public String Unauthoried(Model m) {
		m.addAttribute("tb","Không có quyền truy cập!!");
		return "TaiKhoan/login";
	}
	@RequestMapping("/security/logout/success")
	public String LogoutSuccess(Model m) {
		m.addAttribute("tb","Bạn đã đăng xuất!!");
		return "TaiKhoan/login";
	}
}
