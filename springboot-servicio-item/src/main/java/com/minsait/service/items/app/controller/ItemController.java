package com.minsait.service.items.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.service.items.app.models.Item;
import com.minsait.service.items.app.models.services.ItemService;

@RestController
public class ItemController {

	@Qualifier("ServiceFeign")
	@Autowired
	private ItemService itemService;

	@GetMapping("/listar")
	public List<Item> listarItem() {
		return this.itemService.findAll();
	}

	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return this.itemService.findById(id, cantidad);
	}
}
