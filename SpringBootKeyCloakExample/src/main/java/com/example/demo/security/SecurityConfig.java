package com.example.demo.security;

import org.keycloak.adapters.springsecurity.authentication.KeycloakLogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.client.RestTemplate;
@Configuration	
@EnableWebSecurity	
class SecurityConfig {	
	@Autowired
    private  LogoutHandler keycloakLogoutHandler;	
    	
    @Bean	
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {	
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());	
    }	
	
	  @Primary
	  
	  @Order(1)
	  
	  @Bean public SecurityFilterChain clientFilterChain(HttpSecurity http) throws
	  Exception { http.authorizeHttpRequests() .requestMatchers("/") .permitAll()
	  .anyRequest() .authenticated(); http.oauth2Login() .and() .logout()
	  .addLogoutHandler(keycloakLogoutHandler) .logoutSuccessUrl("/"); return
	  http.build(); }
	 
    	
	/*
	 * @Order(2)
	 * 
	 * @Bean public SecurityFilterChain resourceServerFilterChain(HttpSecurity http)
	 * throws Exception { http.authorizeHttpRequests() .requestMatchers("/Employee")
	 * .hasRole("admin") .requestMatchers("/Employee/get/") .hasRole("user")
	 * .anyRequest() .authenticated();
	 * http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt); return
	 * http.build(); }
	 */
	/*
	 * @Bean public AuthenticationManagerBuilder authenticationManager(HttpSecurity
	 * http) throws Exception { return (AuthenticationManagerBuilder)
	 * http.getSharedObject(AuthenticationManagerBuilder.class) .build(); }
	 */
    
}