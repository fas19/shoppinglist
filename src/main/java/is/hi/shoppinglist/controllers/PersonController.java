package is.hi.shoppinglist.controllers;

import is.hi.shoppinglist.entities.Person;
import is.hi.shoppinglist.services.implementation.PersonServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {

    @Autowired
    PersonServiceImplementation userService;

    @GetMapping("/login")
    private String getLogin() {
        return "login";
    }

    @GetMapping(value = "/signup")
    public ModelAndView registrationForm() {
        return new ModelAndView("registration", "person", new Person());
    }

    @RequestMapping(value = "/register")
    public ModelAndView registerUser(Person person){
        userService.registerNewUser(person);
        return new ModelAndView("redirect:/login");
    }


}
