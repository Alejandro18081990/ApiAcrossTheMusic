package entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "Estilo")
public class Estilo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEstilo;
	
	@Column(name="nombreEstilo")
	private String nombreEstilo;

	@OneToMany(mappedBy = "estilo")
	private List<JamSession> listadoJamsSessions;
}
