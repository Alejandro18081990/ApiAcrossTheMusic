package controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dto.musicoDto.MusicoDto;
import dto.musicoDto.MusicoDtoConverter;
import entities.Musico;
import lombok.RequiredArgsConstructor;
import repositorios.EstiloRepository;
import repositorios.JamSessionRepository;
import repositorios.MusicoRepository;
import services.MusicoServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("apiATM/musicos")
public class MusicoController {

	@Autowired
	private final MusicoRepository musicoRepositorio;
	@Autowired
	private MusicoDtoConverter musicoDtoConverter;
	@Autowired
	private JamSessionRepository jamSessionRepository;
	@Autowired
	private EstiloRepository estiloRepository;
	@Autowired
	private MusicoServiceImpl musicoServiceImpl;

	@GetMapping("/api/musico/{nombreInstrumento}/{nombreEstilo}")
	public ResponseEntity<?> getMusicoByEstiloAndInstrumento(
			@RequestParam(name = "nombreInstrumento") String nombreInstrumento,
			@RequestParam(name = "nombreEstilo") String nombreEstilo) {
		Optional<Musico> musicos = musicoServiceImpl.findByEstiloAndInstrumento(nombreInstrumento, nombreEstilo);
		if (!musicos.isPresent())
			ResponseEntity.notFound().build();

		return ResponseEntity.ok(musicos);
	}

}
