package com.example.testing.semester.Services;

import com.example.testing.semester.Model.Entity.Grado;
import com.example.testing.semester.Repository.GradoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GradoService {

    @Autowired
    private GradoRepository gradoRepository;

    public void save(Grado grado) {
        gradoRepository.save(grado);
    }

    public List<Grado> getAllGrados() {
        return gradoRepository.findAll();
    }

    public Grado getGradoById(Long id) {
        if (!gradoRepository.existsById(id)) throw new RuntimeException("No existe el grado con id: " + id);
        else {
            return gradoRepository.findById(id).get();
        }
    }

    public void delete(Long id) {
        if (!gradoRepository.existsById(id)) throw new RuntimeException("No existe el grado con id: " + id);
        else {
            gradoRepository.deleteById(id);
        }
    }
}
