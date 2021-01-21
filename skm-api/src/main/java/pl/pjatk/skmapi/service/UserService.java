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

        // Test admin
        repository.save( new User("user", passwordEncoder.encode("123"), "ROLE_USER"));

        // Test privileged
        repository.save( new User("privileged", passwordEncoder.encode("123"), "ROLE_PRIVILEGED"));

        // Test user
        repository.save( new User("admin", passwordEncoder.encode("123"), "ROLE_ADMIN"));
    }

    @Override
    public User getUpdatedEntity(User user) throws NotFoundException {
        var currentUser = repository.findById(user.getId());
        if (currentUser.isEmpty()) throw new NotFoundException();

        var currentUserObj = currentUser.get();

        if(user.getUsername() != null){
            currentUserObj.setLogin(user.getUsername());
        }

        return currentUserObj;
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
