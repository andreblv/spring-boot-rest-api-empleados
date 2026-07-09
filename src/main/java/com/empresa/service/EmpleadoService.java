package com.empresa.service;

import com.empresa.dto.EmpleadoRequestDTO;
import com.empresa.dto.EmpleadoResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmpleadoService {
	
	Page<EmpleadoResponseDTO> listarTodos(Pageable pageable);
	EmpleadoResponseDTO buscarPorId(Long id);
	EmpleadoResponseDTO guardar(EmpleadoRequestDTO empleadoRequestDTO);
	EmpleadoResponseDTO editar(Long id, EmpleadoRequestDTO empleadoRequestDTO);
	void eliminar(Long id);
	
}
