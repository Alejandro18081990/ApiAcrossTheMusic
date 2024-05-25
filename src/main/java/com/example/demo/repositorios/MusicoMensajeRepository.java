package com.example.demo.repositorios;

import com.example.demo.entities.Mensaje;
import com.example.demo.entities.MusicoMensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicoMensajeRepository extends JpaRepository<MusicoMensaje, Long> {

    List<MusicoMensaje> findMusicoMensajeByMusicoDestinatarioIdMusico(Long id);
}
