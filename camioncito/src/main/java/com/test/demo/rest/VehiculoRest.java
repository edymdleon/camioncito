package com.test.demo.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.data.Piloto;
import com.test.demo.data.Vehiculo;
import com.test.demo.service.PilotoService;
import com.test.demo.service.VehiculoService;

@RestController
@RequestMapping ("/api/vehiculo/")
public class VehiculoRest {

	@Autowired
	private VehiculoService vehiculoService;
	
	@PostMapping
	private ResponseEntity<Vehiculo> guardar ( Vehiculo vehiculo){
		Vehiculo temporal = vehiculoService.create(vehiculo);
		
		try {
			return ResponseEntity.created(new URI("/api/vehiculo"+temporal.getId())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping
	private ResponseEntity<List<Vehiculo>> listarTodosLosVehiculos (){
		return ResponseEntity.ok(vehiculoService.getAllVehiculos());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarVehiculo (@RequestBody Vehiculo vehiculo){
		vehiculoService.delete(vehiculo);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Vehiculo>> listarVehiculosPorId (@PathVariable ("id") Long id){
		return ResponseEntity.ok(vehiculoService.findById(id));
	}
}
