package is.hi.shoppinglist.repositorys;

import is.hi.shoppinglist.entities.Product;
import is.hi.shoppinglist.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //Vista vöru
    User save(User user);
    //Fjarlægja vöru
//    void delete(User user);
    //Finna allar vörur
    //List<User> findAll();
    //finna allar vörur fyrir notanda

    //finna eftir id
    //Optional<User> findById(Long id);

    User findByEmail(String email);

}
