package pc01815.Normal_J6.Controller.NguoiDung;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import pc01815.Normal_J6.Entity.Category;
import pc01815.Normal_J6.Entity.Products;
import pc01815.Normal_J6.Repository.CategoryRepository;
import pc01815.Normal_J6.Repository.ProductsRepository;



@Controller

public class TrangChu {

	@Autowired
CategoryRepository categoryDao;
	@Autowired
	ProductsRepository productDao;
	@RequestMapping("/index")
	public String form(Model model) {
		List<Category> item = categoryDao.findAll();
		model.addAttribute("item", item);
		

		Pageable pageable = PageRequest.of(0, 6);
		Page<Products> page = productDao.findAll(pageable);
		model.addAttribute("page", page);
//		
		Pageable pageable2 = PageRequest.of(0, 13);
		Page<Products> page2 = productDao.findAll(pageable2);
		model.addAttribute("page2", page2);

		Pageable pageable3 = PageRequest.of(0, 8);
		Page<Products> page3 = productDao.findByShop(2,pageable3);
		model.addAttribute("page3", page3);
//		
		Pageable pageable4 = PageRequest.of(0, 8);
		Page<Products> page4 = productDao.findByShop(3,pageable4);
		model.addAttribute("page4", page4);
        return "NguoiDung/trangchu";
	}
	
}
