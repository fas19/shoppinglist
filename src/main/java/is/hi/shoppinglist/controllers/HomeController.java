package is.hi.shoppinglist.controllers;

import is.hi.shoppinglist.entities.Product;
import is.hi.shoppinglist.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    private ProductService productService;

    @Autowired
    public HomeController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("products", productService.findAll());
        return "home";
    }

    @RequestMapping(value="/addproduct", method = RequestMethod.GET)
    public String addProductForm(Model model){
        Product product = new Product();
        model.addAttribute(product);
        return"addproduct";
    }

    @RequestMapping(value="/addproduct", method=RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product, Model model, BindingResult result){
        if(result.hasErrors()){
            return "addproduct";
        }
        productService.save(product);
        model.addAttribute("products", productService.findAll());
        return "home";
    }

    @RequestMapping(value = "change/{id}", method = RequestMethod.GET)
    public String changeProduct(@PathVariable("id")long id, Model model){
        Product product = productService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Product ID"));
        product.setInShoppingList(!product.isIsInShoppingList());
        productService.save(product);
        model.addAttribute("products", productService.findAll());
        return "home";
    }
}
