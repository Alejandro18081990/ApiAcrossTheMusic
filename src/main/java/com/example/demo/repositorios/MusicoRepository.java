package com.example.demo.repositorios;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Musico;




@Repository
public interface MusicoRepository extends JpaRepository<Musico, Long> {

	@Query("SELECT DISTINCT m FROM Musico m " +
		       "JOIN musico_toca_instrumento mti ON m.id = mti.musico.idMusico " +
		       "JOIN musico_toca_estilo mte ON m.id = mte.musico.idMusico " +
		       "JOIN mti.instrumento i " +
		       "JOIN mte.estilo e " +
		       "WHERE i.nombreInstrumento = :nombreInstrumento " +
		       "AND e.nombreEstilo = :nombreEstilo")
	List<Musico> findByInstrumentoAndEstilo(@Param("nombreInstrumento") String nombreInstrumento,
			@Param("nombreEstilo") String nombreEstilo);

}

//@Query("SELECT DISTINCT m FROM Musico m " +
//	       "JOIN musico_toca_instrumento mti ON m.id = mti.musico.idMusico " +
//	       "JOIN musico_toca_estilo mte ON m.id = mte.musico.idMusico " +
//	       "JOIN mti.instrumento i " +
//	       "JOIN mte.estilo e " +
//	       "WHERE mti.instrumento.nombreInstrumento = :nombreInstrumento " +
//	       "AND mte.estilo.nombreEstilo = :nombreEstilo"