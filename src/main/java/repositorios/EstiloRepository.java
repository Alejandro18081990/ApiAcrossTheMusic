package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.Estilo;
import modelo.JamSession;

public interface EstiloRepository extends JpaRepository<Estilo,Long> { 

}
