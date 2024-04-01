package controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dto.musicoDto.MusicoDto;
import dto.musicoDto.MusicoDtoConverter;
import lombok.RequiredArgsConstructor;
import modelo.Musico;
import repositorios.EstiloRepository;
import repositorios.JamSessionRepository;
import repositorios.MusicoRepository;

@RestController
@RequiredArgsConstructor
public class MusicoController {

	@Autowired
	private final MusicoRepository musicoRepositorio;
	@Autowired
	private MusicoDtoConverter musicoDtoConverter;
	@Autowired
	private JamSessionRepository jamSessionRepository;
	@Autowired
	private EstiloRepository estiloRepository;

	
	
	@GetMapping("/musicos?estilo=nombreEstilo&instrumento=nombreInstrumento")
	public ResponseEntity<?> getMusicianByDatas(@RequestParam String nombreEstilo, @RequestParam String nombreInstrumento) {
		List<Musico> musicos = musicoRepositorio.findByInstrumentoAndEstilo(nombreInstrumento, nombreEstilo);
		if (musicos.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(musicos);
	}
}
