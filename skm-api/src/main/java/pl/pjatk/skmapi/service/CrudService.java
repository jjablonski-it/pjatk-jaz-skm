package pl.pjatk.skmapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.pjatk.skmapi.repository.CrudRepo;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CrudService<T extends DbEntity> {
    CrudRepo<T> repository;

    public CrudService(CrudRepo<T> repository){
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
