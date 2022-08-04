package pc01815.Normal_J6.Controller.NguoiDung;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pc01815.Normal_J6.Entity.Category;
import pc01815.Normal_J6.Entity.Products;
import pc01815.Normal_J6.Repository.CategoryRepository;
import pc01815.Normal_J6.Repository.ProductsRepository;
@Controller
public class ChiTiet {
	@Autowired
	ProductsRepository productDao;
	@Autowired
CategoryRepository categoryDao;
	@RequestMapping("/chitiet/{id}")
	public String form(Model model,@PathVariable("id") Integer id) {
		List<Category> item = categoryDao.findAll();
		model.addAttribute("item", item);
		
        Products product = productDao.findById(id).get();
        model.addAttribute("product", product);
		return "NguoiDung/chitiet";
		
	}
}
