package com.example.demo.services.jamsServices;

import com.example.demo.entities.JamSession;

import java.util.Optional;

public interface JamService {

    public Iterable<JamSession> findAll();

    public Optional<JamSession> findById(long id);

    public void deleteById(long id);

    public Optional<JamSession> save(JamSession jamSession);
}
