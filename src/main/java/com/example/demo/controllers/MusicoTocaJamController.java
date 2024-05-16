package com.example.demo.controllers;

import com.example.demo.dto.mteDTO.MusicoTocaEstiloDTO;
import com.example.demo.dto.mteDTO.MusicoTocaEstiloDTOConverter;
import com.example.demo.dto.mtj.MusicoTocaJamDTO;
import com.example.demo.entities.MusicoTocaEstilo;
import com.example.demo.entities.MusicoTocaJam;
import com.example.demo.interfaces.ControllerInterface;
import com.example.demo.repositorios.MusicoTocaJamRepository;
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
@RequestMapping("apiATM/jams/mtj")
@Tag(name = "PI: Across the music - Controlador MusicoTocaInstrumento")
public class MusicoTocaJamController implements ControllerInterface<MusicoTocaJam, MusicoTocaJamDTO> {

    //REPASAR ==============================================================
    @Autowired
    MusicoTocaJamRepository musicoTocaJamRepository;

    @Override
    public ResponseEntity<List<MusicoTocaJamDTO>> getAll() {
        return null;
    }

    @Operation(summary = "Devuelve el id del musico y el id del instrumento que toca")
    @PostMapping("/")
    @Override
    public ResponseEntity<MusicoTocaJam> save(@RequestBody MusicoTocaJam musicoTocaEstilo) {
        MusicoTocaJam newMTJ = musicoTocaJamRepository.save(musicoTocaEstilo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMTJ);
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public ResponseEntity<MusicoTocaJam> update(MusicoTocaJam musicoTocaInstrumento, long id) {
        return null;
    }

    @Override
    public ResponseEntity<MusicoTocaJamDTO> findById(long id) {
        return null;
    }
}
