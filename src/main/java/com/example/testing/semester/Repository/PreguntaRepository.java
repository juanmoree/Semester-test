package com.example.testing.semester.Repository;

import com.example.testing.semester.Model.Entity.Nivel;
import com.example.testing.semester.Model.Entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
    List<Pregunta> findByNivel(Nivel nivel);
}
