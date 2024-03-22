package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Video {

	@Id
	private long idVideo;
	private String localizacionVideo;
	
	@ManyToOne
	@JoinColumn(name = "idMusico")
	private Musico musico;
}
