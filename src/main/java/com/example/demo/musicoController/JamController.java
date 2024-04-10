package com.example.demo.musicoController;

import com.example.demo.dto.musicoDto.MusicoDtoConverter;
import com.example.demo.entities.JamSession;
import com.example.demo.entities.Musico;
import com.example.demo.services.jamsServices.JamService;
import com.example.demo.services.jamsServices.JamServiceImpl;
import com.example.demo.services.musicoServices.MusicoServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apiATM/jams")
@RequiredArgsConstructor
@Tag(name = "PI Across the music - Controlador Jams")
public class JamController {

    @Autowired
    private JamServiceImpl jamServiceImpl;

    @Autowired
    private MusicoServiceImpl musicoServiceImp;

    @Autowired
    private MusicoDtoConverter musicoDtoConverter;
    @GetMapping("/")
    public ResponseEntity<?> getAllJams() {
        return ResponseEntity.ok(jamServiceImpl.findAll());
    }

    @GetMapping("/musicos/{id}")
    public ResponseEntity<?> getMusiciansByJam(@PathVariable long id){
        //Aquí he de valorar si se devuelven DTOS u objetos normales
        //DUDAS: ¿ el método que utiliza esta operación debería estar en el servicio
        //de la jam o en la del músico?
        List<Musico> musicoConsultado = musicoServiceImp.findMusicoByMusicoTocaJam(id);
        if(musicoConsultado.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(musicoConsultado);
    }
}
