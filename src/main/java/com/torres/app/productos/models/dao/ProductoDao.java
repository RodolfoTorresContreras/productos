package com.torres.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.torres.app.productos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> {

}
