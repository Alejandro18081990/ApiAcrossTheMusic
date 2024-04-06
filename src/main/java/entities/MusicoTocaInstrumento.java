package entities;

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
	@ManyToOne
	@JoinColumn(name = "idMusico")
	private Musico musico;
	@Id
	@ManyToOne
	@JoinColumn(name = "idInstrumento")
	private Instrumento instrumento;

}
