package com.example.demo.interfaces;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ServiceInterface<T> {

    Iterable<T> findAll();

    Page<T> findAll(Pageable pageable);

    Optional<T> findById(long id);

    T save(T t);

    void delete(long id);

}
