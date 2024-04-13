package com.example.demo.musicoController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.musicoDto.MusicoDTO;
import com.example.demo.dto.musicoDto.MusicoDtoConverter;
import com.example.demo.entities.Musico;
import com.example.demo.repositorios.EstiloRepository;
import com.example.demo.repositorios.JamSessionRepository;
import com.example.demo.repositorios.MusicoRepository;
import com.example.demo.services.musicoServices.MusicoServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("apiATM/musicos")
@Tag(name = "PI: Across the music - Controlador Musicos")
public class MusicoController {

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

    @Operation(summary = "Añade un músico a la tabla Musico")
    @PostMapping("/musico")
    public ResponseEntity<?> createMusico(@RequestBody Musico musicoNuevo) {
        Musico newMusician = musicoServiceImpl.save(musicoNuevo);
        System.out.println(musicoNuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMusician);
    }

    @Operation(summary = "Devuelve todos los musicos de la tabla Musico")
    @GetMapping("/")
    public ResponseEntity<List<MusicoDTO>> getAllMusicos() {
        Iterable<Musico> listadoMusicos = musicoServiceImpl.findAll();
        List<MusicoDTO> listadoMusicosDTO = new ArrayList<>();
        System.out.println("----------------------------------------------------------------------" + listadoMusicos);
        if (listadoMusicos == null)
            ResponseEntity.notFound().build();
        for (Musico musico : listadoMusicos) {
            listadoMusicosDTO.add(musicoDtoConverter.convertirADTO(musico));
        }
        return ResponseEntity.ok(listadoMusicosDTO);
    }

    @Operation(summary = "Devuelve todos los musicos que tocan un instrumento y estilos determinados")
    @GetMapping("/{nombreInstrumento}/{nombreEstilo}")
    public ResponseEntity<List<MusicoDTO>> getMusicoByEstiloAndInstrumento(@PathVariable String nombreInstrumento,
                                                                           @PathVariable String nombreEstilo) {
        List<Musico> musicos = musicoServiceImpl.findByEstiloAndInstrumento(nombreInstrumento, nombreEstilo);

        if (musicos == null)
            ResponseEntity.notFound().build();
        List<MusicoDTO> musicosConsultaDto = new ArrayList<>();
        for (Musico musico : musicos)
            musicosConsultaDto.add(musicoDtoConverter.convertirADTO(musico));
        System.out.println("ConsultaMusicosByInstrumentoByEstilo " + musicos);
        return ResponseEntity.ok(musicosConsultaDto);
    }
}

