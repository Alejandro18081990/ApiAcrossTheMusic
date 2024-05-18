package com.example.demo.services;


import com.example.demo.entities.MusicoTocaJam;
import com.example.demo.interfaces.ServiceInterface;
import com.example.demo.repositorios.MusicoTocaJamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicoTocaJamServiceImpl implements ServiceInterface<MusicoTocaJam> {

    @Autowired
    MusicoTocaJamRepository musicoTocaJam;

    @Override
    public Iterable<MusicoTocaJam> findAll() {
        return musicoTocaJam.findAll();
    }

    @Override
    public Page<MusicoTocaJam> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<MusicoTocaJam> findById(Long id) {
        return musicoTocaJam.findById(id);
    }

    @Override
    public MusicoTocaJam save(MusicoTocaJam mte) {
        return musicoTocaJam.save(mte);
    }

    @Override
    public void delete(long id) {
        musicoTocaJam.deleteById(id);
    }

    public void deleteByMusicoAndJamSession(long idMusico, long idJamSession) {
        musicoTocaJam.deleteMusicoJam(idMusico, idJamSession);
    }
}
