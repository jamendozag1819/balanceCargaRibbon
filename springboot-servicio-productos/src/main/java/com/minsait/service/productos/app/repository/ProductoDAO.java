package com.minsait.service.productos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsait.service.productos.app.models.entity.Producto;

public interface ProductoDAO extends JpaRepository<Producto, Long> {

}
