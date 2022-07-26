package aviasales.project.config;

import aviasales.project.dao.*;
import aviasales.project.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Scope("singleton")
public class BeansConfig {

    @Bean
    public UserDAO userDAO(){
        return new UserDAOImpl();
    }

    @Bean
    public RoleDAO roleDAO(){
        return new RoleDAOImpl();
    }

    @Bean
    public AircraftsDAO aircraftsDAO(){
        return new AircraftsDAOImpl();
    }


    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
