package com.ecomm.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Silviu on 1/30/16.
 */

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //elimin cauze de 403
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/bower_components/**", "/app/**", "/").permitAll() //url uri pt non-auth
                .anyRequest().authenticated()
                .and()
                .logout();

    }

}