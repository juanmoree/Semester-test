package com.example.testing.semester.Controllers;

import com.example.testing.semester.Model.Entity.Grado;
import com.example.testing.semester.Services.GradoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/grados")
public class GradoController {

    @Autowired
    private GradoService gradoService;
    @Autowired
    private AsignaturaController asignaturaController;

    @GetMapping("/list")
    public String listGrados (Model model){
        List<Grado> grados = gradoService.getAllGrados();
        model.addAttribute("grados", grados);
        return "Lists/gradosList";
    }

    @GetMapping("/form")
    public String showGradoForm (Model model){
        model.addAttribute("grado", new Grado());
        return "form";
    }

    @GetMapping("/edit/{id}")
    @Transactional
    public String editGrado (Model model, @PathVariable Long id){
        Grado grado = gradoService.getGradoById(id);
        model.addAttribute("grado", grado);
        return "form";
    }

    @PostMapping("/save")
    public String saveGrado (@ModelAttribute Grado grado){
        gradoService.save(grado);
        return "redirect:/grados/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteGrado (@PathVariable Long id){
        gradoService.delete(id);
        return "redirect:/grados/list";
    }

    @GetMapping("/{id}/asignaturas/list")
    public String listAsignaturas (Model model, @PathVariable Long id){
        asignaturaController.listAsignaturas(model, id);
        return "Lists/gradosList";
    }
}