package com.example.demo.services;

import com.example.demo.entities.Instrumento;
import com.example.demo.interfaces.ServiceInterface;
import com.example.demo.repositorios.InstrumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstrumentosServiceImpl implements ServiceInterface<Instrumento> {

    @Autowired
    private InstrumentoRepository instrumentoRepository;

    @Override
    public List<Instrumento> findAll() {
        return instrumentoRepository.findAll();
    }

    @Override
    public Page<Instrumento> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Instrumento> findById(long id) {
        return instrumentoRepository.findById(id);
    }

    @Override
    public Instrumento save(Instrumento instrumento) {
        return instrumentoRepository.save(instrumento);
    }

    @Override
    public void delete(long id) {
        instrumentoRepository.deleteById(id);
    }
}
