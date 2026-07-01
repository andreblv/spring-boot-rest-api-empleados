package com.empresa.service;

import com.empresa.entity.Empleado;
import java.util.*;

public interface EmpleadoService {
	
	public abstract List<Empleado> listarTodos();
	public abstract Optional<Empleado> buscarPorId(Long id);
	public abstract Empleado guardar(Empleado empleado);
	public void eliminar (Long id);
	
}
