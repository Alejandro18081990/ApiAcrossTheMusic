package repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import modelo.MusicoTocaInstrumento;

@Repository
public interface MusicoTocaInstrumentoRepository extends JpaRepository<MusicoTocaInstrumento, Long> {

	List<MusicoTocaInstrumento> findMusicoByInstrumento(String nombreInstrumento);
}
