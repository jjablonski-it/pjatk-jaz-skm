package pl.pjatk.skmapi.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.pjatk.skmapi.exception.NotFoundException;
import pl.pjatk.skmapi.model.User;

@Service
public class UserService extends CrudService<User> implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;

    public UserService(JpaRepository<User, Long> repository) {
        super(repository);
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        // Test user
        var encodedPassword = passwordEncoder.encode("123");
        repository.save( new User("admin", encodedPassword, "ROLE_ADMIN"));
    }

    @Override
    public User getUpdatedEntity(User user) throws NotFoundException {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        return repository.findAll().stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);
//        .orElseThrow(() -> new UsernameNotFoundException("User " + username + " does not exist")
    }

    @Override
    public User add(User user) {
        GrantedAuthority defaultAuthority = () -> "ROLE_USER";
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);
        user.addAuthority(defaultAuthority);

        return super.add(user);
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}
