package entities;

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
@Table(name = "MusicoTocaEstilo")
public class MusicoTocaEstilo {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "idMusico")
	private Musico musico;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "idEstilo")
	private Estilo estilo;

}
