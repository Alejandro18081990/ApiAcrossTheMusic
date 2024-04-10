package com.example.demo.services.musicoServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Musico;
import com.example.demo.repositorios.MusicoRepository;

@Service
public class MusicoServiceImpl implements MusicoService {

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
    public List<Musico> findByEstiloAndInstrumento(String nombreInstrumento, String nombreEstilo) {
        // System.out.println("Servicio" + nombreEstilo + nombreInstrumento);
        // List<Musico>prueba =
        // musicoRepository.findByInstrumentoAndEstilo(nombreInstrumento, nombreEstilo);
        // System.out.println("Servicio: " + prueba);
        return musicoRepository.findByInstrumentoAndEstilo(nombreInstrumento, nombreEstilo);
    }

    @Override
    public List<Musico> findMusicoByMusicoTocaJam(long idJam) {
        return musicoRepository.findMusicoByMusicoTocaJam(idJam);
    }

    @Override
    public Musico save(Musico musico) {
        return musicoRepository.save(musico);
    }
}
