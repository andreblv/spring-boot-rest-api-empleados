package com.empresa.converter;


import com.empresa.dto.EmpleadoRequestDTO;
import com.empresa.dto.EmpleadoResponseDTO;
import com.empresa.entity.Empleado;


public class EmpleadoConverterDTO {
	
	public static Empleado toEntity(EmpleadoRequestDTO dto){
		
        Empleado empleado = new Empleado();

        updateEntity(empleado, dto);

        return empleado;
	}

	
	public  static EmpleadoResponseDTO toResponseDTO(Empleado empleado) {
		
		return new EmpleadoResponseDTO(
			empleado.getNombre(),
			empleado.getApellido(),
			empleado.getCargoPuesto()
		);
	}
	
	
    public static void updateEntity(Empleado empleado, EmpleadoRequestDTO dto) {

        empleado.setNombre(dto.getNombre());
        empleado.setApellido(dto.getApellido());
        empleado.setNumDni(dto.getNumDni());
        empleado.setCargoPuesto(dto.getCargoPuesto());
        empleado.setDepartamento(dto.getDepartamento());
        empleado.setCorreoEmp(dto.getCorreoEmp());
        empleado.setNumTel(dto.getNumTel());
        empleado.setEstado(dto.getEstado());

    }
	

}
