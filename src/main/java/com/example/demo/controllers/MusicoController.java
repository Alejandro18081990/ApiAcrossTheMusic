package com.example.demo.controllers;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.interfaces.ControllerInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.musicoDto.MusicoDTO;
import com.example.demo.dto.musicoDto.MusicoDtoConverter;
import com.example.demo.entities.Musico;
import com.example.demo.repositorios.EstiloRepository;
import com.example.demo.repositorios.JamSessionRepository;
import com.example.demo.repositorios.MusicoRepository;
import com.example.demo.services.MusicoServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("apiATM/musicos")
@Tag(name = "PI: Across the music - Controlador Musicos")
public class MusicoController implements ControllerInterface<Musico, MusicoDTO> {

    @Autowired
    private final MusicoRepository musicoRepositorio;
    @Autowired
    MusicoDTO musicosDTO;
    @Autowired
    private MusicoDtoConverter musicoDtoConverter;
    @Autowired
    private JamSessionRepository jamSessionRepository;
    @Autowired
    private EstiloRepository estiloRepository;
    @Autowired
    private MusicoServiceImpl musicoServiceImpl;

    final String URL_BY_ID = "musico/{id}";

    @Override
    @Operation(summary = "Añade un músico a la tabla Musico")
    @PostMapping("/musico")
    public ResponseEntity<Musico> save(@RequestBody Musico musicoNuevo) {
        Musico newMusician = musicoServiceImpl.save(musicoNuevo);
        System.out.println(musicoNuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMusician);
    }

    @Override
    @Operation(summary = "Devuelve todos los musicos de la tabla Musico")
    @GetMapping("/")
    public ResponseEntity<List<MusicoDTO>> getAll() {
        Iterable<Musico> listadoMusicos = musicoServiceImpl.findAll();
        List<MusicoDTO> listadoMusicosDTO = new ArrayList<>();
        if (listadoMusicos == null)
            ResponseEntity.notFound().build();
        for (Musico musico : listadoMusicos) {
            listadoMusicosDTO.add(musicoDtoConverter.convertirADTO(musico));
        }
        return ResponseEntity.ok(listadoMusicosDTO);
    }

    @Override
    @Operation(summary = "Encuentra un músico por su id")
    @GetMapping(URL_BY_ID)
    public ResponseEntity<MusicoDTO> findById(@PathVariable long id) {
        Optional<Musico> musicoConsultado = musicoServiceImpl.findById(id);
        if (!musicoConsultado.isPresent())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(musicoDtoConverter.convertirADTO(musicoConsultado.get()));
    }

    @Override
    @Operation(summary = "Borra un músico localizandolo por id")
    @DeleteMapping(URL_BY_ID)
    public void delete(@PathVariable long id) {
        musicoServiceImpl.delete(id);
    }

    @Override
    @Operation(summary = "Modifica un músico encontrandolo por su id")
    @PutMapping(URL_BY_ID)
    public ResponseEntity<Musico> update(@RequestBody Musico musicoDetails, long id) {
        Optional<Musico> musicoAModificar = musicoServiceImpl.findById(id);
        if (!musicoAModificar.isPresent())
            return ResponseEntity.noContent().build();
        Musico musico = musicoAModificar.get();
        musico.setNombre(musicoDetails.getNombre());
        musico.setApellido1(musicoDetails.getApellido1());
        musico.setApellido2(musicoDetails.getApellido2());
        musico.setAniosExperiencia(musicoDetails.getAniosExperiencia());
        musico.setEmail(musicoDetails.getEmail());
        musico.setEdad(musicoDetails.getEdad());
        musico.setFormacion(musicoDetails.getFormacion());
        return ResponseEntity.ok().body(musicoServiceImpl.save(musico));
    }

    @Operation(summary = "Devuelve todos los musicos que tocan un instrumento y estilos determinados")
    @GetMapping("/{nombreInstrumento}/{nombreEstilo}")
    public ResponseEntity<List<MusicoDTO>> getMusicoByEstiloAndInstrumento(@PathVariable String nombreInstrumento, @PathVariable String nombreEstilo) {
        List<Musico> musicos = musicoServiceImpl.findByEstiloAndInstrumento(nombreInstrumento, nombreEstilo);

        if (musicos == null)
            ResponseEntity.notFound().build();
        List<MusicoDTO> musicosConsultaDto = new ArrayList<>();
        for (Musico musico : musicos)
            musicosConsultaDto.add(musicoDtoConverter.convertirADTO(musico));
        System.out.println("ConsultaMusicosByInstrumentoByEstilo " + musicos);
        return ResponseEntity.ok(musicosConsultaDto);
    }

    @Operation(summary = "Devuelve un musico encontrado a través de su email")
    @GetMapping("/musico/email/{email}")
    public ResponseEntity<MusicoDTO> findMusicoByEmail(@PathVariable(value = "email") String email) {
        Musico musicoConsultado = musicoServiceImpl.findMusicoByEmail(email);
        if (musicoConsultado == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(musicoDtoConverter.convertirADTO(musicoConsultado));
    }
}

