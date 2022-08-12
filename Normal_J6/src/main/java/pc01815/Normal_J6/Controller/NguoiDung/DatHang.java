package pc01815.Normal_J6.Controller.NguoiDung;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class DatHang {
	@RequestMapping("/order/dathang")
	public String checkout(Model model) {
		return "NguoiDung/dathang";		
	}
	@RequestMapping("/order/list")
	public String list(Model model) {
		
		return "NguoiDung/dathang";
	}
	@RequestMapping("/order/detail/{id}")
	public String detail(Model model) {		
		return "NguoiDung/dathang";
	}
}
