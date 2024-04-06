package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Musico;
import com.example.demo.repositorios.MusicoRepository;




@Service
public class MusicoServiceImpl implements MusicoService {

	@Autowired
	private MusicoRepository musicoRepository;

	@Override
	public Iterable<Musico> findAll() {
		return musicoRepository.findAll();
	}

	@Override
	public Page<Musico> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Musico> findByEstiloAndInstrumento(String nombreEstilo, String nombreInstrumento) {
		return musicoRepository.findByInstrumentoAndEstilo(nombreInstrumento, nombreEstilo);
	}

	@Override
	public Musico save(Musico musico) {
		// TODO Auto-generated method stub
		return null;
	}
}
