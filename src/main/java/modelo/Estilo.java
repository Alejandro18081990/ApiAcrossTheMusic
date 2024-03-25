package modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Estilo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEstilo;

	private String nombreEstilo;

	@OneToMany(mappedBy = "estilo")
	private List<JamSession> listadoJamsSessions;
}
