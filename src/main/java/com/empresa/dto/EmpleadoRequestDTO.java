package com.empresa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
  

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
   
public class EmpleadoRequestDTO {
	
	private String nombre;
	private String apellido;
	private String num_dni;
	private String cargo_puesto;
	private String departamento;
	private String correo_emp;
	private String num_tel;
	private String estado;

}
	