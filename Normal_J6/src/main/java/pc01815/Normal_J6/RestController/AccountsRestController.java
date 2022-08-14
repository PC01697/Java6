package pc01815.Normal_J6.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Entity.Authorities;
import pc01815.Normal_J6.Entity.Category;
import pc01815.Normal_J6.Entity.Roles;
import pc01815.Normal_J6.Repository.AccountsRepository;
import pc01815.Normal_J6.Repository.RolesRepository;
import pc01815.Normal_J6.Services.AccountsService;
import pc01815.Normal_J6.Services.AuthoritiesService;
import pc01815.Normal_J6.Util.FileUploadUtil;

@RestController
@RequestMapping("api")
public class AccountsRestController {
	@Autowired
	AccountsRepository accountDAO;
	@Autowired
	AccountsService accountsService;
    @Autowired
    RolesRepository roleRepository;
	@Autowired
	AuthoritiesService AuthService;
	@Autowired
	HttpServletRequest req;
	@GetMapping(value = "/accounts")
	public List<Accounts> getAll(Model m){
		Accounts acc = accountDAO.findByUsername(req.getRemoteUser());
		m.addAttribute("id",acc);

		return accountsService.getAllService().stream().collect(Collectors.toList());
	}
//
	@GetMapping("/accounts/{username}")
	public Accounts getByUsername(@PathVariable("username") String username) {
		return accountsService.findByUsernameService(username);
	}
	
	@PostMapping(value = "/accounts", consumes = "application/json")
	public ResponseEntity<Accounts> saveAccount(@RequestBody @Valid Accounts account){
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		if(accountsService.checkAccountName(account.getUsername())> 0) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}else {
			account.setPassword(pe.encode(account.getPassword()));
			return new ResponseEntity<Accounts>(accountsService.saveAccountService(account),HttpStatus.CREATED);
		}
	}
	@PutMapping(value = "/accounts/{id}")
	public ResponseEntity<Accounts> updateAccount(@PathVariable("id") int id, @RequestBody Accounts account){
			Optional<Accounts> accountOption = accountsService.findByIdAccount(id);
			return (ResponseEntity<Accounts>) accountOption.map(c -> {
				account.setId(c.getId());
				return new ResponseEntity<>(accountsService.saveAccountService(account),HttpStatus.OK);
			}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/accounts/{idAccount}")
	public ResponseEntity<HttpStatus> deleteAccountById(@PathVariable("idAccount") int id){
		Authorities findAuthoriesByIdAccount = AuthService.authService(id);
		
		if(findAuthoriesByIdAccount != null) {
			System.err.println("ABCCC"+findAuthoriesByIdAccount.getAccounts().getFullname());
			AuthService.delete(findAuthoriesByIdAccount);
		}
		accountsService.deleteAccountById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
