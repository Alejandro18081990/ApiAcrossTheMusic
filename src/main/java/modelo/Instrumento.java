package modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@NoArgsConstructor ¿Por qué me indica que la anotación está duplicada?
@AllArgsConstructor
@Entity
public class Instrumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idInstrumento;
	private String nombreInstrumento;
	

}
