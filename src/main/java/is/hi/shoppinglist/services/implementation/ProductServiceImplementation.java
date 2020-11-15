package is.hi.shoppinglist.services.implementation;

import is.hi.shoppinglist.entities.Product;
import is.hi.shoppinglist.repositorys.ProductRepository;
import is.hi.shoppinglist.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductServiceImplementation (ProductRepository repository){
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public void delete(Product product) {
        repository.delete(product);

    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    public List<Product> findByUserId (Long id){
        List<Product> all = repository.findAll();
        List<Product> userProducts = new ArrayList<>();

        for (Product temp : all){
            if (temp.getPerson().getId()==id){
                userProducts.add(temp);
            }
        }
        return userProducts;
    }

}
