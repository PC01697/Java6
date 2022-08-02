package pc01815.Normal_J6.Services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Entity.Authorities;

public interface AccountsService{

	List<Accounts> getAllService();
	
	Accounts saveAccountService(Accounts accounts);
	
	Accounts findByUsernameService(String username);

//	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;


}
