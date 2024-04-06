package com.example.demo.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.MusicoTocaEstilo;
@Repository
public interface MusicoTocaEstiloRepository extends JpaRepository<MusicoTocaEstilo, Long> {

	//List<MusicoTocaEstiloRepository> findByEstilo(String nombreEstilo);
	
}
