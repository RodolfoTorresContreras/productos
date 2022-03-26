package com.torres.app.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torres.app.productos.models.entity.Producto;
import com.torres.app.productos.models.service.IProductoService;

@RestController
@RequestMapping("productos")
public class ProductoController {

	@Autowired
	private IProductoService iProductoService;

	@GetMapping
	public List<Producto> findAll(){
		return iProductoService.findAll();
	}
	
	@GetMapping("/{id}")
	public Producto findById(@PathVariable Long id) {
		return iProductoService.findById(id);
	}
}
