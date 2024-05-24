package com.example.demo.dto.mensajeDTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MensajeDTO {

    private Long id;

    private String mensaje;
}
