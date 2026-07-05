package com.empresa.service;

import com.empresa.dto.EmpleadoResponseDTO;
import com.empresa.converter.EmpleadoConverterDTO;
import com.empresa.dto.EmpleadoRequestDTO;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empresa.repository.EmpleadoRepository;
import com.empresa.entity.Empleado;

@Service
public class EmpleadoServiceImp implements EmpleadoService{

	@Autowired
	private EmpleadoRepository empleadoRep;
	
	@Override
	public List<EmpleadoResponseDTO> listarTodos() {
	    return empleadoRep.findAll()
	            .stream()
	            .map(EmpleadoConverterDTO::toResponseDTO)
	            .toList();

	}

	@Override
	public EmpleadoResponseDTO buscarPorId(Long id) {
		Empleado empleado = empleadoRep.findById(id)
				.orElseThrow();
		return EmpleadoConverterDTO.toResponseDTO(empleado);
	}

	@Override
	public EmpleadoResponseDTO guardar(EmpleadoRequestDTO dto) {
		
		Empleado empleado = EmpleadoConverterDTO.toEntity(dto);
		Empleado empleadoGuardado = empleadoRep.save(empleado);
		return EmpleadoConverterDTO.toResponseDTO(empleadoGuardado);
	}

	@Override
	public void eliminar(Long id) {
		empleadoRep.deleteById(id);
		
	}

	@Override
	public EmpleadoResponseDTO editar(Long id, EmpleadoRequestDTO empleadoRequestDTO) {
		  
		Empleado empleado = empleadoRep.findById(id)
		        .orElseThrow();

		EmpleadoConverterDTO.updateEntity(empleado, empleadoRequestDTO);

		Empleado actualizado = empleadoRep.save(empleado);

		return EmpleadoConverterDTO.toResponseDTO(actualizado);
	}

}
