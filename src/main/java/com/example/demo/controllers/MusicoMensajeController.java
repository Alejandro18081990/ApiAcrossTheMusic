package com.example.demo.controllers;

import com.example.demo.dto.musicoDto.MusicoDTO;
import com.example.demo.dto.musicoDto.MusicoDtoConverter;
import com.example.demo.dto.musicoMensajeDTO.MusicoMensajeDTO;
import com.example.demo.dto.musicoMensajeDTO.MusicoMensajeDTOConverter;
import com.example.demo.entities.Musico;
import com.example.demo.entities.MusicoMensaje;
import com.example.demo.interfaces.ControllerInterface;
import com.example.demo.repositorios.EstiloRepository;
import com.example.demo.repositorios.JamSessionRepository;
import com.example.demo.repositorios.MusicoMensajeRepository;
import com.example.demo.repositorios.MusicoRepository;
import com.example.demo.services.MusicoMensajeServiceImpl;
import com.example.demo.services.MusicoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("apiATM/musicoMensaje")
@Tag(name = "PI: Across the music - Controlador MusicoMensaje")
public class MusicoMensajeController implements ControllerInterface<MusicoMensaje, MusicoMensajeDTO> {

    private static final Logger log = LoggerFactory.getLogger(MusicoMensajeController.class);
    @Autowired
    private final MusicoMensajeServiceImpl musicoServiceImpl;
    @Autowired
    private MusicoMensajeDTOConverter musicoMensajeDTOConverter;


    final String URL_BY_ID = "musicoMensaje/{id}";

    @Override
    @Operation(summary = "Devuelve todos los registros de MusicoMensaje")
    @GetMapping("/")
    public ResponseEntity<List<MusicoMensajeDTO>> getAll() {
        Iterable<MusicoMensaje> listaMusicoMensaje = musicoServiceImpl.findAll();
        List<MusicoMensajeDTO> listaMusicoMensajeDTO = new ArrayList<>();
        for (MusicoMensaje mm : listaMusicoMensaje)
            listaMusicoMensajeDTO.add(musicoMensajeDTOConverter.convertirDto(mm));
        return ResponseEntity.ok(listaMusicoMensajeDTO);
    }

    @Override
    @Operation(summary = "Guarda un registro en MusicoMensaje")
    @PostMapping("/mensaje")
    public ResponseEntity<MusicoMensaje> save(@RequestBody MusicoMensaje musicoMensaje) {
        if (musicoMensaje == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(musicoServiceImpl.save(musicoMensaje));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ResponseEntity<MusicoMensaje> update(MusicoMensaje musicoMensaje) {
        return null;
    }

    @Override
    public ResponseEntity<MusicoMensajeDTO> findById(Long id) {
        return null;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Devuelve todos los registros de MusicoMensaje que coinciden con la idMusico recibida")
    public ResponseEntity<List<MusicoMensaje>> findMusicoMensajeByMusido(@PathVariable Long id) {
        if (id == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(musicoServiceImpl.findMusicoMensajeByMusico(id));
    }
}

