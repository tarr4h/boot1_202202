package com.tarr4h.boot.security.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	AuthenticationSuccessHandler successHandler = new CustomSuccessHandler();
	AuthenticationFailureHandler failHandler = new CustomFailureHandler();
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/index.jsp").permitAll()
		.antMatchers("/member/enrollMain").permitAll()
		.antMatchers("/member/memberEnroll").permitAll()
		.antMatchers("/member/login").permitAll()
		.antMatchers("/**").authenticated();
		
		http.formLogin()
		.loginPage("/member/login")
		.loginProcessingUrl("/login")
		.successHandler(successHandler)
		.failureHandler(failHandler)
		.usernameParameter("id")
		.passwordParameter("password")
		.permitAll();
		
		http.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/")
		.invalidateHttpSession(true);
		
		http.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}

	
	
}
