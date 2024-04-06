package repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entities.Musico;

public interface MusicoRepository extends JpaRepository<Musico, Long> {

	@Query("SELECT m FROM Musico m, " + "INSTRUMENTO i, " + "ESTILO e, " + "MUSICO_TOCA_INSTRUMENTO mti, "
			+ "MUSICO_TOCA_ESTILO mte " + "WHERE i.nombre_instrumento = :nombreInstrumento "
			+ "AND i.id_Instrumento = mti.id_Instrumento " + "AND e.nombre_estilo = :nombreEstilo "
			+ "AND e.id_Estilo = mte.id_Estilo")
	List<Musico> findByInstrumentoAndEstilo(@Param("nombreInstrumento") String nombreInstrumento,
			@Param("nombreEstilo") String nombreEstilo);

}
