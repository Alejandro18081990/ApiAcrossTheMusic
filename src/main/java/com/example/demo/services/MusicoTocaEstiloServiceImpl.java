package com.example.demo.services;

import com.example.demo.entities.MusicoTocaEstilo;
import com.example.demo.entities.MusicoTocaInstrumento;
import com.example.demo.interfaces.ServiceInterface;
import com.example.demo.repositorios.MusicoTocaEstiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class MusicoTocaEstiloServiceImpl implements ServiceInterface<MusicoTocaEstilo> {

    @Autowired
    MusicoTocaEstiloRepository mteRepository;

    @Override
    public Iterable<MusicoTocaEstilo> findAll() {
        return mteRepository.findAll();
    }

    @Override
    public Page<MusicoTocaEstilo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<MusicoTocaEstilo> findById(long id) {
        return mteRepository.findById(id);
    }

    @Override
    public MusicoTocaEstilo save(MusicoTocaEstilo musicoTocaEstilo) {
        return mteRepository.save(musicoTocaEstilo);
    }

    @Override
    public void delete(long id) {
        mteRepository.deleteById(id);
    }
}
