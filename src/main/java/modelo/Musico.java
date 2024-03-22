package modelo;

import java.sql.Blob;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor ¿Por qué me indica que la anotación está duplicada?
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
