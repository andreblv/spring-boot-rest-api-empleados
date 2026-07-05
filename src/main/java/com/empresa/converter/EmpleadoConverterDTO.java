package com.empresa.converter;


import com.empresa.dto.EmpleadoRequestDTO;
import com.empresa.dto.EmpleadoResponseDTO;
import com.empresa.entity.Empleado;


public class EmpleadoConverterDTO {
	
	public static Empleado toEntity(EmpleadoRequestDTO dto){
		
		Empleado empleado = new Empleado();
		
		empleado.setNombre(dto.getNombre());
		empleado.setApellido(dto.getApellido());
		empleado.setNum_dni(dto.getNum_dni());
		empleado.setCargo_puesto(dto.getCargo_puesto());
		empleado.setDepartamento(dto.getDepartamento());
		empleado.setCorreo_emp(dto.getCorreo_emp());
		empleado.setNum_tel(dto.getNum_tel());
		empleado.setEstado(dto.getEstado());
		
		return empleado;
	}

	
	public  static EmpleadoResponseDTO toResponseDTO(Empleado empleado) {
		
		return new EmpleadoResponseDTO(
			empleado.getNombre(),
			empleado.getApellido(),
			empleado.getCargo_puesto()
		);
	}

}
