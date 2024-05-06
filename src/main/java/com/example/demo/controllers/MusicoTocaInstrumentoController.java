package com.example.demo.controllers;

import com.example.demo.dto.mtIDTO.MusicoTocaInstrumentoDTO;
import com.example.demo.dto.mtIDTO.MusicoTocaInstrumentoDTOConverter;
import com.example.demo.entities.MusicoTocaInstrumento;
import com.example.demo.interfaces.ControllerInterface;
import com.example.demo.repositorios.MusicoTocaInstrumentoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("apiATM/musicos/mti")
@Tag(name = "PI: Across the music - Controlador MusicoTocaInstrumento")
public class MusicoTocaInstrumentoController implements ControllerInterface<MusicoTocaInstrumento, MusicoTocaInstrumentoDTO> {

    @Autowired
    MusicoTocaInstrumentoRepository musicoTocaInstrumentoRepository;

    @Autowired
    MusicoTocaInstrumentoDTOConverter mtiDTOConverter;

    @Override
    public ResponseEntity<List<MusicoTocaInstrumentoDTO>> getAll() {
        return null;
    }

    @Operation(summary = "Devuelve el id del musico y el id del instrumento que toca")
    @PostMapping("/")
    @Override
    public ResponseEntity<MusicoTocaInstrumento> save(@RequestBody MusicoTocaInstrumento musicoTocaInstrumento) {
        MusicoTocaInstrumento newMTI = musicoTocaInstrumentoRepository.save(musicoTocaInstrumento);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMTI);
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public ResponseEntity<MusicoTocaInstrumento> update(MusicoTocaInstrumento musicoTocaInstrumento, long id) {
        return null;
    }

    @Override
    public ResponseEntity<MusicoTocaInstrumentoDTO> findById(long id) {
        return null;
    }
}
