package pc01815.Normal_J6.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import pc01815.Normal_J6.Services.AccountsService;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	AccountsService accountsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/abc/**")
		.access("hasRole('ROLE_ADMIN')")
		.antMatchers("/api/home/**")
		.access("hasRole('ROLE_USER')")
		.and()
		.formLogin()
		.and()
		.logout()
		.logoutUrl("/api/logout")
		.deleteCookies("JSESSIONID")
		.and()
		.httpBasic();
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			BCryptPasswordEncoder endcode = new BCryptPasswordEncoder();
			auth.userDetailsService(accountsService).passwordEncoder(endcode);
			
	}
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
//		builder.userDetailsService(accountsService);
//	}
	
	
	
}
