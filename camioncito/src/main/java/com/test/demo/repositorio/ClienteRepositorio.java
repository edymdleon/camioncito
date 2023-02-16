package com.test.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.demo.data.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

}
