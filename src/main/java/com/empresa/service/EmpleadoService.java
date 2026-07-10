package com.empresa.service;

import com.empresa.dto.EmpleadoRequestDTO;
import com.empresa.dto.EmpleadoResponseDTO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmpleadoService {
	
	Page<EmpleadoResponseDTO> listarTodos(Pageable pageable);
	EmpleadoResponseDTO buscarPorId(Long id);
	EmpleadoResponseDTO guardar(EmpleadoRequestDTO empleadoRequestDTO);
	EmpleadoResponseDTO editar(Long id, EmpleadoRequestDTO empleadoRequestDTO);
	List<EmpleadoResponseDTO> buscarPorNombre(String nombre);
	List<EmpleadoResponseDTO> buscarPorCargoPuesto(String cargoPuesto);
	void eliminar(Long id);
	
}
