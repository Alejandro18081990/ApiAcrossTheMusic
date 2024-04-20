package com.example.demo.services;

import com.example.demo.entities.JamSession;
import com.example.demo.interfaces.ServiceInterface;
import com.example.demo.repositorios.JamSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JamServiceImpl implements ServiceInterface<JamSession> {

    @Autowired
    JamSessionRepository jamSessionRepository;

    @Override
    public List<JamSession> findAll() {
        return jamSessionRepository.findAll();
    }

    @Override
    public Page<JamSession> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<JamSession> findById(long id) {
        return jamSessionRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        jamSessionRepository.deleteById(id);
    }

    @Override
    public JamSession save(JamSession jamSession) {
        return jamSessionRepository.save(jamSession);
    }
}
