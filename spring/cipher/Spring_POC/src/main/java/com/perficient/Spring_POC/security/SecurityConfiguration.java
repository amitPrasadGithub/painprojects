package com.perficient.Spring_POC.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
//		http.httpBasic().and().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/rest/admin/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/rest/admin/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/rest/admin/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/rest/admin/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/rest/students/**").hasAnyRole("USER", "ADMIN")
				.antMatchers(HttpMethod.GET, "/rest/students/**").permitAll()
				.antMatchers(HttpMethod.POST, "/rest/authenticate").permitAll()
				.antMatchers("/").permitAll()
				.and().formLogin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
