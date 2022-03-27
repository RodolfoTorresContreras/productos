package com.torres.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
	private Environment environment;

	@Autowired
	private IProductoService iProductoService;

	@GetMapping
	public List<Producto> findAll() {
		return iProductoService.findAll().stream().map(p -> {
			p.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			return p;
		}).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public Producto findById(@PathVariable Long id) {
		Producto producto = iProductoService.findById(id);
		producto.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return producto;
	}
}
