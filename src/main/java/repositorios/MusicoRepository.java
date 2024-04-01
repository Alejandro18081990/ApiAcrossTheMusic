package repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import modelo.Musico;

public interface MusicoRepository extends JpaRepository<Musico, Long> {

	@Query("SELECT m FROM Musico m " + "JOIN m.instrumentos i " + "JOIN m.estilos e "
			+ "WHERE i.nombre = :nombreInstrumento " + "AND e.nombre = :nombreEstilo")
	List<Musico> findByInstrumentoAndEstilo(@Param("nombreInstrumento") String nombreInstrumento,
			@Param("nombreEstilo") String nombreEstilo);

}
