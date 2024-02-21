package com.example.testing.semester.Repository;

import com.example.testing.semester.Model.Entity.Asignatura;
import com.example.testing.semester.Model.Entity.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NivelRepository extends JpaRepository<Nivel, Long> {
    List<Nivel> findByAsignatura(Asignatura asignatura);
}
