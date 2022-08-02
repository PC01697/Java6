package pc01815.Normal_J6.Services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Entity.Authorities;

<<<<<<< HEAD
public interface AccountsService extends UserDetailsService {
=======
public interface AccountsService{
>>>>>>> branch 'master' of https://github.com/trung3/Normal_J6.git

	List<Accounts> getAllService();
	
	Accounts saveAccountService(Accounts accounts);
	
	Accounts findByUsernameService(String username);

    

}
