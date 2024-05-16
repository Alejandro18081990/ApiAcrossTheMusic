package com.example.demo.dto.jamSessionDto;



import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class JamSessionDto {


	private long idJamSession;

	private String nombreJam;
	
	private String estilo;

	private Date fecha;

	private String lugar;
}
