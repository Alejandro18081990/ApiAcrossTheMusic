package com.example.demo.entities;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


//Pendiente de insertar datos para hacer la primera consulta
@Data
@NoArgsConstructor
@Entity
@Table(name = "video")
public class Video {

	@Id
	private long idVideo;
	private Blob video;

	@ManyToOne
	@JoinColumn(name = "idMusico")
	private Musico musico;
}
