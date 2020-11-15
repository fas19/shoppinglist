package is.hi.shoppinglist.services;

import is.hi.shoppinglist.entities.Person;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface PersonService extends UserDetailsService {
    Person save(Person person);
  //  void delete (User user);
   // List<Product> findAll();
   // Optional<Product> findById(Long id);
}
