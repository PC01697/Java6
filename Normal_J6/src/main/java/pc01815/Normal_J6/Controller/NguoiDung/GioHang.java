package pc01815.Normal_J6.Controller.NguoiDung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pc01815.Normal_J6.Repository.ProductsRepository;
@Controller
public class GioHang {
	@Autowired
	ProductsRepository productDao;
	@RequestMapping("/giohang")
	public String form(Model model) {
		
		return "NguoiDung/giohang";
		
	}
}
