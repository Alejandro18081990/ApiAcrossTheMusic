package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JamSession")
public class JamSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idJamSession;

    private String nombreJam;

    @ManyToOne
    @JoinColumn(name = "idEstilo")
    private Estilo estilo;

    private Date fecha;

    private String lugar;

    @OneToMany(mappedBy = "jamSession")
    Set<MusicoTocaJam> jamSession;

}
