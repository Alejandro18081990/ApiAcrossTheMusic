package com.example.demo.services;

import com.example.demo.entities.Mensaje;
import com.example.demo.entities.MusicoMensaje;
import com.example.demo.interfaces.ServiceInterface;
import com.example.demo.repositorios.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MensajeServiceImpl implements ServiceInterface<Mensaje> {

    @Autowired
    private MensajeRepository mensajeRepository;

    @Override
    public Iterable<Mensaje> findAll() {
        return mensajeRepository.findAll();
    }

    @Override
    public Page<Mensaje> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Mensaje> findById(Long id) {
        return mensajeRepository.findById(id);
    }

    @Override
    public Mensaje save(Mensaje mensaje) {
        return mensajeRepository.save(mensaje);
    }

    @Override
    public void delete(long id) {
        mensajeRepository.deleteById(id);
    }
}
