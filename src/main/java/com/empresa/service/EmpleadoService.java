package com.empresa.service;

import com.empresa.dto.EmpleadoRequestDTO;
import com.empresa.dto.EmpleadoResponseDTO;
import com.empresa.entity.Empleado;
import java.util.*;

public interface EmpleadoService {
	
	List<EmpleadoResponseDTO> listarTodos();
	EmpleadoResponseDTO buscarPorId(Long id);
	EmpleadoResponseDTO guardar(EmpleadoRequestDTO empleadoRequestDTO);
	EmpleadoResponseDTO editar(Long id, EmpleadoRequestDTO empleadoRequestDTO);
	void eliminar(Long id);
	
}
