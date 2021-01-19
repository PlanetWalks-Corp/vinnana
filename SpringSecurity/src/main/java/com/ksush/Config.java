package com.ksush;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {

	@Qualifier("myUserDetailsService")
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public AuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); //plain text password
		return provider;
	}

//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//
//		List<UserDetails> users= new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder()
//				.username("ksush")
//				.password("_ksush0222")
//				.roles("USER")
//				.build());
//		return new InMemoryUserDetailsManager(users);
//	}
}
