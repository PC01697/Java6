package pc01815.Normal_J6.Controller.NguoiDung;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import pc01815.Normal_J6.Entity.Category;
import pc01815.Normal_J6.Repository.CategoryRepository;



import pc01815.Normal_J6.Services.AccountServiceImpl;


@Controller

public class TrangChu {

	@Autowired
CategoryRepository categoryDao;
	@RequestMapping("/index")
	public String form(Model model) {
		List<Category> item = categoryDao.findAll();
		model.addAttribute("item", item);
		
        return "NguoiDung/trangchu";
	}
	
}
