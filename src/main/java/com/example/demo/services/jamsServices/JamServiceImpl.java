package com.example.demo.services.jamsServices;

import com.example.demo.dto.jamSessionDto.JamSessionDto;
import com.example.demo.entities.JamSession;
import com.example.demo.repositorios.JamSessionRepository;
import com.example.demo.services.musicoServices.MusicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JamServiceImpl implements JamService {

    @Autowired
    JamSessionRepository jamSessionRepository;


    @Override
    public List<JamSession> findAll() {
        return jamSessionRepository.findAll();
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
