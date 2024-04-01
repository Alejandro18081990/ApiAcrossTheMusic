package modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@NoArgsConstructor ¿Por qué me indica que la anotación está duplicada?
@AllArgsConstructor
@Entity
@Table(name = "Instrumento")
public class Instrumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idInstrumento;
	private String nombreInstrumento;
	

}
