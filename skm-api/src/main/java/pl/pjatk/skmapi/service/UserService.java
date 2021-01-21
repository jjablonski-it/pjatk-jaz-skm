package pl.pjatk.skmapi.service;

import org.springframework.data.jpa.repository.JpaRepository;
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
        repository.save( new User("admin", encodedPassword, "ROLE_USER"));
    }

    @Override
    public User getUpdatedEntity(User user) throws NotFoundException {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findAll().stream().filter(user -> user.getUsername().equals(username)).findAny().orElseThrow(() -> new UsernameNotFoundException("User " + username + " does not exist"));
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}
