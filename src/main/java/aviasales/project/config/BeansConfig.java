package aviasales.project.config;

import aviasales.project.dao.*;
import aviasales.project.entities.Flights;
import aviasales.project.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
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
    public CityDAO cityDAO(){
        return new CityDAOImpl();
    }

    @Bean
    public CountryDAO countryDAO(){
        return new CountryDAOImpl();
    }

    @Bean
    public FlightDAO flightDAO(){
        return new FlightsDAOImpl();
    }

    @Bean
    public PricesDAO pricesDAO(){
        return new PricesDAOImpl();
    }

    @Bean
    public RoutesDAO routesDAO(){
        return new RoutesDAOImpl();
    }

    @Bean
    public TicketsDAO ticketsDAO(){return new TicketsDAOImpl();}

    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
