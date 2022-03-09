package uk.ac.rhul.cs2810.restaurantsystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] resources  =  {
                "/style/**",
                "/img/**",
                "/scripts/**",
                "/",
                "/order",
                "/menu",
                "/payment",
                "/login**"

        };
        http
                .authorizeRequests()
                    .antMatchers(resources).permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/waiter", true)
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails waiter =
                User.withUsername("waiter")
                        //.password(encoder().encode("admin"))
                        .password("admin")
                        .roles("WAITER")
                        .build();
      /*  UserDetails kitchen =
                User.withUsername("kitchen")
                        .username("kitchen")
                        .password(encoder().encode("pass"))
                        .roles("KITCHEN")
                        .build();*/

        return new InMemoryUserDetailsManager(waiter);
    }
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
