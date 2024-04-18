package com.example.demo.services.musicoServices;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entities.Musico;


public interface MusicoService {

    Iterable<Musico> findAll();

    Page<Musico> findAll(Pageable pageable);

    Optional<Musico> findById(long id);

    List<Musico> findByEstiloAndInstrumento(String nombreInstrumento, String nombreEstilo);

    Musico save(Musico musico);

    List<Musico> findMusicoByMusicoTocaJam(long idJam);

    void delete(long id);
}
