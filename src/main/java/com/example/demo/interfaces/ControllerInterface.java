package com.example.demo.interfaces;

import com.example.demo.dto.musicoDto.MusicoDTO;
import com.example.demo.entities.Musico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface ControllerInterface<T, DTO> {

    ResponseEntity<List<DTO>> getAll();

    ResponseEntity<T> save(T t);

    void delete(long id);

    ResponseEntity<T> update(T t, long id);

    ResponseEntity<DTO> findById(long id);


}
