package pl.pjatk.skmapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.skmapi.exception.InternalServerException;
import pl.pjatk.skmapi.service.CrudService;
import pl.pjatk.skmapi.service.DbEntity;

import java.util.List;

public abstract class CrudController<T extends DbEntity> {
    @Autowired
    private final CrudService<T> service;

    protected CrudController(CrudService<T> service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<T>> getAll() throws InternalServerException {
        var payload = service.getAll();
        return new ResponseEntity<>(payload, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable("id") long id) {
        var payload = service.getById(id);
        return new ResponseEntity<>(payload, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<T> deleteById(@PathVariable("id") long id) {
        var payload = service.getById(id);
        return new ResponseEntity<>(payload, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<T> add(@RequestBody T t) {
        var payload = service.add(t);
        return new ResponseEntity<>(payload, HttpStatus.OK);
    }

    // IDK
    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity handleInternalError(InternalServerException e) {
        e.printStackTrace();
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
