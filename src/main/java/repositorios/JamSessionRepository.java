package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.JamSession;


public interface JamSessionRepository extends JpaRepository<JamSession,Long> {

}
