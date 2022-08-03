package pc01815.Normal_J6;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Entity.Authorities;
import pc01815.Normal_J6.Services.AccountServiceImpl;
import pc01815.Normal_J6.Services.AccountsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	AccountsService accountService;
	@Autowired
	AccountServiceImpl accountImpl;
//	@Autowired
//	BCryptPasswordEncoder pe;
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(accountImpl);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//		http.authorizeRequests()
//			.antMatchers("/order/**").authenticated()
//			.antMatchers("/admin/**").hasAnyRole("ADMIN")
//			.antMatchers("/rest/authorities").hasRole("ADMIN")
//			.anyRequest().permitAll();
//		
//		http.formLogin()
//			.loginPage("/security/login/form")
//			.loginProcessingUrl("/security/login")
//			.defaultSuccessUrl("/index",false)
//			.failureUrl("/security/login/error");
//		
//		http.exceptionHandling()
//			.accessDeniedPage("/security/unauthoried");
//		
//		http.logout()
//			.logoutUrl("/security/logout")
//			.logoutSuccessUrl("/security/logout/success");
	}
	
	
	
	
}
