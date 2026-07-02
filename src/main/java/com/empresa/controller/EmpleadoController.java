package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.empresa.entity.*;
import com.empresa.service.EmpleadoService;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController{
	
	@Autowired
	private EmpleadoService empleadoService;
	
	
	@GetMapping
	public ResponseEntity<List<Empleado>> listarTodos(){
		List<Empleado> empleadosObj = empleadoService.listarTodos();
		return ResponseEntity.ok(empleadosObj);
	}

}
