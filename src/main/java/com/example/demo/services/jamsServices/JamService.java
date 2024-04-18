package com.example.demo.services.jamsServices;

import com.example.demo.dto.jamSessionDto.JamSessionDto;
import com.example.demo.entities.JamSession;

import java.util.List;
import java.util.Optional;

public interface JamService {

    List<JamSession> findAll();

    Optional<JamSession> findById(long id);

    void delete(long id);

    JamSession save(JamSession jamSession);
}
