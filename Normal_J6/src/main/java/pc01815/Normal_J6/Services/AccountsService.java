package pc01815.Normal_J6.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Entity.Authorities;
import pc01815.Normal_J6.Entity.Category;


public interface AccountsService extends UserDetailsService {


	List<Accounts> findAllAccountService();
	List<Accounts> getAllService();
	
	Accounts saveAccountService(Accounts accounts);
	
	Accounts findByUsernameService(String username);

	void deleteAccountById(int id);

	int checkAccountName(String username);
	Optional<Accounts> findByIdAccount(int id);
	
	
}
