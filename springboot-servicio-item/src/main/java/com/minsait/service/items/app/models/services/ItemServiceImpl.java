package com.minsait.service.items.app.models.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.minsait.service.items.app.models.Item;
import com.minsait.service.items.app.models.Producto;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays
				.asList(this.clienteRest.getForObject("http://localhost:8001/producto/listar", Producto[].class));

		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> mapa = new HashMap<>();
		mapa.put("id", id.toString());

		Producto producto = this.clienteRest.getForObject("http://localhost:8001/producto/ver/{id}", Producto.class,
				mapa);

		return new Item(producto, cantidad);
	}

}
