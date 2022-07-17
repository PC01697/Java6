package pc01815.Normal_J6.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Repository.AccountsRepository;

@RestController
public class testController {

	@Autowired
	AccountsRepository accRepo;
	
	@RequestMapping("/test")
	public List<Accounts> getAll(){
		List<Accounts> list = accRepo.findAll();
		
		return list.stream().collect(Collectors.toList());
	}
}
