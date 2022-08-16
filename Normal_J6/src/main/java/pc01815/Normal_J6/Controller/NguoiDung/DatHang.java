package pc01815.Normal_J6.Controller.NguoiDung;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Entity.Category;
import pc01815.Normal_J6.Repository.AccountsRepository;
import pc01815.Normal_J6.Repository.CategoryRepository;
import pc01815.Normal_J6.Services.OrderService;
@Controller
public class DatHang {
	@Autowired
	AccountsRepository accountDAO;
	@Autowired
	HttpServletRequest req;
	@Autowired
	OrderService orderService;
	@Autowired
CategoryRepository categoryDao;
	@RequestMapping("/order/dathang")
	public String checkout(Model model) {
		Accounts acc = accountDAO.findByUsername(req.getRemoteUser());
		model.addAttribute("id",acc);
		
		List<Category> item = categoryDao.findAll();
		model.addAttribute("item", item);
		return "NguoiDung/dathang";		
	}
	@RequestMapping("/order/list")
	public String list(Model model) {
		String username= req.getRemoteUser();
		model.addAttribute("orders", orderService.findByUsername(username));
		
		List<Category> item = categoryDao.findAll();
		model.addAttribute("item", item);
		return "NguoiDung/allhoadon";
	}
	@RequestMapping("/order/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {	
		model.addAttribute("order", orderService.findById(id));
		List<Category> item = categoryDao.findAll();
		model.addAttribute("item", item);
		return "NguoiDung/ttdonhang";
	}
}
