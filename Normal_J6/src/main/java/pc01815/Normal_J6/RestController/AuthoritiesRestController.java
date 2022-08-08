package pc01815.Normal_J6.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pc01815.Normal_J6.Entity.Authorities;
import pc01815.Normal_J6.Services.AuthoritiesService;

@RestController
@RequestMapping("api")
public class AuthoritiesRestController {

	@Autowired
	AuthoritiesService AuthService;
	
	@GetMapping("/abc/{id}")
	public Authorities abc(@PathVariable("id") int id) {
		
		return AuthService.authService(id);
	}
}
