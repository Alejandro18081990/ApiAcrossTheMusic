package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
