package repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicoTocaEstilo extends JpaRepository<MusicoTocaEstilo, Long> {

	List<MusicoTocaEstilo> findMusicoByEstilo(String nombreEstilo);
	
}
