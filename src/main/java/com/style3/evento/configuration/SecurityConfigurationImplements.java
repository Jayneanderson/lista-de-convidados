package com.style3.evento.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfigurationImplements extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeRequests().anyRequest().authenticated().and()
		.formLogin().permitAll().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder amb) throws Exception {
			
		amb.inMemoryAuthentication().withUser("jay").password("{noop}1234").roles("ADMIN");
	}
	
	/*serve para passar as pastas estáticas, mas no meu caso eu usei o bootstrap online
	 * @Override public void configure(WebSecurity webSecurity) {
	 * 
	 * webSecurity.ignoring().antMatchers("/bootstrap/**"); }
	 *
	 */
	
}


