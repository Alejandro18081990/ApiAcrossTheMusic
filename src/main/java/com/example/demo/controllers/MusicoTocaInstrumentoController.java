package com.example.demo.controllers;

import com.example.demo.dto.mtIDTO.MusicoTocaInstrumentoDTO;
import com.example.demo.dto.mtIDTO.MusicoTocaInstrumentoDTOConverter;
import com.example.demo.entities.Instrumento;
import com.example.demo.entities.Musico;
import com.example.demo.entities.MusicoTocaInstrumento;
import com.example.demo.interfaces.ControllerInterface;
import com.example.demo.repositorios.MusicoTocaInstrumentoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    @Operation(summary = "Modifica un registro de la tabla MusicoTocaInstrumento")
    @PutMapping("/")
    public ResponseEntity<MusicoTocaInstrumento> update(@RequestBody MusicoTocaInstrumento musicoTocaInstrumentoDetalle) {
        Optional<MusicoTocaInstrumento> mtiAModificar = musicoTocaInstrumentoRepository.findById(musicoTocaInstrumentoDetalle.getId());
        if (!mtiAModificar.isPresent())
            return ResponseEntity.noContent().build();
        MusicoTocaInstrumento musicoAModificar = mtiAModificar.get();
        musicoAModificar.setInstrumento(musicoTocaInstrumentoDetalle.getInstrumento());
        return ResponseEntity.ok(musicoTocaInstrumentoRepository.save(musicoAModificar));
    }

    @Operation(summary = "Devuelve un registro de MusicoTocaInstrumento a través de Musico y a través de Instrumento")
    @GetMapping("/{idMusico}/{idInstrumento}")
    public ResponseEntity<MusicoTocaInstrumentoDTO> findByMusicoAndInstrumento(@PathVariable Long idMusico, @PathVariable Long idInstrumento) {

        MusicoTocaInstrumento mtiConsultado = musicoTocaInstrumentoRepository.findByMusicoIdMusicoAndInstrumentoIdInstrumento(idMusico, idInstrumento);
        System.out.println("====================================================Id" + idInstrumento);
        if (mtiConsultado == null)
            return ResponseEntity.noContent().build();
        MusicoTocaInstrumentoDTO mtiDTO = mtiDTOConverter.convertirADTO(mtiConsultado);
        return ResponseEntity.ok(mtiDTO);
    }

    @Override
    public ResponseEntity<MusicoTocaInstrumentoDTO> findById(Long id) {
        return null;
    }
}
