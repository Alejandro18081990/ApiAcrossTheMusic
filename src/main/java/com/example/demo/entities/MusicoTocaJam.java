package com.example.demo.entities;

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

	@Id
	@ManyToOne
	@JoinColumn(name = "idMusico")
	private Musico musico;
	@Id
	@ManyToOne
	@JoinColumn(name = "idJamSession")
	private JamSession jamSession;
}
