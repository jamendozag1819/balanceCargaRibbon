package com.minsait.service.productos.app.service;

import java.util.List;
import java.util.Optional;

import com.minsait.service.productos.app.models.entity.Producto;

public interface IProductoService {
	
	List<Producto> findAll();

	Optional<Producto> findById(Long id);

	Producto save(Producto producto);

	void deleteById(Long id);
}
