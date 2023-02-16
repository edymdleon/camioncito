package com.test.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.data.Cliente;
import com.test.demo.repositorio.ClienteRepositorio;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	
	public Cliente create (Cliente cliente) {
		return clienteRepositorio.save(cliente);
	}
	
	public List<Cliente> getAllClientes (){
		return clienteRepositorio.findAll();
	}
	
	public void delete (Cliente cliente) {
		clienteRepositorio.delete(cliente);
	}
	
	public Optional<Cliente> findById (Long id) {
		return clienteRepositorio.findById(id);
	}
}
