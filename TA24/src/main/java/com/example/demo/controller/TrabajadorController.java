package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.Trabajador;
import com.example.demo.service.TrabajadorServiceImpl;

@RestController
@RequestMapping("/api")
public class TrabajadorController {
	
	@Autowired
	TrabajadorServiceImpl trabajadorServideImpl;
	
	@GetMapping("/trabajador")
	public List<Trabajador> listarTrabajadores(){
		return trabajadorServideImpl.listarTrabajadores();
	}
	
	//listar Trabajadores por campo nombre
	@GetMapping("/trabajadores/nombre/{nombre}")
	public List<Trabajador> listarTrabajadorNombre(@PathVariable(name="nombre") String nombre) {
	    return trabajadorServideImpl.listarTrabajadorNombre(nombre);
	}
	 
	
	@PostMapping("/trabajador")
	public Trabajador salvarTrabajador(@RequestBody Trabajador trabajador) {
		
		return trabajadorServideImpl.guardarTrabajador(trabajador);
	}
	
	
	@GetMapping("/trabajador/{id}")
	public Trabajador trabajadorXID(@PathVariable(name="id") Long id) {
		
		Trabajador trabajador_xid= new Trabajador();
		
		trabajador_xid=trabajadorServideImpl.trabajadorXID(id);
		
		System.out.println("Trabajador XID: "+trabajador_xid);
		
		return trabajador_xid;
	}
	
	@PutMapping("/trabajador/{id}")
	public Trabajador actualizarTrabajador(@PathVariable(name="id")Long id,@RequestBody Trabajador trabajador) {
		
		Trabajador trabajador_seleccionado= new Trabajador();
		Trabajador trabajador_actualizado= new Trabajador();
		
		trabajador_seleccionado= trabajadorServideImpl.trabajadorXID(id);
		
		trabajador_seleccionado.setNombre(trabajador.getNombre());
		trabajador_seleccionado.setApellido(trabajador.getApellido());
		trabajador_seleccionado.setSalario(trabajador.getSalario());
		trabajador_seleccionado.setPuesto(trabajador.getPuesto());
		
		trabajador_actualizado = trabajadorServideImpl.actualizarTrabajador(trabajador_seleccionado);
		
		System.out.println("El trabajador actualizado es: "+ trabajador_actualizado);
		
		return trabajador_actualizado;
	}
	
	@DeleteMapping("/trabajador/{id}")
	public void eleiminarCliente(@PathVariable(name="id")Long id) {
		trabajadorServideImpl.eliminarTrabajador(id);
	}
	
}
