package is.hi.shoppinglist.services.implementation;

import is.hi.shoppinglist.entities.Person;
import is.hi.shoppinglist.repositorys.PersonRepository;
import is.hi.shoppinglist.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class PersonServiceImplementation implements PersonService {
    private static final String ROLE_USER = "ROLE_USER";
    private PersonRepository personRepository;


    @Autowired
    public PersonServiceImplementation(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Person registerNewUser(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        return personRepository.save(person);
    }
    //hlutur af spring security
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        final Person person = personRepository.findByEmail(email);
        if (person == null) {
            throw new UsernameNotFoundException("No user found with username: " + email);
        }
        return new org.springframework.security.core.userdetails.User(person.getEmail(), person.getPassword(), true, true, true, true, getAuthorities(ROLE_USER));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }

    public Person findUserByUsername(String email){
        return personRepository.findByEmail(email);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }
}
