package com.example.testing.semester.Controllers;

import com.example.testing.semester.Model.Entity.Usuario;
import com.example.testing.semester.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Esto retornaría la plantilla Thymeleaf "login.html"
    }

    @PostMapping("/login")
    public String login(@RequestParam String correo, @RequestParam String contrasena) {
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            // Autenticación exitosa, redirigir a la página principal
            return "redirect:/"; // Redirigir al menú principal
        } else {
            // Autenticación fallida, redirigir de nuevo al formulario de inicio de sesión con un mensaje de error
            return "redirect:/login?error=true";
        }
    }

}
