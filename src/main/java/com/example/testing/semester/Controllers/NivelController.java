package com.example.testing.semester.Controllers;

import com.example.testing.semester.Model.Entity.Nivel;
import com.example.testing.semester.Services.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/asignaturas")
public class NivelController {

    @Autowired
    private NivelService nivelService;

    @GetMapping("/niveles/{asignaturaId}")
    public String getNivelesByAsignatura(@PathVariable Long asignaturaId, Model model) {
        List<Nivel> niveles = nivelService.findByAsignaturaId(asignaturaId);
        model.addAttribute("niveles", niveles);
        return "redirect:/api/v1/asignaturas";
    }

    @PostMapping("/niveles/save")
    public String addOrUpdateNivel(@ModelAttribute Nivel nivel) {
        nivelService.saveOrUpdateNivel(nivel);
        return "redirect:/api/v1/asignatura";
    }

    @GetMapping("/niveles/delete/{nivelId}")
    public String deleteNivel(@PathVariable Long nivelId) {
        nivelService.deleteNivel(nivelId);
        return "redirect:/api/v1/asignatura";
    }

}
