package com.example.testing.semester.Services;

import com.example.testing.semester.Model.Entity.Grado;
import com.example.testing.semester.Repository.GradoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GradoService {

    @Autowired
    private GradoRepository gradoRepository;

    public void save(Grado grado) {
        try {
            gradoRepository.save(grado);
        } catch (DataAccessException e) {
            // Excepciones específicas de acceso a datos
            throw new RuntimeException("Error al guardar el grado: " + e.getMessage(), e);
        } catch (Exception e) {
            // Excepciones generales
            throw new RuntimeException("Se produjo un error al guardar el grado", e);
        }
    }

    public List<Grado> getAllGrados() {
        try {
            return gradoRepository.findAll();
        } catch (DataAccessException e) {
            // Excepciones específicas de acceso a datos
            throw new RuntimeException("Error al recuperar todos los grados: " + e.getMessage(), e);
        } catch (Exception e) {
            // Excepciones generales
            throw new RuntimeException("Se produjo un error al recuperar todos los grados", e);
        }
    }

    public Grado getGradoById(Long id) {
        return gradoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No existe el grado con id: " + id));
    }

    public void delete(Long id) {
        if (!gradoRepository.existsById(id)) throw new RuntimeException("No existe el grado con id: " + id);
        else {
            gradoRepository.deleteById(id);
        }
    }
}
