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
public class Musico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMusico;
	@Id
	private String email;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private int aniosExperiencia;
	private String formacion;
	private boolean tieneFormacion;
	
	@OneToMany(mappedBy = "musico")
	private List<Video> misVideos;
	

}
