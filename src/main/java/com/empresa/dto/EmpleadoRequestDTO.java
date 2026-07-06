package com.empresa.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
  

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class EmpleadoRequestDTO {
	
	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;
	@NotBlank(message = "El apellido es obligatorio")
	private String apellido;
	@NotBlank(message = "DNI requerido")
	@Pattern(regexp =  "^\\d{8}$", message = "Digite solo 8 dígitos")
	private String num_dni;
	@NotBlank(message = "El  cargo es requerido")
	private String cargo_puesto;
	@NotBlank(message = "Digite el departamento")
	private String departamento;
	@Email(message = "Correo inválido")	
	private String correo_emp;
	@NotBlank(message = "Número requerido")
	@Pattern(regexp = "^\\{9}$", message = "El número solo puede tener 9 dígitos")
	private String num_tel;
	@NotBlank(message = "El estado es obligatorio")
	private String estado;

}
	