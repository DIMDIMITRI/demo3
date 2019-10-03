package com.asymmetric.demo3.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asymmetric.demo3.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

	
	
}
