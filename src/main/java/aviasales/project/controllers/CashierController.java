package aviasales.project.controllers;

import aviasales.project.dao.TicketsDAO;
import aviasales.project.dao.UserDAO;
import aviasales.project.entities.Tickets;
import aviasales.project.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/cashier")
public class CashierController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    TicketsDAO ticketsDAO;

    public Users getUserData(){
        Users user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            User ud = (User)authentication.getPrincipal();
            user = userDAO.getUser(ud.getUsername());
        }
        return user;
    }

    @RequestMapping(value = "/cashierpanel",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mw = new ModelAndView("cashier/index");
        return mw;
    }

    @RequestMapping(value = "/addTicket",method = RequestMethod.GET)
    public void addTicket(@RequestBody Tickets ticket){
        ticketsDAO.addTicket(ticket);
    }

    @RequestMapping(value = "/updateTicket",method = RequestMethod.GET)
    public void updateTicket(@RequestBody Tickets ticket){
        ticketsDAO.updateTicket(ticket);
    }

    @RequestMapping(value = "/deleteTicket",method = RequestMethod.GET)
    public void deleteTicket(@RequestBody Tickets ticket){
        ticketsDAO.deleteTicket(ticket);
        System.out.println("Deleted successfully ticket");
    }









}
