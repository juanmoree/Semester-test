package com.example.testing.semester.Repository;

import com.example.testing.semester.Model.Entity.Grado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradoRepository extends JpaRepository <Grado, Long> {
}
