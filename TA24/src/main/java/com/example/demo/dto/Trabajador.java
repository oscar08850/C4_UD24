package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "trabajador") // en caso que la tabala sea diferente
public class Trabajador {

	// Atributos de entidad cliente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private Long id;
	@Column(name = "nombre") // no hace falta si se llama igual
	private String nombre;
	@Column(name = "apellido") // no hace falta si se llama igual
	private String apellido;
	@Column(name = "salario") // no hace falta si se llama igual
	private int salario;
	@Column(name = "puesto") // no hace falta si se llama igual
	private String puesto;

	// Constructores

	public Trabajador() {

	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param salario
	 * @param puesto
	 */
	public Trabajador(Long id, String nombre, String apellido, int salario, String puesto) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.salario = ponerSalario(puesto);
		this.puesto = puesto;
	}

	private int ponerSalario(String puesto) {
		switch (puesto) {
		case "Directivo":
			return 100000;
		case "Senior":
			return 50000;
		case "Junior":
			return 25000;
		default:
			return 25000;
		}
	}

	// Getters y setters
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getSalario() {
		return ponerSalario(this.puesto);
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		return "Trabajador [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", salario=" + salario
				+ ", puesto=" + puesto + "]";
	}

}
