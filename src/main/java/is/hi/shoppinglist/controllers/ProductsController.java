package is.hi.shoppinglist.controllers;

import is.hi.shoppinglist.entities.Person;
import is.hi.shoppinglist.entities.Product;
import is.hi.shoppinglist.services.implementation.ProductServiceImplementation;
import is.hi.shoppinglist.services.implementation.PersonServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductsController {
    @Autowired
    PersonServiceImplementation userService;

    @Autowired
    ProductServiceImplementation productService;

    @RequestMapping("/products")
    private String getProducts(@CurrentSecurityContext(expression = "authentication.name") String username, Model model){

        Person person = userService.findUserByUsername(username);

        List<Product> userProducts = productService.findByUserId(person.getId());

        model.addAttribute("products", userProducts);


        return "products";
    }

    @RequestMapping(value="/addproduct", method = RequestMethod.GET)
    public String addProductForm(@CurrentSecurityContext(expression = "authentication.name") String username, Model model){

        Person thePerson = userService.findUserByUsername(username);
        Product product = new Product();
        model.addAttribute(product);
        model.addAttribute(thePerson);

        List<Product> userProducts = productService.findByUserId(thePerson.getId());

        model.addAttribute("products", userProducts);
        return"addproduct";
    }

    @RequestMapping(value="/addproduct", method=RequestMethod.POST)
    public ModelAndView addProduct(@CurrentSecurityContext(expression = "authentication.name") String username, @ModelAttribute("product") Product product, Model model, BindingResult result){
        if(result.hasErrors()){
            return new ModelAndView("/addproduct");
        }

        Person person = userService.findUserByUsername(username);
        product.setPerson(person);
        product.setInShoppingList(true);

        productService.save(product);

        return new ModelAndView("redirect:/addproduct");
    }

    @RequestMapping(value = "/products/change/{id}", method = RequestMethod.GET)
    public ModelAndView changeProduct(@CurrentSecurityContext(expression = "authentication.name") String username, @PathVariable("id")long id, Model model){
        Product product = productService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Product ID"));
        product.setInShoppingList(!product.isIsInShoppingList());
        Person person = userService.findUserByUsername(username);
        if (product.getPerson().getId()== person.getId())
            productService.save(product);
        return new ModelAndView("redirect:/products");
    }

    @RequestMapping(value="/products/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteProduct(@CurrentSecurityContext(expression = "authentication.name") String username, @PathVariable("id")long id, Model model){
        Product product = productService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid product ID"));
        Person person = userService.findUserByUsername(username);
        if(product.getPerson().getId()== person.getId())
            productService.delete(product);
        return new ModelAndView("redirect:/deleteproduct");
    }

    @RequestMapping(value="/deleteproduct")
    public String deleteProducts(@CurrentSecurityContext(expression = "authentication.name") String username, Model model){

        Person person = userService.findUserByUsername(username);

        List<Product> userProducts = productService.findByUserId(person.getId());

        model.addAttribute("products", userProducts);

        return "deleteproduct";

    }
}
