package com.example.demo.services;

import com.example.demo.entities.Grupo;
import com.example.demo.interfaces.ServiceInterface;
import com.example.demo.repositorios.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//PENDIENTE REPASO
@Service
public class GrupoServiceImpl implements ServiceInterface<Grupo> {

    @Autowired
    GrupoRepository grupoRepository;

    @Override
    public List<Grupo> findAll() {
        return grupoRepository.findAll();
    }

    @Override
    public Page<Grupo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Grupo> findById(long id) {
        return grupoRepository.findById(id);
    }

    @Override
    public Grupo save(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @Override
    public void delete(long id) {
        grupoRepository.deleteById(id);
    }
}
