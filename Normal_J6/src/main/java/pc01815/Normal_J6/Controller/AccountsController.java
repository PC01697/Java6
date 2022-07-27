package pc01815.Normal_J6.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Services.AccountsService;
import pc01815.Normal_J6.Util.FileUploadUtil;

@RestController
@RequestMapping("api")
public class AccountsController {

	@Autowired
	AccountsService accountsService;

	
	@GetMapping(value = "/accounts", produces = "application/json")
	public List<Accounts> getAll(){
		return accountsService.getAllService().stream().collect(Collectors.toList());
	}

	@PostMapping("/register")
	public ResponseEntity<Accounts> save(@RequestBody Accounts accounts){
		return new ResponseEntity<Accounts>(accountsService.saveAccountService(accounts),HttpStatus.CREATED);
	}
	

	@GetMapping("/accounts/{username}")
	public Accounts getByUsername(@PathVariable("username") String username) {
		return accountsService.findByUsernameService(username);
	}
	
	
	
	
}
