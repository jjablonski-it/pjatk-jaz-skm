package pl.pjatk.skmapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.skmapi.exception.BadRequestException;
import pl.pjatk.skmapi.exception.NotFoundException;
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
    public ResponseEntity<List<T>> getAll() {
        try {

            var payload = service.getAll();
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable("id") Long id) {
        try {
            var payload = service.getById(id);
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        try {
            service.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<T> add(@RequestBody T t) {
        try {
            var payload = service.add(t);
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<T> update(@RequestBody T t) {
        try {
            var payload = service.update(t);
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } catch (BadRequestException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
