package dto.musicoDto;

import java.sql.Blob;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicoDto {
	
	private String email;
	private String nombre;
	private int edad;
	private int anios_experiencia;
	private Blob video;
}
