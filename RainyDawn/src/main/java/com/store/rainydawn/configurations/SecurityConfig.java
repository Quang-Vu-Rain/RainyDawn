package com.store.rainydawn.configurations;

import com.store.rainydawn.JWT.JwtTokenFilter;
import com.store.rainydawn.dao.AccountDAO;
import com.store.rainydawn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountDAO accountDAO;

    @Autowired
    JwtTokenFilter jwtTokenFilter;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//        auth.userDetailsService(username -> {
//            try {
//                Accounts accounts = accountService.getAccountByUsername("AdminToiCao");
//                String password = bCryptPasswordEncoder.encode(accounts.getPassword());
//                String [] roles = accounts.getAuthorities().stream()
//                        .map(er -> er.getRoles().getId())
//                        .collect(Collectors.toList()).toArray(new String[0]);
//                return User.withUsername(username).password(password).roles(roles).build();
//            } catch (Exception e) {
//                throw new UsernameNotFoundException(username + "NOT FOUND!");
//            }
//        });
//        auth.inMemoryAuthentication().withUser("admin1").password(passwordEncoder().encode("123456")).
//                authorities("DEV");
        auth.userDetailsService(username -> accountDAO.findByUsername(username));
    }


    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.exceptionHandling().authenticationEntryPoint(
                (request, response, authException) -> {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
                }
        );
        http.authorizeRequests().antMatchers("/auth/login").permitAll().anyRequest().authenticated();
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
