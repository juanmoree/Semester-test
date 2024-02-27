package com.example.testing.semester.Tests;

import com.example.testing.semester.Model.Entity.Grado;
import com.example.testing.semester.Repository.GradoRepository;
import com.example.testing.semester.Services.GradoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GradoServiceTest {
    @Mock
    private GradoRepository gradoRepository;

    @InjectMocks
    private GradoService gradoService;

    @BeforeEach
    void setUp() {
        // Inicializar objetos de prueba???
    }

    @Test
    void saveGradoTest() {
        // Configuración
        Grado grado = new Grado();
        grado.setId(1L);

        // Ejecución
        gradoService.save(grado);

        // Verificación
        verify(gradoRepository, times(1)).save(any(Grado.class));
    }

    @Test
    void getGradoByIdTest() {
        Grado grado = new Grado();
        grado.setId(1L);
        when(gradoRepository.findById(1L)).thenReturn(Optional.of(grado));
        Grado found = gradoService.getGradoById(1L);
        assertEquals(grado.getId(), found.getId());
    }

    @Test
    void deleteGradoTest() {
        when(gradoRepository.existsById(1L)).thenReturn(true);
        doNothing().when(gradoRepository).deleteById(1L);
        gradoService.delete(1L);
        verify(gradoRepository, times(1)).deleteById(1L);
    }

    @Test
    void getAllGradosTest() {
        // Configuración
        List<Grado> grados = new ArrayList<>();
        grados.add(new Grado(1L, "Grado A", null));
        grados.add(new Grado(2L, "Grado B", null));
        when(gradoRepository.findAll()).thenReturn(grados);

        // Ejecución
        List<Grado> result = gradoService.getAllGrados();

        // Verificación
        assertEquals(2, result.size(), "El número de grados recuperados debe ser 2");
        assertEquals("Grado A", result.get(0).getNombreGrado(), "El primer grado debe ser 'Grado A'");
        assertNotEquals("Grado B", result.get(1).getNombreGrado(), "El segundo grado debe ser 'Grado B'");
    }
}
