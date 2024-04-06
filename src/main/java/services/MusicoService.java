package services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import entities.Musico;

public interface MusicoService {

	public Iterable<Musico> findAll();

	public Page<Musico> findAll(Pageable pageable);

	public List<Musico> findByEstiloAndInstrumento(String nombreInstrumento, String nombreEstilo);

	public Musico save(Musico musico);
	
	
}
