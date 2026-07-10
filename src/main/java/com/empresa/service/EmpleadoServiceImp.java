package com.empresa.service;

import com.empresa.dto.EmpleadoResponseDTO;
import com.empresa.converter.EmpleadoConverterDTO;
import com.empresa.dto.EmpleadoRequestDTO;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.empresa.repository.EmpleadoRepository;
import com.empresa.entity.Empleado;
import com.empresa.exception.ResourceNotFoundException;

@Service
public class EmpleadoServiceImp implements EmpleadoService{

	@Autowired
	private EmpleadoRepository empleadoRep;
	
	@Override
	public Page<EmpleadoResponseDTO> listarTodos(Pageable pageable) {
		 return empleadoRep.findAll(pageable)
		            .map(EmpleadoConverterDTO::toResponseDTO);
	}

	@Override
	public EmpleadoResponseDTO buscarPorId(Long id) {
		Empleado empleado = empleadoRep.findById(id)
				.orElseThrow(() ->
                	new ResourceNotFoundException("No existe un empleado con el id: " + id));
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
				.orElseThrow(() -> 
					new ResourceNotFoundException("No existe un empleado cn el id = " + id));
		EmpleadoConverterDTO.updateEntity(empleado, empleadoRequestDTO);

		Empleado actualizado = empleadoRep.save(empleado);

		return EmpleadoConverterDTO.toResponseDTO(actualizado);
	}

	@Override
	public List<EmpleadoResponseDTO> buscarPorNombre(String nombre) {
		return empleadoRep.findByNombreContainingIgnoreCase(nombre)
				.stream()
				.map(EmpleadoConverterDTO::toResponseDTO)
				.toList();
	}

	@Override
	public List<EmpleadoResponseDTO> buscarPorCargoPuesto(String cargoPuesto) {
		return empleadoRep.findByCargoPuestoContainingIgnoreCase(cargoPuesto)
				.stream()
				.map(EmpleadoConverterDTO::toResponseDTO)
				.toList();
	}

}
