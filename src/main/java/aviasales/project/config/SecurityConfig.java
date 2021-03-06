package aviasales.project.config;

import aviasales.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/cashier/**").hasRole("CASHIER")
                .antMatchers("/user/**").hasAnyRole("ADMIN","CASHIER","USER")
                //.antMatchers("/profile/**").hasAnyRole("ADMIN","CASHIER","USER")
                .antMatchers("/login", "/*")
                .permitAll();

        http.formLogin()
                .loginProcessingUrl("/signin")
                .loginPage("/login")
                .failureUrl("/login?error")
                .usernameParameter("user_email")
                .passwordParameter("user_password")
                .permitAll();

        http.logout()
                .logoutUrl("/signout")
                .logoutSuccessUrl("/login")
                .permitAll()
                .invalidateHttpSession(true);

        http.csrf().disable();
    }

}


