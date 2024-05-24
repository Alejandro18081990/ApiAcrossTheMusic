package com.example.demo.controllers;

import com.example.demo.dto.mensajeDTO.MensajeDTO;
import com.example.demo.dto.mensajeDTO.MensajeDTOConverter;
import com.example.demo.entities.Mensaje;
import com.example.demo.interfaces.ControllerInterface;
import com.example.demo.services.MensajeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class MensajeController implements ControllerInterface<Mensaje, MensajeDTO> {

    @Autowired
    private MensajeServiceImpl mensajeServiceImpl;
    @Autowired
    private MensajeDTOConverter mensajeDTOConverter;

    @Override
    @Operation(summary = "Devuelve todos los mensajes")
    public ResponseEntity<List<MensajeDTO>> getAll() {
        Iterable<Mensaje> listaMensajes = mensajeServiceImpl.findAll();
        List<MensajeDTO> listaMensajesDTO = new ArrayList<>();
        for (Mensaje mensaje : listaMensajes) {
            listaMensajesDTO.add(mensajeDTOConverter.convertirADTO(mensaje));
        }
        return ResponseEntity.ok(listaMensajesDTO);
    }

    @Override
    public ResponseEntity<Mensaje> save(Mensaje mensaje) {
        if (mensaje == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(mensajeServiceImpl.save(mensaje));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ResponseEntity<Mensaje> update(Mensaje mensaje) {
        return null;
    }

    @Override
    public ResponseEntity<MensajeDTO> findById(Long id) {
        return null;
    }
}
