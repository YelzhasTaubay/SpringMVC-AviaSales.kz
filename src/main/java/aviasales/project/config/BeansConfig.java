package aviasales.project.config;

import aviasales.project.dao.RoleDAO;
import aviasales.project.dao.RoleDAOImpl;
import aviasales.project.dao.UserDAO;
import aviasales.project.dao.UserDAOImpl;
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
    public BCryptPasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
