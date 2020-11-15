package is.hi.shoppinglist.controllers;

import is.hi.shoppinglist.entities.User;
import is.hi.shoppinglist.services.UserService;
import is.hi.shoppinglist.services.implementation.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserServiceImplementation userService;

    @GetMapping("/login")
    private String getLogin() {
        return "login";
    }

    @GetMapping(value = "/signup")
    public ModelAndView registrationForm() {
        return new ModelAndView("registration", "user", new User());
    }

    @RequestMapping(value = "/register")
    public ModelAndView registerUser(User user){
        userService.registerNewUser(user);
        return new ModelAndView("redirect:/login");
    }


}
