package com.example.demo.dto.grupoDTO;

import com.example.demo.entities.Grupo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GrupoDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public GrupoDTO convertirADTO(Grupo grupo) {
        return modelMapper.map(grupo, GrupoDTO.class);
    }

    public Grupo convertirAGrupo(GrupoDTO grupo) {
        return modelMapper.map(grupo, Grupo.class);
    }
}
