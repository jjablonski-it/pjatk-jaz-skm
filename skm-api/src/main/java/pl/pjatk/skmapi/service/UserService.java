package pl.pjatk.skmapi.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pl.pjatk.skmapi.exception.NotFoundException;
import pl.pjatk.skmapi.model.User;

@Service
public class UserService extends CrudService<User>{
    public UserService(JpaRepository<User, Long> repository) {
        super(repository);
    }

    @Override
    public User getUpdatedEntity(User user) throws NotFoundException {
        return null;
    }
}
