package pc01815.Normal_J6.Controller.TaiKhoan;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Entity.Authorities;
import pc01815.Normal_J6.Services.AccountsService;

@Controller
public class taiKhoan {
	@Autowired
	AccountsService accountService;
    @RequestMapping("/dangnhap")
    public String login() {
    	
    	return "TaiKhoan/login";
    }
}
