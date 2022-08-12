package pc01815.Normal_J6.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

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
	AuthoritiesRepository authDAO;
	@Autowired
	RolesRepository roleDAO;
	@Autowired
	AccountsRepository accountDAO;
	@GetMapping("/abc/{id}")
	public Authorities abc(@PathVariable("id") int id) {
		
		return AuthService.authService(id);
	}
	
	@GetMapping("/authorities")
	public Map<String,Object> getAuthorities(){
		Map<String,Object> data = new HashMap<>();
		data.put("accounts",accountDAO.findAll());
		data.put("roles",roleDAO.findAll());
		data.put("authorities",authDAO.findAll());
		
		return data;
	}
}
