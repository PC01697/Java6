package pc01815.Normal_J6.Services;




import java.util.Collections;

import java.util.Collection;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
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


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Accounts account = accountsRepository.findByUsername(username);
			String pass = account.getPassword();

			Set<Authorities> roles = account.getAuthoritieses();
			for(Authorities a:roles) {
				System.out.println("Vai tro:"+a);
			}
//			String[] roles = account.getAuthoritieses().stream()
//					.map(au ->au.getRoles().getName())
//					.collect(Collectors.toList()).toArray(new String[0]);
//		System.out.println(roles);
				
			return User.withUsername(username).password(pass).roles("ADMIN").build();
		} catch (Exception e) {
			
			throw new UsernameNotFoundException(username+"not found!!");
			
		}
	}
	
 
	public void loginfromOAuth2(OAuth2AuthenticationToken oauth2) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		String email = oauth2.getPrincipal().getAttribute("name");
		String pass = Long.toHexString(System.currentTimeMillis());
		UserDetails user = User.withUsername(email).password(pe.encode(pass)).roles("User").build();
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
}
