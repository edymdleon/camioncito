package com.test.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.demo.data.Vehiculo;
import com.test.demo.repositorio.VehiculoRepositorio;

@Service
public class VehiculoService {

	@Autowired
	private VehiculoRepositorio vehiculoRepositorio;
	
	public Vehiculo create (Vehiculo vehiculo) {
		return vehiculoRepositorio.save(vehiculo);
	}
	
	public List<Vehiculo> getAllVehiculos (){
		return vehiculoRepositorio.findAll();
	}
	
	public void delete (Vehiculo vehiculo) {
		vehiculoRepositorio.delete(vehiculo);
	}
	
	public Optional<Vehiculo> findById (Long id) {
		return vehiculoRepositorio.findById(id);
	}
}
