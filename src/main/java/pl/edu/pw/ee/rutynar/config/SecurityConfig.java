package pl.edu.pw.ee.rutynar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by kiker on 14.01.17.
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService ;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/", "/register").permitAll()
                .antMatchers("/parameters").hasAnyRole("ADMIN")
                .anyRequest().fullyAuthenticated()

                .and()

                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")

                .and()

                .logout()
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID")

                .and()

                .csrf();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

}
