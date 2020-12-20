package pl.pjatk.skmapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CrudService<T extends DbEntity> {
    JpaRepository<T, Long> repository;

    public CrudService(JpaRepository<T, Long> repository){
        this.repository = repository;
    }

    public List<T> getAll(){
       return repository.findAll();
    }

    public T getById(Long id){
        return repository.findById(id).orElse(null);
    }

    public T add(T t){ return repository.save(t);}

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public List<Long> getIds(){
       return getAll().stream().map(t -> t.getId()).collect(Collectors.toList());
    }
}
