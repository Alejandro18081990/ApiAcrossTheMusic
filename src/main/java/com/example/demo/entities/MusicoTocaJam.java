package com.example.demo.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "musico_toca_jam")
@Table(name = "musico_toca_jam")
public class MusicoTocaJam {
    //RECORDATORIO
    //Al mostrar los músicos que tocan en una jam hay que buscar la manera de mostrar el instrumento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idMusico")
    private Musico musico;

    @ManyToOne
    @JoinColumn(name = "idJamSession")
    private JamSession jamSession;


}
