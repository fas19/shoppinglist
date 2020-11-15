package is.hi.shoppinglist.services;

import is.hi.shoppinglist.entities.Product;
import is.hi.shoppinglist.entities.User;
import is.hi.shoppinglist.repositorys.ProductRepository;
import is.hi.shoppinglist.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    @Autowired
    ProductRepository pr;

    @Autowired
    UserRepository urr;

    @Override
    public void run(String... args) throws Exception {
//        User user1 = new User("fannar");
//        User user2 = new User("Kolfinna");
//        urr.save(user1);
//        urr.save(user2);
//
//        Product p = new Product("Sveppir", true,user1);
//        Product p2 = new Product("Tómatar",true, user1);
//        Product p3 = new Product("Kolfinna", false, user2);
//
//        pr.save(p);
//        pr.save(p2);
//        pr.save(p3);





    }
}
