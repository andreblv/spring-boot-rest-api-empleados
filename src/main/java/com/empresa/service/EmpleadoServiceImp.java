package com.empresa.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empresa.repository.EmpleadoRepository;
import com.empresa.entity.Empleado;

@Service
public class EmpleadoServiceImp implements EmpleadoService{

	@Autowired
	private EmpleadoRepository empleadoRep;
	
	@Override
	public List<Empleado> listarTodos() {
		return empleadoRep.findAll();
	}

	@Override
	public Optional<Empleado> buscarPorId(Long id) {
		return empleadoRep.findById(id);
	}

	@Override
	public Empleado guardar(Empleado empleado) {
		return empleadoRep.save(empleado);
	}

	@Override
	public void eliminar(Long id) {
		empleadoRep.deleteById(id);
		
	}


	
}
