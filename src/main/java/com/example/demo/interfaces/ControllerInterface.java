package com.example.demo.interfaces;

import org.springframework.http.ResponseEntity;


import java.util.List;

public interface ControllerInterface<T, DTO> {

    ResponseEntity<List<DTO>> getAll();

    ResponseEntity<T> save(T t);

    void delete(Long id);

    ResponseEntity<T> update(T t);

    ResponseEntity<DTO> findById(Long id);


}
