package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Estilo;
import entities.JamSession;

public interface EstiloRepository extends JpaRepository<Estilo,Long> { 

}
