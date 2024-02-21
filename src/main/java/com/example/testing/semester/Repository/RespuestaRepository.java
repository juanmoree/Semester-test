package com.example.testing.semester.Repository;

import com.example.testing.semester.Model.Entity.Pregunta;
import com.example.testing.semester.Model.Entity.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    List<Respuesta> findByPregunta(Pregunta pregunta);
}
