package com.empresa.repository;

import com.empresa.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long>  {

	
}
