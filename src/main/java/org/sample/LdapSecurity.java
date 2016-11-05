package org.sample;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by aruna on 11/5/16.
 */
@Configuration
@EnableWebSecurity
public class LdapSecurity extends WebSecurityConfigurerAdapter {


    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().and().authorizeRequests().anyRequest().authenticated().and().csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.ldapAuthentication()
                .contextSource().url("ldap://localhost:10389/dc=example,dc=com")
                .managerDn("uid=admin,ou=system").managerPassword("secret")
                .and()
                .userSearchBase("ou=users")
                .userSearchFilter("(cn={0})");
    }
}
