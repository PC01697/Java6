package pc01815.Normal_J6.Controller.NguoiDung;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Repository.AccountsRepository;
import pc01815.Normal_J6.Services.OrderService;
@Controller
public class DatHang {
	@Autowired
	AccountsRepository accountDAO;
	@Autowired
	HttpServletRequest req;
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/order/dathang")
	public String checkout(Model model) {
		Accounts acc = accountDAO.findByUsername(req.getRemoteUser());
		model.addAttribute("id",acc);
		return "NguoiDung/dathang";		
	}
	@RequestMapping("/order/list")
	public String list(Model model) {
		String username= req.getRemoteUser();
		model.addAttribute("orders", orderService.findByUsername(username));
		return "NguoiDung/allhoadon";
	}
	@RequestMapping("/order/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {	
		model.addAttribute("order", orderService.findById(id));
		return "NguoiDung/ttdonhang";
	}
}
