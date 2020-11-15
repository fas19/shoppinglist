package is.hi.shoppinglist.repositorys;

import is.hi.shoppinglist.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    //Vista vöru
    Person save(Person person);
    //Fjarlægja vöru
//    void delete(User user);
    //Finna allar vörur
    //List<User> findAll();
    //finna allar vörur fyrir notanda

    //finna eftir id
    //Optional<User> findById(Long id);

    Person findByEmail(String email);

}
