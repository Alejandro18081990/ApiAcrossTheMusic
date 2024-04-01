package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "MusicoTocaGrupo")
public class MusicoTocaGrupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "idMusico"), @JoinColumn(name = "email") })
	private Musico musico;

	@ManyToOne
	@JoinColumn(name = "idGrupo")
	private Grupo grupo;

}
