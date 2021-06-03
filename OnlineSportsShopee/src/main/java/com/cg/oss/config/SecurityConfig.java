package com.cg.oss.config;

import org.springframework.context.annotation.Configuration;




import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

 

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

 

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("dhivya")
            .password("{noop}dhivya117")
            .roles("ADMIN")
            .and()
            .withUser("john")
            .password("{noop}password")
            .roles("USER");
    }

 

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
         .csrf().disable()
         /*.logout()
         .invalidateHttpSession(true)
         .and()*/
         .authorizeRequests()
         .antMatchers("/").permitAll()
         .antMatchers("/product/add").hasRole("ADMIN")
         .antMatchers("/product/update/*", "/product/delete/*").hasRole("ADMIN")
         .anyRequest().authenticated()
         .and()
         .httpBasic();
    }
    
}
 