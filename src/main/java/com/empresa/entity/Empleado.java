package com.empresa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "empleados")

@Data
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_empleado;
	
	private String nombre;
	private String apellido;
	@Column(name = "num_dni")
	private String numDni;
	@Column(name = "cargo_puesto")
	private String cargoPuesto;
	private String departamento;
	@Column(name = "correo_emp")
	private String correoEmp;
	@Column(name = "num_tel")
	private String numTel;
	
	private String estado;

}
