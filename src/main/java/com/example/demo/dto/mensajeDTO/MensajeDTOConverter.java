package com.example.demo.dto.mensajeDTO;

import com.example.demo.dto.mteDTO.MusicoTocaEstiloDTO;
import com.example.demo.entities.Mensaje;
import com.example.demo.entities.MusicoTocaEstilo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MensajeDTOConverter {

    @Autowired
    ModelMapper modelMapper;

    public MensajeDTO convertirADTO(Mensaje mensaje) {
        return modelMapper.map(mensaje, MensajeDTO.class);
    }
}
