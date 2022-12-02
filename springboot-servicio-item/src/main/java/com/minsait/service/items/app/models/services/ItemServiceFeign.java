package com.minsait.service.items.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.minsait.service.items.app.clientes.ProductoClienteRest;
import com.minsait.service.items.app.models.Item;
import com.minsait.service.items.app.models.Producto;

@Service("ServiceFeign")
public class ItemServiceFeign implements ItemService {

	@Autowired
	private ProductoClienteRest clienteRest;

	@Override
	public List<Item> findAll() {
		return clienteRest.listar().stream().map(p -> new Item(p, 1)).toList();
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Producto p = this.clienteRest.detalle(id);
		return new Item(p, cantidad);
	}

}
