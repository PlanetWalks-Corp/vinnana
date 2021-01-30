package com.ksush;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.hibernate.criterion.Restrictions.and;

@Configuration
public class Config extends WebSecurityConfigurerAdapter {

	private final Logger log = LoggerFactory.getLogger(Config.class);


	@Qualifier("myUserDetailsService")
	@Autowired
	private UserDetailsService userDetailsService;

//	used when using database as a storage
	@Bean
	public AuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());  //plain text password no hashing used
		provider.setPasswordEncoder(new BCryptPasswordEncoder()); //Bcryption used for passwords since in mysql we are saving the hash for the password
		log.debug(String.valueOf(provider));
		return provider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.antMatcher("/**")
			.authorizeRequests(authorize -> authorize.anyRequest().authenticated())
			.oauth2Login().loginPage("/login").permitAll()
				.and()
				//used when we are defining our own login page
			.formLogin()
			.loginPage("/login").permitAll()
			.and()
			.logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/logout-success").permitAll();
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
