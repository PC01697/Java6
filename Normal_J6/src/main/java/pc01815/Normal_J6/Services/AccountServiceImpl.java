package pc01815.Normal_J6.Services;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Entity.Authorities;
import pc01815.Normal_J6.Entity.Roles;
import pc01815.Normal_J6.Repository.AccountsRepository;
import pc01815.Normal_J6.Repository.AuthoritiesRepository;
import pc01815.Normal_J6.Repository.RolesRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountsService{

	@Autowired
	AccountsRepository accountsRepository;
	
	@Autowired
	AuthoritiesRepository authRepo;
	
	@Autowired
	RolesRepository roleRepo;

	@Override
	public List<Accounts> getAllService() {
		List<Accounts> listAccount = accountsRepository.findAll();
		return listAccount;
	}

	@Override
	public Accounts saveAccountService(Accounts accounts) {
		
		return accountsRepository.save(accounts);
	}

	@Override
	public Accounts findByUsernameService(String username) {
		return accountsRepository.findByUsername(username);
	}
	
	
	
	
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Accounts accounts = accountsRepository.findByUsername(username);
//		String roleName = null;
//		if(accounts == null) {
//			throw new UsernameNotFoundException("Invalide username");
//		}else {
//			String[] role = accounts.getAuthoritieses().stream().map(t -> t.getRoles().getName()).collect(Collectors.toList()).toArray(new String[0]); 	
//			for (String string : role) {
//				roleName = string;
//			}
//		}
//		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//		grantedAuthorities.add(new SimpleGrantedAuthority(roleName));
//		return User.withUsername(accounts.getUsername()).password(accounts.getPassword()).roles(roleName).build();
//	
//		
//	}


	
	
	
}
