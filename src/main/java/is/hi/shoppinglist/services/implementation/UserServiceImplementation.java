package is.hi.shoppinglist.services.implementation;

import is.hi.shoppinglist.entities.User;
import is.hi.shoppinglist.repositorys.ProductRepository;
import is.hi.shoppinglist.repositorys.UserRepository;
import is.hi.shoppinglist.services.UserService;
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
public class UserServiceImplementation implements UserService {
    private static final String ROLE_USER = "ROLE_USER";
    private UserRepository userRepository;


    @Autowired
    public UserServiceImplementation (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    //hlutur af spring security
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        final User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true, true, true, getAuthorities(ROLE_USER));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }

    public User findUserByUsername(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return null;
    }
}
