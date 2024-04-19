package com.example.demo.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
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
}
