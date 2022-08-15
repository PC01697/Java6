package pc01815.Normal_J6.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Entity.Authorities;
import pc01815.Normal_J6.Repository.AccountsRepository;
import pc01815.Normal_J6.Repository.AuthoritiesRepository;
import pc01815.Normal_J6.Repository.RolesRepository;
import pc01815.Normal_J6.Services.AuthoritiesService;

@RestController
@RequestMapping("api")
public class AuthoritiesRestController {

	@Autowired
	AuthoritiesService AuthService;
	@Autowired
	AuthoritiesRepository auth;
	@Autowired
	RolesRepository roles;
	@Autowired
	AccountsRepository acc;
	@GetMapping("/authories")
	public Map<String,Object> abc() {
		Map<String,Object> data = new HashMap<>();
		
		data.put("roles",roles.findAll());
		
		data.put("accounts",acc.findAll());
		
		data.put("authories", auth.findAll());
		
		return data;
		
	}

	
}
