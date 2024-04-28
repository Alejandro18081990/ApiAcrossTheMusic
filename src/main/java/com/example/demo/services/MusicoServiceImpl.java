package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.interfaces.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Musico;
import com.example.demo.repositorios.MusicoRepository;

@Service
public class MusicoServiceImpl implements ServiceInterface<Musico> {

    @Autowired
    private MusicoRepository musicoRepository;

    @Override
    public Iterable<Musico> findAll() {
        return musicoRepository.findAll();
    }

    @Override
    public Page<Musico> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(long id) {
        musicoRepository.deleteById(id);
    }

    @Override
    public Optional<Musico> findById(long id) {
        return musicoRepository.findById(id);
    }

    @Override
    public Musico save(Musico musico) {

        return musicoRepository.save(musico);
    }

    public List<Musico> findByEstiloAndInstrumento(String nombreInstrumento, String nombreEstilo) {
        return musicoRepository.findByInstrumentoAndEstilo(nombreInstrumento, nombreEstilo);
    }

    public List<Musico> findMusicoByMusicoTocaJam(long idJam) {
        return musicoRepository.findMusicoByMusicoTocaJam(idJam);
    }

    public Musico findMusicoByEmail(String email) {
        return musicoRepository.findMusicoByEmail(email);
    }
}
