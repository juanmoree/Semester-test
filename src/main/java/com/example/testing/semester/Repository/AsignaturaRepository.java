package com.example.testing.semester.Repository;

import com.example.testing.semester.Model.Entity.Asignatura;
import com.example.testing.semester.Model.Entity.Grado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
    List<Asignatura> findByGrado(Grado grado);
    Optional<Asignatura> findAsignaturaBynombreAsignatura(String asignatura);
}
