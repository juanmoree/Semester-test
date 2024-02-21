package com.example.testing.semester.Services;

import com.example.testing.semester.Model.Entity.Nivel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class NivelService {
    public List<Nivel> findByAsignaturaId(Long asignaturaId) {
        return null;
    }

    public void saveOrUpdateNivel(Nivel nivel) {
    }

    public void deleteNivel(Long nivelId) {
    }
}
