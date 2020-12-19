package pl.pjatk.skmapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.pjatk.skmapi.repository.CustomCrudRepo;

import java.util.List;

public abstract class CrudService<T> {
    @Autowired
    CustomCrudRepo repository;

    public CrudService(CustomCrudRepo<T> repository){
        this.repository = repository;
    }

    public List<T> getAll(){
       return repository.findAll();
    }
}
