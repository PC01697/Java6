package pc01815.Normal_J6.Controller.NguoiDung;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
>>>>>>> branch 'master' of https://github.com/trung3/Normal_J6.git
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
import pc01815.Normal_J6.Entity.Category;
import pc01815.Normal_J6.Repository.CategoryRepository;


=======
import pc01815.Normal_J6.Services.AccountServiceImpl;
>>>>>>> branch 'master' of https://github.com/trung3/Normal_J6.git

@Controller

public class TrangChu {
<<<<<<< HEAD
	@Autowired
CategoryRepository categoryDao;
	@RequestMapping("/trangchu")
	public String form(Model model) {
		List<Category> item = categoryDao.findAll();
		model.addAttribute("item", item);

=======
	
	@RequestMapping("/index")
	public String form() {
>>>>>>> branch 'master' of https://github.com/trung3/Normal_J6.git
		return "NguoiDung/trangchu";
		
	}
}
