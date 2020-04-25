package com.spring.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	public void configure(AuthenticationManagerBuilder amb) throws Exception {
		
		amb.inMemoryAuthentication()
			.withUser("cipher")
			.password("1234")
			.roles("USER")
			.and()
			.withUser("dxo")
			.password("dxo")
			.roles("ADMIN");
		
		}
	
		@Bean
		public PasswordEncoder getPasswordEncoder() {
			return NoOpPasswordEncoder.getInstance();
		}
		
		public void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
				.antMatchers("/admin").hasAnyRole("ADMIN")
				.antMatchers("/user").hasAnyRole("USER", "ADMIN")
				.antMatchers("/").permitAll()
				.and()
				.formLogin();
		}
}
