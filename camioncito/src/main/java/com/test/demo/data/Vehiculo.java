package com.test.demo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "vehiculo")
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private int costo_depreciacion;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCosto_depreciacion() {
		return costo_depreciacion;
	}

	public void setCosto_depreciacion(int costo_depreciacion) {
		this.costo_depreciacion = costo_depreciacion;
	}

	public String getTipo_carga() {
		return tipo_carga;
	}

	public void setTipo_carga(String tipo_carga) {
		this.tipo_carga = tipo_carga;
	}

	private String tipo_carga;
	
	public Vehiculo () {
		
	}
	
	public Vehiculo(Long id, String nombre, int costo_depreciacion, String tipo_carga) {
		this.id = id;
		this.nombre = nombre;
		this.costo_depreciacion = costo_depreciacion;
		this.tipo_carga = tipo_carga;
	}
	
}
