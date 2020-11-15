package is.hi.shoppinglist.services;

import is.hi.shoppinglist.entities.Product;
import is.hi.shoppinglist.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    User save(User user);
  //  void delete (User user);
   // List<Product> findAll();
   // Optional<Product> findById(Long id);
}
