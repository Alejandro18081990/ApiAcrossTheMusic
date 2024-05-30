package com.example.demo.services;

import com.example.demo.entities.MusicoMensaje;
import com.example.demo.interfaces.ServiceInterface;
import com.example.demo.repositorios.MusicoMensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicoMensajeServiceImpl implements ServiceInterface<MusicoMensaje> {

    @Autowired
    private MusicoMensajeRepository musicoMensajeRepository;

    @Override
    public Iterable<MusicoMensaje> findAll() {
        return musicoMensajeRepository.findAll();
    }

    @Override
    public Page<MusicoMensaje> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<MusicoMensaje> findById(Long id) {
        return musicoMensajeRepository.findById(id);
    }

    @Override
    public MusicoMensaje save(MusicoMensaje mensaje) {
        return musicoMensajeRepository.save(mensaje);
    }

    @Override
    public void delete(long id) {
        musicoMensajeRepository.deleteById(id);
    }

    public List<MusicoMensaje> findMusicoMensajeByMusicoDestinatario(Long id) {
        return musicoMensajeRepository.findMusicoMensajeByMusicoDestinatarioIdMusico(id);
    }

    public List<MusicoMensaje>findMusicoMensajeByMusicoRemitente(Long id){
        return musicoMensajeRepository.findMusicoMensajeByMusicoRemitenteIdMusico(id);
    }
}
