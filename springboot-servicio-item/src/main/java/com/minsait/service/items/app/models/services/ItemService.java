package com.minsait.service.items.app.models.services;

import java.util.List;

import com.minsait.service.items.app.models.Item;

public interface ItemService {
	public List<Item> findAll();

	public Item findById(Long id, Integer cantidad);
	
}
