package com.empresa.repository;

import com.empresa.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>  {
	
	List<Empleado> findByNombreContainingIgnoreCase(String nombre);
	List<Empleado> findByCargoPuestoContainingIgnoreCase(String cargoPuesto);
}
	