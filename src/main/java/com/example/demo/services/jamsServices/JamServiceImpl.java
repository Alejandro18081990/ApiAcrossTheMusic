package com.example.demo.services.jamsServices;

import com.example.demo.entities.JamSession;
import com.example.demo.repositorios.JamSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JamServiceImpl implements JamService {

    @Autowired
    JamSessionRepository jamSessionRepository;


    @Override
    public Iterable<JamSession> findAll() {
        return jamSessionRepository.findAll();
    }

    @Override
    public Optional<JamSession> findById(long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Optional<JamSession> save(JamSession jamSession) {
        return Optional.empty();
    }
}
