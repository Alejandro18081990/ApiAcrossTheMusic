package modelo;

import java.sql.Blob;

import jakarta.persistence.Entity;
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
@Table(name = "Video")
public class Video {

	@Id
	private long idVideo;
	private Blob video;
	
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "idMusico"), @JoinColumn(name = "email") })
	private Musico musico;
}
