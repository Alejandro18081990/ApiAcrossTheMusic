package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "musico_mensaje")
public class MusicoMensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "musicoRemitente")
    private Musico musicoRemitente;

    @ManyToOne
    @JoinColumn(name = "musicoDestinatario")
    private Musico musicoDestinatario;

    //@ManyToOne
    //@JoinColumn(name = "mensaje")
    //private Mensaje mensaje;

    private String cuerpoMensaje;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date fechaEnvio;

    private boolean leido;
}
