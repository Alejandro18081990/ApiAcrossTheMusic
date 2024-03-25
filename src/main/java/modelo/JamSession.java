package modelo;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class JamSession {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idJamSession;

	private String nombreJam;
	
	//Pendiente de implementar Estilo
	@ManyToOne
	@JoinColumn(name = "idEstilo")
	private Estilo estilo;
	
}
