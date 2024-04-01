package modelo;

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
@Entity
@Table(name = "MusicoTocaInstrumento")
public class MusicoTocaInstrumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "idMusico"), @JoinColumn(name = "email") })
	private Musico musico;

	@ManyToOne
	@JoinColumn(name = "idInstrumento")
	private Instrumento instrumento;

}
