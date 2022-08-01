package pc01815.Normal_J6.Controller.NguoiDung;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class TrangChu {
	@RequestMapping("/index")
	public String form(Model model) {
		
		return "NguoiDung/trangchu";
		
	}
}
