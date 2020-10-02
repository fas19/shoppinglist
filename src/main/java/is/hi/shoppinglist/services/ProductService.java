package is.hi.shoppinglist.services;

import is.hi.shoppinglist.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product product);
    void delete (Product product);
    List<Product> findAll();
    Optional<Product> findById(Long id);
}
