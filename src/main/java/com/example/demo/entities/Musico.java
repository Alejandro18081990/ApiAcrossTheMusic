package com.example.demo.entities;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "musico")
public class Musico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMusico;
	// Evita que el campo se pueda repetir
	@Column(unique = true)
	private String email;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private int aniosExperiencia;
	private String formacion;
	private boolean tieneFormacion;
	
	@OneToMany(mappedBy = "musico")
	Set<MusicoTocaInstrumento> musicoTocaInstrumento;
	
	
	@OneToMany(mappedBy = "musico")
	Set<MusicoTocaEstilo>musicoTocaEstilo;
	
	
	@OneToMany(mappedBy = "musico")
	private List<Video> misVideos;
}
