package com.example.demo.services;

import com.example.demo.entities.MusicoTocaInstrumento;
import com.example.demo.interfaces.ServiceInterface;
import com.example.demo.repositorios.MusicoTocaInstrumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MusicoTocaInstrumentoServiceImpl implements ServiceInterface<MusicoTocaInstrumento> {

    @Autowired
    MusicoTocaInstrumentoRepository mtiRepository;

    @Override
    public Iterable<MusicoTocaInstrumento> findAll() {
        return mtiRepository.findAll();
    }

    @Override
    public Page<MusicoTocaInstrumento> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<MusicoTocaInstrumento> findById(Long id) {
        return mtiRepository.findById(id);
    }

    @Override
    public MusicoTocaInstrumento save(MusicoTocaInstrumento musicoTocaInstrumento) {
        return mtiRepository.save(musicoTocaInstrumento);
    }

    @Override
    public void delete(long id) {
        mtiRepository.deleteById(id);
    }
}
