package com.test.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.demo.data.Vehiculo;

public interface VehiculoRepositorio extends JpaRepository<Vehiculo, Long> {

}
