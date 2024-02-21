package com.example.testing.semester.Services;

import com.example.testing.semester.Model.Entity.Asignatura;
import com.example.testing.semester.Repository.AsignaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AsignaturaService {

    AsignaturaRepository asignaturaRepository;

   /* public Asignatura addAsignatura(Asignatura asignatura) {
        Optional<Asignatura> existingAsignatura = asignaturaRepository.findAsignaturaByname(asignatura.getNombreAsignatura());

        if (existingAsignatura.isPresent()) {
            throw new IllegalStateException("Ya existe esa asignatura");
        }
        return asignaturaRepository.save(asignatura);
    }*/

    public Object getAllAsignaturas() {
        return asignaturaRepository.findAll();
    }

    public void saveOrUpdateAsignatura(Asignatura asignatura) {
    }

    public void deleteAsignatura(Long id) {
    }
}
