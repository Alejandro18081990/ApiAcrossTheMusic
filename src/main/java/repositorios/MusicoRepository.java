package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.Musico;

public interface MusicoRepository extends JpaRepository<Musico,Long> {

}
