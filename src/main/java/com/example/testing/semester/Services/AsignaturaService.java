package com.example.testing.semester.Services;

import com.example.testing.semester.Model.Entity.Asignatura;
import com.example.testing.semester.Repository.AsignaturaRepository;

public class AsignaturaService {

    AsignaturaRepository asignaturaRepository;
    public Asignatura addAsignatura() {
        asignaturaRepository.findByGrado()
    }
}
