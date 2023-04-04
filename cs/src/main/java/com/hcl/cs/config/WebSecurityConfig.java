package com.hcl.cs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true,proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	 @Autowired
	 private UserDetailsService userDetailsService;
	
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
//	 @Bean
//	  public PasswordEncoder passwordEncoder() {
//	    return NoOpPasswordEncoder.getInstance();
//	  }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	      http.authorizeRequests()
	      .antMatchers("/resources/**", "/registration").permitAll()
	      .antMatchers("/static/**","/webjars/**").permitAll()
	      .antMatchers("/","/home").permitAll()
          .antMatchers("/updatePetAvailableStatus/**").permitAll()
	      .antMatchers("/signin").permitAll()
	      .antMatchers("/newPet").permitAll()
	      .antMatchers("/userPet").permitAll()
	      .antMatchers("/viewProfile").permitAll()
	      .antMatchers("/updateProfile").permitAll()
	      .antMatchers("/buyproduct/**").permitAll()
	      .antMatchers("/save").permitAll()
	      .antMatchers("/logout").permitAll()
	      .anyRequest().authenticated()
	      .and()
	      .formLogin().loginPage("/login").permitAll()
	      .and()
	      .logout().permitAll()
	      .and()
	      .exceptionHandling().accessDeniedPage("/403");
	      
	      
	      
	}
	/**In order to do DB authentication Spring Security provide inbuilt Interface called UserDetailsService Interface 
	 which fetch USername and Password from the DB and Check it is correct or not **/
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

}
