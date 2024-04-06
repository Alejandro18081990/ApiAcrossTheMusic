package controller;

import java.util.List;
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
//@RequestMapping("apiATM/musicos")
public class MusicoController {

	@Autowired
	private final MusicoRepository musicoRepositorio;
	@Autowired
	MusicoDto musicosDTO;
	@Autowired
	private MusicoDtoConverter musicoDtoConverter;
	@Autowired
	private JamSessionRepository jamSessionRepository;
	@Autowired
	private EstiloRepository estiloRepository;
	@Autowired
	private MusicoServiceImpl musicoServiceImpl;

	@GetMapping("/musicos")
	public ResponseEntity<?> getAllMusicos() {
		Iterable<Musico> listadoMusicos = musicoRepositorio.findAll();
		if (listadoMusicos == null)
			ResponseEntity.notFound().build();
		return ResponseEntity.ok(listadoMusicos);
	}

	@GetMapping("/{nombreInstrumento}/{nombreEstilo}")
	public ResponseEntity<?> getMusicoByEstiloAndInstrumento(@PathVariable String nombreInstrumento,
			@PathVariable String nombreEstilo) {
		List<Musico> musicos = musicoServiceImpl.findByEstiloAndInstrumento(nombreInstrumento, nombreEstilo);
		if (musicos == null) {
			ResponseEntity.notFound().build();
			System.out.println("Error en la solicitud");
		}
		List<MusicoDto> musicosConsultaDto = musicos.parallelStream().map(musicoDtoConverter::convertirADTO)
				.collect(Collectors.toList());
		return ResponseEntity.ok(musicosConsultaDto);
	}
}
