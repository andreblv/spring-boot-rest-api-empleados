package com.empresa.controller;

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

import com.empresa.dto.EmpleadoRequestDTO;
import com.empresa.dto.EmpleadoResponseDTO;
import com.empresa.service.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping
	public ResponseEntity<Page<EmpleadoResponseDTO>> listarTodos(Pageable pageable) {
		return ResponseEntity.ok(empleadoService.listarTodos(pageable));
	}

	@PostMapping
	public ResponseEntity<EmpleadoResponseDTO> guardar(@Valid  @RequestBody EmpleadoRequestDTO empleado) {
		return ResponseEntity.ok(empleadoService.guardar(empleado));
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmpleadoResponseDTO> editar(@PathVariable Long id, 
													 @Valid @RequestBody  EmpleadoRequestDTO empleadoDTO) {
	    return ResponseEntity.ok(empleadoService.editar(id, empleadoDTO));

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmpleadoResponseDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(empleadoService.buscarPorId(id));

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id){
        empleadoService.eliminar(id);
        return ResponseEntity.noContent().build();
	}
	

}
