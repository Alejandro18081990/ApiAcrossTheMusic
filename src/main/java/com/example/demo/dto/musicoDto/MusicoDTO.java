package com.example.demo.dto.musicoDto;

import java.sql.Blob;
import java.util.List;

import com.example.demo.dto.mtIDTO.MusicoTocaInstrumentoDTO;
import com.example.demo.dto.mteDTO.MusicoTocaEstiloDTO;
import com.example.demo.entities.MusicoTocaEstilo;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MusicoDTO {

    private String email;
    private String nombre;
    private int edad;
    private int aniosExperiencia;
    private List<MusicoTocaInstrumentoDTO> instrumentos;
    private List<MusicoTocaEstiloDTO> estilos;
    private Blob video;
}