package pc01815.Normal_J6.Controller.NguoiDung;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pc01815.Normal_J6.Entity.Products;
import pc01815.Normal_J6.Repository.ProductsRepository;


@Controller
public class Shop {
	@Autowired
	ProductsRepository productDao;
	@RequestMapping("/shop/{id}")
	public String form(Model model, @PathVariable("id") Integer id,
			@RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 9);
		Page<Products> page = productDao.findByShop(id,pageable);
		model.addAttribute("page", page);
		return "NguoiDung/shop";
		
	}
}
