package pl.pjatk.skmapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.skmapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
