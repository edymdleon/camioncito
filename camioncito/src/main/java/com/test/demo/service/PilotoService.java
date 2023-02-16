package com.test.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.demo.data.Piloto;
import com.test.demo.repositorio.PilotoRepositorio;

@Service
public class PilotoService {

	@Autowired
	private PilotoRepositorio pilotoRepositorio;
	
	
	public Piloto create (Piloto piloto) {
		return pilotoRepositorio.save(piloto);
	}
	
	public List<Piloto> getAllPilotos (){
		return pilotoRepositorio.findAll();
	}
	
	public void delete (Piloto piloto) {
		pilotoRepositorio.delete(piloto);
	}
	
	public Optional<Piloto> findById (Long id) {
		return pilotoRepositorio.findById(id);
	}
}
