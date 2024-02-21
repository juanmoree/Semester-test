package com.example.testing.semester.Controllers;

import com.example.testing.semester.Model.Entity.Asignatura;
import com.example.testing.semester.Model.Entity.Grado;
import com.example.testing.semester.Services.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api/v1/asignatura")
public class AsignaturaController {

    @Autowired
    AsignaturaService asignaturaService;
    public ResponseEntity<Asignatura> addAsignatura(@RequestParam Asignatura asignatura){

        return ResponseEntity.ok(asignaturaService.addAsignatura());
    }
}
