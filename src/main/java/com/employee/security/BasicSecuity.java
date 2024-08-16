package com.employee.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class BasicSecuity {
	@Bean
	SecurityFilterChain sfc(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((req) -> req.requestMatchers("/register").permitAll().anyRequest().permitAll())
				.httpBasic(Customizer.withDefaults());
		http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.csrf(c -> c.disable());
		return http.build();

	}

	@Autowired
	UserDetailsService userDetailsService;

	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

//	In memory user details
	// @Bean
//	public UserDetailsService userdetailsservice() {
//		UserDetails user1=User.withUsername("user1").
//								password("{noop}1234").roles("user").build();
//		UserDetails admin=User.withUsername("admin").
//				password("{noop}admin").roles("admin").build();
//		
//		return new InMemoryUserDetailsManager(user1,admin);
//	}

}
