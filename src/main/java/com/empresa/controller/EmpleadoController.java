package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.empresa.entity.Empleado;
import com.empresa.service.EmpleadoService;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping
	public ResponseEntity<List<Empleado>> listarTodos() {
		List<Empleado> empleadosObj = empleadoService.listarTodos();
		return ResponseEntity.ok(empleadosObj);
	}

	@PostMapping
	public ResponseEntity<Empleado> guardar(@RequestBody Empleado empleado) {
		Empleado nuevo = empleadoService.guardar(empleado);
		return ResponseEntity.ok(nuevo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Empleado> editar(@PathVariable Long id, 
			                               @RequestBody Empleado empleado) {
		empleado.setId_empleado(id);
		Empleado empleadoObj = empleadoService.guardar(empleado);
		return ResponseEntity.ok(empleadoObj);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> buscarPorId(@PathVariable Long id) {
		Optional<Empleado> empleado = empleadoService.buscarPorId(id);
		
		if (empleado.isPresent()) {
			return ResponseEntity.ok(empleado.get());
		}
		return ResponseEntity.notFound().build();

	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity eliminar(@PathVariable Long id){
		empleadoService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	

}
