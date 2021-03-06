package aviasales.project.controllers;

import aviasales.project.dao.*;
import aviasales.project.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    AircraftsDAO aircraftsDAO;

    @Autowired
    CityDAO cityDAO;

    @Autowired
    CountryDAO countryDAO;

    @Autowired
    FlightDAO flightDAO;

    @Autowired
    PricesDAO pricesDAO;

    @Autowired
    RoutesDAO routesDAO;

    public Users getUserData(){
        Users user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            User ud = (User)authentication.getPrincipal();
            user = userDAO.getUser(ud.getUsername());
        }
        return user;
    }


    @RequestMapping(value = "/adminpanel",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mw = new ModelAndView("admin/index");
        return mw;
    }

    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView mw=new ModelAndView("admin/registration");
        return mw;
    }

    @RequestMapping(value = "/registration1",method = RequestMethod.POST)
    public ModelAndView registration1(@RequestParam(name = "user_email")String email,
                                      @RequestParam(name = "user_password")String password,
                                      @RequestParam(name = "fullname")String fullname,
                                      @RequestParam(name = "role")String role){

        Roles role1=roleDAO.getRole(role);
        Set<Roles> rolesSet=new HashSet<>();
        rolesSet.add(role1);
        Users user=new Users(null,email,password,fullname,rolesSet);
        userDAO.addUser(user);
        ModelAndView mw=new ModelAndView("/index");
        return mw;
    }

    @RequestMapping(value = "admin/aircrafts",method = RequestMethod.GET)
    public ModelAndView aircraft(){
        ModelAndView mw=new ModelAndView("admin/aircraft");
        return mw;
    }

    @RequestMapping(value = "admin/flights",method = RequestMethod.GET)
    public ModelAndView flights(){
        ModelAndView mw=new ModelAndView("admin/flights");
        return mw;
    }

    @RequestMapping(value = "admin/prices",method = RequestMethod.GET)
    public ModelAndView prices(){
        ModelAndView mw=new ModelAndView("admin/prices");
        return mw;
    }

    @RequestMapping(value = "/getIdByAircraft/{id}",method = RequestMethod.GET)
    public Aircrafts getIdAircraft(@PathVariable int id){
        Aircrafts aircraft=aircraftsDAO.getAircraftById((long) id);

        System.out.println(aircraft.getModel()+"  "+aircraft.getName());
        System.out.println(aircraft);
        return aircraft;
    }

    @RequestMapping(value = "/saveAircraft",method = RequestMethod.GET)
    public  void saveAircraft(@RequestBody Aircrafts aircraft){
        aircraftsDAO.addAircraft(aircraft);
    }

    @RequestMapping(value = "/updateAircraft",method = RequestMethod.GET)
    public void updateAircraft(@RequestBody Aircrafts aircraft){
        aircraftsDAO.updateAircraft(aircraft);
    }

    @RequestMapping(value = "deleteAircraft",method = RequestMethod.GET)
    public void deleteAircraft(@RequestParam long id){
        Aircrafts aircraft=aircraftsDAO.getAircraftById(id);
        aircraftsDAO.deleteAircraft(aircraft);
        System.out.println("Aircraft deleted successfully");
    }

    @RequestMapping(value = "/saveCity",method = RequestMethod.GET)
    public void saveCity(@RequestBody Cities cities){
        cityDAO.addCity(cities);
        System.out.println("City saved successfully");
    }

    @RequestMapping(value = "/updateCity",method = RequestMethod.GET)
    public void updateCity(@RequestBody Cities city){
        cityDAO.updateCity(city);
        System.out.println("City has been updated");
    }

    @RequestMapping(value = "/deleteCity",method = RequestMethod.GET)
    public void deleteCity(@RequestBody Cities city){
        cityDAO.deleteCity(city);
        System.out.println("City deleted successfully");
    }










}
