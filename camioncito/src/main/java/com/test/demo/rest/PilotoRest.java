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
import com.test.demo.service.PilotoService;

@RestController
@RequestMapping ("/api/piloto/")
public class PilotoRest {

	@Autowired
	private PilotoService pilotoService;
	
	@PostMapping
	private ResponseEntity<Piloto> guardar ( Piloto piloto){
		Piloto temporal = pilotoService.create(piloto);
		
		try {
			return ResponseEntity.created(new URI("/api/piloto"+temporal.getId())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping
	private ResponseEntity<List<Piloto>> listarTodosLosPilotos (){
		return ResponseEntity.ok(pilotoService.getAllPilotos());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarPiloto (@RequestBody Piloto piloto){
		pilotoService.delete(piloto);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Piloto>> listarPilotosPorId (@PathVariable ("id") Long id){
		return ResponseEntity.ok(pilotoService.findById(id));
	}
}
