package com.example.demo.controllers;

import com.example.demo.dto.estiloDTO.EstiloDTO;
import com.example.demo.dto.estiloDTO.EstiloDTOConverter;
import com.example.demo.entities.Estilo;
import com.example.demo.interfaces.ControllerInterface;
import com.example.demo.services.EstiloServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("apiATM/estilos")
@Tag(name = "PI Across the music - Controller Estilos")
public class EstiloController implements ControllerInterface<Estilo, EstiloDTO> {

    @Autowired
    private EstiloServiceImpl estiloServiceImpl;

    @Autowired
    EstiloDTOConverter estiloDTOConverter;


    private final String ENDPOINT_BY_ID = "/estilo/{id}";

    @Override
    @Operation(summary = "Devuelve todos los estilos de la base de datos")
    @GetMapping("/")
    public ResponseEntity<List<EstiloDTO>> getAll() {
        List<Estilo> estilosConsultados = estiloServiceImpl.findAll();
        if (estilosConsultados.isEmpty())
            return ResponseEntity.noContent().build();
        List<EstiloDTO> estilosConsultadosDTO = estilosConsultados
                .stream()
                .map(estilo -> estiloDTOConverter.convertirADTO(estilo))
                .collect(Collectors.toList());
        return ResponseEntity.ok(estilosConsultadosDTO);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Estilo> save(@RequestBody Estilo estilo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estiloServiceImpl.save(estilo));
    }

    @Override
    @Operation(summary = "Borra un estilo encontrado por su id")
    @DeleteMapping(ENDPOINT_BY_ID)
    public void delete(@PathVariable Long id) {
        estiloServiceImpl.delete(id);
    }

    @Override
    @Operation(summary = "Modifica un estilo encontrado por su id")
    @PutMapping(ENDPOINT_BY_ID)
    public ResponseEntity<Estilo> update(@RequestBody Estilo estiloDetails) {
        Optional<Estilo> estiloAModificar = estiloServiceImpl.findById(estiloDetails.getIdEstilo());
        if (!estiloAModificar.isPresent())
            return ResponseEntity.noContent().build();
        Estilo estiloModificado = estiloAModificar.get();
        estiloModificado.setNombreEstilo(estiloDetails.getNombreEstilo());
        return ResponseEntity.ok(estiloServiceImpl.save(estiloModificado));
    }

    @Override
    @Operation(summary = "Encuentra un estilo por su id")
    @GetMapping(ENDPOINT_BY_ID)
    public ResponseEntity<EstiloDTO> findById(@PathVariable Long id) {
        Optional<Estilo> estiloConsultado = estiloServiceImpl.findById(id);
        if (!estiloConsultado.isPresent())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(estiloDTOConverter.convertirADTO(estiloConsultado.get()));
    }
}
