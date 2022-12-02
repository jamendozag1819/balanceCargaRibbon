package com.minsait.service.productos.app.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.service.productos.app.models.entity.Producto;
import com.minsait.service.productos.app.service.IProductoService;

import lombok.extern.log4j.Log4j;

@RequestMapping("/producto")
@RestController
public class ProductoController {

	@Autowired
	private IProductoService iProductoService;

	@GetMapping("/listar")
	public List<Producto> listarProducto() {
		List<Producto> lista = this.iProductoService.findAll();
		System.out.println("Productos : ");
		return lista;
	}

	@GetMapping("/ver/{id}")
	public Producto obtenerProducto(@PathVariable Long id) {

		Optional<Producto> producto = this.iProductoService.findById(id);

		if (producto.isEmpty()) {
			return null;
		}

		return producto.get();
	}

	@PostMapping("/save")
	public Producto guardar(Producto producto) {
		return this.iProductoService.save(producto);
	}

	@DeleteMapping("/delete")
	public void eliminar(Long id) {
		this.iProductoService.deleteById(id);
	}
}
