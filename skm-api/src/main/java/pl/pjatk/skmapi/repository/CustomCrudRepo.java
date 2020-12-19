package pl.pjatk.skmapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomCrudRepo<T> extends CrudRepository<T, Long> {
    @Override
    List<T> findAll();
}
