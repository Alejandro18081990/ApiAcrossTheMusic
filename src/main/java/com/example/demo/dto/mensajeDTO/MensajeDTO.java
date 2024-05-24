package com.example.demo.dto.mensajeDTO;

import com.example.demo.dto.musicoDto.MusicoDTO;
import com.example.demo.dto.musicoDto.MusicoDetalleMensajeDTO;
import com.example.demo.entities.Musico;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MensajeDTO {

    private Long id;

    private String mensaje;

    private MusicoDetalleMensajeDTO musico;

}
