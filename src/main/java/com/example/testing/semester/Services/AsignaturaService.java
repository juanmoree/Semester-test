package com.example.testing.semester.Services;

import com.example.testing.semester.Model.Entity.Asignatura;
import com.example.testing.semester.Model.Entity.Grado;
import com.example.testing.semester.Repository.AsignaturaRepository;
import com.example.testing.semester.Repository.GradoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AsignaturaService {

    @Autowired
    private final AsignaturaRepository asignaturaRepository;
    @Autowired
    private GradoRepository gradoRepository;

    public List<Asignatura> getAsignaturasGrado(Long id) {
        Optional<Grado> existingGrado = gradoRepository.findById(id);
        if (existingGrado.isPresent()) {
            List<Asignatura> asignaturas = existingGrado.get().getAsignaturas();
            if (asignaturas.isEmpty()) {
                throw new EntityNotFoundException();
            } else {
                return asignaturas;
            }
        } else {
            throw new EntityNotFoundException();
        }
    }

    public Asignatura getAsignaturaById(Long id) {
        Optional<Asignatura> asignaturaExist = asignaturaRepository.findById(id);

        if (!asignaturaExist.isPresent()) {
            throw new EntityNotFoundException("No existe asignatura con id: " + id);
        }
        return asignaturaExist.get();
    }

    public void save(Asignatura asignatura) {
        asignaturaRepository.save(asignatura);
    }

    public void delete(Long id) {
        asignaturaRepository.deleteById(id);
    }
}
