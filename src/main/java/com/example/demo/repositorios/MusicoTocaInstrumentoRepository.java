package com.example.demo.repositorios;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.MusicoTocaInstrumento;





@Repository
public interface MusicoTocaInstrumentoRepository extends JpaRepository<MusicoTocaInstrumento, Long> {

	List<MusicoTocaInstrumento> findByInstrumentoNombreInstrumento(String nombreInstrumento);
}
