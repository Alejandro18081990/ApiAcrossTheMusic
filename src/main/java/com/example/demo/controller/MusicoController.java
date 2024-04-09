package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.musicoDto.MusicoDto;
import com.example.demo.dto.musicoDto.MusicoDtoConverter;
import com.example.demo.entities.Musico;
import com.example.demo.repositorios.EstiloRepository;
import com.example.demo.repositorios.JamSessionRepository;
import com.example.demo.repositorios.MusicoRepository;
import com.example.demo.services.MusicoServiceImpl;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("apiATM/musicos")
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
		List<Musico> listadoMusicos = musicoRepositorio.findAll();
		if (listadoMusicos == null)
			ResponseEntity.notFound().build();
		System.out.println("Controlador getAll" + listadoMusicos.get(1).getMusicoTocaInstrumento());
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
		System.out.println("ConsultaMusicosByInstrumentoByEstilo " + musicos);
		return ResponseEntity.ok(musicosConsultaDto);
	}
}
