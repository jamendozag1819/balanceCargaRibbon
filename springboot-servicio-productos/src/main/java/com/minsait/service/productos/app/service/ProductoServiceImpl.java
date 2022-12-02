package com.minsait.service.productos.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minsait.service.productos.app.models.entity.Producto;
import com.minsait.service.productos.app.repository.ProductoDAO;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoDAO productoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return this.productoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findById(Long id) {
		return this.productoDAO.findById(id);
	}

	@Override
	public Producto save(Producto producto) {
		return this.save(producto);
	}

	@Override
	public void deleteById(Long id) {
		this.deleteById(id);
	}

}
