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

import com.test.demo.data.Cliente;
import com.test.demo.service.ClienteService;

@RestController
@RequestMapping ("/api/cliente/")
public class ClienteRest {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	private ResponseEntity<Cliente> guardar ( Cliente cliente){
		Cliente temporal = clienteService.create(cliente);
		
		try {
			return ResponseEntity.created(new URI("/api/cliente"+temporal.getId())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping
	private ResponseEntity<List<Cliente>> listarTodosLosClientes (){
		return ResponseEntity.ok(clienteService.getAllClientes());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarCliente (@RequestBody Cliente cliente){
		clienteService.delete(cliente);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Cliente>> listarClientesPorId (@PathVariable ("id") Long id){
		return ResponseEntity.ok(clienteService.findById(id));
	}
}
