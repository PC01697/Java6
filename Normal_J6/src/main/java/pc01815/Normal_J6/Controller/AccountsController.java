package pc01815.Normal_J6.Controller;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Entity.Authorities;
import pc01815.Normal_J6.Repository.AccountsRepository;
import pc01815.Normal_J6.Services.AccountsService;

@RestController
@RequestMapping("api")
public class AccountsController {

	@Autowired
	AccountsService accountsService;
	
	@GetMapping("/accounts")
	public List<Accounts> getAll(){
		return accountsService.getAllService().stream().collect(Collectors.toList());
	}
//	
//	
	@PostMapping("/register")
	public ResponseEntity<Accounts> save(@RequestBody Accounts accounts){
		return new ResponseEntity<Accounts>(accountsService.saveAccountService(accounts),HttpStatus.CREATED);
	}
	
//	
	@GetMapping("/accounts/{username}")
	public Accounts getByUsername(@PathVariable("username") String username) {
		return accountsService.findByUsernameService(username);
	}
	
	@GetMapping("/home")
	public String home() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		String role = auth.getAuthorities().toString();
		System.err.println(role);
		System.err.println(name);
		return "home work";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse reps) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.isAuthenticated()) {
			System.err.println("đang có đăng nhập");
			 new SecurityContextLogoutHandler().logout(req, reps, auth);
		}
		return "was logout"; 
	}
}
