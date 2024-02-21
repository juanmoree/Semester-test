package com.example.testing.semester.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String respuestaA;
    private String respuestaB;
    private String respuestaC;
    private String respuestaD;
    private String respuestaCorrecta;

    @ManyToOne
    @JoinColumn(name = "pregunta_id")
    private Pregunta pregunta;
}
