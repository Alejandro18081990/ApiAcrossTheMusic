package com.example.demo.services;

import com.example.demo.entities.Estilo;
import com.example.demo.interfaces.ServiceInterface;
import com.example.demo.repositorios.EstiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstiloServiceImpl implements ServiceInterface<Estilo> {

    @Autowired
    private EstiloRepository estiloRepository;

    @Override
    public List<Estilo> findAll() {
        return estiloRepository.findAll();
    }

    @Override
    public Page<Estilo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Estilo> findById(long id) {
        return estiloRepository.findById(id);
    }

    @Override
    public Estilo save(Estilo estilo) {
        return estiloRepository.save(estilo);
    }

    @Override
    public void delete(long id) {
        estiloRepository.deleteById(id);
    }
}
