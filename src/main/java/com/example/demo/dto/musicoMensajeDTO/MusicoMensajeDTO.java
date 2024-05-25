package com.example.demo.dto.musicoMensajeDTO;

import com.example.demo.dto.musicoDto.MusicoDetalleMensajeDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class MusicoMensajeDTO {

    private MusicoDetalleMensajeDTO musicoRemitente;
    private MusicoDetalleMensajeDTO musicoDestinatario;
    private String cuerpoMensaje;
}
