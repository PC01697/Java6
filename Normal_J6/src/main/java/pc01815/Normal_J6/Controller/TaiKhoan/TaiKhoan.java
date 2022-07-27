package pc01815.Normal_J6.Controller.TaiKhoan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaiKhoan {
	@RequestMapping("/dangnhap")
	public String dangNhap(Model model) {
		
		return "TaiKhoan/DangNhap";
		
	}
	@RequestMapping("/dangky")
	public String dangKy(Model model) {
		
		return "TaiKhoan/DangKy";
		
	}
	@RequestMapping("/capnhattk")
	public String capNhatTK(Model model) {
		
		return "TaiKhoan/CapNhatTK";
		
	}
	@RequestMapping("/doimk")
	public String doiMK(Model model) {
		
		return "TaiKhoan/DoiMK";
		
	}
	@RequestMapping("/quenmk")
	public String quenMK(Model model) {
		
		return "TaiKhoan/QuenMK";
		
	}
	
}
