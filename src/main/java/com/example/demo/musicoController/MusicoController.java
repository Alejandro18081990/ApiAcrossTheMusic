package com.example.demo.musicoController;

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

import com.example.demo.dto.musicoDto.MusicoDto;
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
    MusicoDto musicosDTO;
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
    public ResponseEntity<?> getAllMusicos() {
        Iterable<Musico> listadoMusicos = musicoServiceImpl.findAll();
        System.out.println("----------------------------------------------------------------------" + listadoMusicos);
        if (listadoMusicos == null)
            ResponseEntity.notFound().build();
        return ResponseEntity.ok(listadoMusicos);
    }
    @Operation(summary = "Devuelve todos los musicos que tocan un instrumento y estilos determinados")
    @GetMapping("/{nombreInstrumento}/{nombreEstilo}")
    public ResponseEntity<?> getMusicoByEstiloAndInstrumento(@PathVariable String nombreInstrumento,
                                                             @PathVariable String nombreEstilo) {
        List<Musico> musicos = musicoServiceImpl.findByEstiloAndInstrumento(nombreInstrumento, nombreEstilo);

        if (musicos == null) {
            ResponseEntity.notFound().build();
            System.out.println("Error en la solicitud");
        }
        List<MusicoDto> musicosConsultaDto = musicos.parallelStream().map(musicoDtoConverter::convertirADTO)
                .collect(Collectors.toList());
        System.out.println("ConsultaMusicosByInstrumentoByEstilo " + musicos);
        return ResponseEntity.ok(musicosConsultaDto);
    }
}
