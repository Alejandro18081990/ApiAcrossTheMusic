package com.example.demo.repositorios;

import com.example.demo.entities.Grupo;
import com.example.demo.entities.JamSession;
import com.example.demo.entities.MusicoTocaJam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicoTocaJamRepository extends JpaRepository<MusicoTocaJam, Long> {

}
