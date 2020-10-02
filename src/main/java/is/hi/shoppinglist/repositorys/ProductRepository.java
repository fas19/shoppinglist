package is.hi.shoppinglist.repositorys;

import is.hi.shoppinglist.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //Vista vöru
    Product save(Product product);
    //Fjarlægja vöru
    void delete(Product product);
    //Finna allar vörur
    List<Product> findAll();
    //finna allar vörur fyrir notanda

    //finna eftir id
    Optional<Product> findById(Long id);

}
