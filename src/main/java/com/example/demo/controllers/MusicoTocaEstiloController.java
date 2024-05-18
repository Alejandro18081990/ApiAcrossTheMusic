package com.example.demo.controllers;

import com.example.demo.dto.mteDTO.MusicoTocaEstiloDTO;
import com.example.demo.dto.mteDTO.MusicoTocaEstiloDTOConverter;
import com.example.demo.entities.MusicoTocaEstilo;
import com.example.demo.entities.MusicoTocaInstrumento;
import com.example.demo.interfaces.ControllerInterface;
import com.example.demo.repositorios.MusicoTocaEstiloRepository;
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
@RequestMapping("apiATM/musicos/mte")
@Tag(name = "PI: Across the music - Controlador MusicoTocaInstrumento")
public class MusicoTocaEstiloController implements ControllerInterface<MusicoTocaEstilo, MusicoTocaEstiloDTO> {

    @Autowired
    MusicoTocaEstiloRepository musicoTocaEstiloRepository;

    @Autowired
    MusicoTocaEstiloDTOConverter mteDTOConverter;

    @Override
    public ResponseEntity<List<MusicoTocaEstiloDTO>> getAll() {
        return null;
    }

    @Operation(summary = "Devuelve el id del musico y el id del instrumento que toca")
    @PostMapping("/")
    @Override
    public ResponseEntity<MusicoTocaEstilo> save(@RequestBody MusicoTocaEstilo musicoTocaEstilo) {
        MusicoTocaEstilo newMTI = musicoTocaEstiloRepository.save(musicoTocaEstilo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMTI);
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public ResponseEntity<MusicoTocaEstilo> update(MusicoTocaEstilo musicoTocaInstrumento) {
        return null;
    }

    @Override
    public ResponseEntity<MusicoTocaEstiloDTO> findById(Long id) {
        return null;
    }
}
