//package com.clouddigital.jobs.securityconfig;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
//	private String ROLE_RECRUIT="recruiter";
//	private String ROLE_USER = "user";
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		auth.inMemoryAuthentication().
//			withUser("admin").password(passwordEncoder().encode("recruiter@123")).roles(ROLE_RECRUIT).
//			and().
//			withUser("user").password(passwordEncoder().encode("user@123")).roles(ROLE_USER);
//		
//		//auth.authenticationProvider(new DaoAuthenticationProviPanka
//		
//	}
//	
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		http.authorizeRequests()
//			.antMatchers("/test/admin").hasRole(ROLE_RECRUIT)
//			.antMatchers("/test/user").hasAnyRole(ROLE_RECRUIT, ROLE_USER)
//			.antMatchers("/hello").permitAll()
//			.and().formLogin();
//	}
//}
