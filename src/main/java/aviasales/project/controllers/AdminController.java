package aviasales.project.controllers;

import aviasales.project.dao.RoleDAO;
import aviasales.project.dao.UserDAO;
import aviasales.project.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    RoleDAO roleDAO;

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
                                      @RequestParam(name = "full_name")String full_name,
                                      @RequestParam(name = "role")String role){

        Users user=new Users(null,email,password,full_name);
        userDAO.getUserById(user.getId());


        ModelAndView mw=new ModelAndView("/");
        return mw;
    }





}
