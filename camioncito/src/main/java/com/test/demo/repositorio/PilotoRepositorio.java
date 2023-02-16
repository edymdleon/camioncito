package com.test.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.demo.data.Piloto;

public interface PilotoRepositorio extends JpaRepository<Piloto, Long>{

}
