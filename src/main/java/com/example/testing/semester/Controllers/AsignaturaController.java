package com.example.testing.semester.Controllers;

import com.example.testing.semester.Model.Entity.Asignatura;
import com.example.testing.semester.Model.Entity.Grado;
import com.example.testing.semester.Services.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/asignatura")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    // Mostrar la página principal con el formulario y la lista de asignaturas
    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("asignatura", new Asignatura()); // Objeto para el formulario
        model.addAttribute("asignaturas", asignaturaService.getAllAsignaturas()); // Lista para mostrar
        return "asignaturas"; // Nombre del archivo HTML (asignaturas.html)
    }

    // Agregar o actualizar asignatura
    @PostMapping("/save")
    public String addOrUpdateAsignatura(@ModelAttribute Asignatura asignatura) {
        asignaturaService.saveOrUpdateAsignatura(asignatura);
        return "redirect:/api/v1/asignatura";
    }

    // Eliminar asignatura
    @GetMapping("/delete/{id}")
    public String deleteAsignatura(@PathVariable Long id) {
        asignaturaService.deleteAsignatura(id);
        return "redirect:/api/v1/asignatura";
    }
}

