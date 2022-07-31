package pc01815.Normal_J6.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class dashboardAdmin {

	
	@RequestMapping("/admin/dashboard")
	public String adminPage() {
		return "admin/dashboard";
	}
}
