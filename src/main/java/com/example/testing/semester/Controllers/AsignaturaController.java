package com.example.testing.semester.Controllers;

import com.example.testing.semester.Model.Entity.Asignatura;
import com.example.testing.semester.Model.Entity.Grado;
import com.example.testing.semester.Services.AsignaturaService;
import com.example.testing.semester.Services.GradoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/grados/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;
    /*@Autowired
    private UnidadController unidadController;*/

    @GetMapping("/list")
    public String listAsignaturas(Model model, Long id) {

        List<Asignatura> asignaturas = asignaturaService.getAsignaturasGrado(id);

        model.addAttribute("asignaturas", asignaturas);
        return "Lists/asignaturasList";
    }

    @GetMapping("/form")
    public String showAsignaturaForm(Model model) {
        model.addAttribute("asignatura", new Asignatura());
        return "form";
    }

    @GetMapping("/edit/{id}")
    @Transactional
    public String editAsignatura(Model model, @PathVariable Long id) {
        Asignatura asignatura = asignaturaService.getAsignaturaById(id);
        model.addAttribute("asignatura", asignatura);
        return "form";
    }

    @PostMapping("/save")
    public String saveAsignatura(@ModelAttribute Asignatura asignatura) {
        asignaturaService.save(asignatura);
        return "redirect:/grados/asignaturas/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteAsignatura(@PathVariable Long id) {
        asignaturaService.delete(id);
        return "redirect:/grados/asignaturas/list";
    }

    /*@GetMapping("/{id}/unidades/list")
    public String listUnidades (Model model, @PathVariable Long id) {
        unidadController.listUnidades(model, id);
        return "Lists/gradosList";
    }*/
}