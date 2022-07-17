package aviasales.project.controllers;

import aviasales.project.dao.UserDAO;
import aviasales.project.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
public class MainController {

    @Autowired
    UserDAO userDAO;

    public Users getUserData(){
        Users user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            User ud = (User)authentication.getPrincipal();
            user = userDAO.getUser(ud.getUsername());
        }
        return user;
    }

    @RequestMapping(value = "/")
    public ModelAndView mw(){
        ModelAndView mw=new ModelAndView("index");
        return mw;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView mw=new ModelAndView("login");
        return mw;
    }

    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public ModelAndView profile(){
        ModelAndView mw=new ModelAndView("profile");
        mw.addObject("user",getUserData());
        return mw;
    }

    @RequestMapping(value = "/profile/delete",method = RequestMethod.GET)
    public String delete(@RequestParam(name = "email") String email){

        Users user=userDAO.getUser(email);
        userDAO.deleteUser(user);
        return "redirect:/";
    }











}
