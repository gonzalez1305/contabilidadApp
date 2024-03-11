package com.bling.contabilidadApp.service.imp;

import com.bling.contabilidadApp.Entity.Producto;
import com.bling.contabilidadApp.repository.ProductoRepository;
import com.bling.contabilidadApp.repository.VentaRepository;
import com.bling.contabilidadApp.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductoImp implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public List<Producto> findAll() throws Exception {
        return this.productoRepository.findAll();
    }

    @Override
    public Producto findById(long id_producto) {
        return this.productoRepository.findById((long) id_producto).orElse(null);
    }

    @Override
    public void create(Producto producto) {
        this.productoRepository.save(producto);
    }

    @Override
    public void update(Producto producto) {
        this.productoRepository.save(producto);
    }

    @Override
    public void delete(Producto producto) {
        this.productoRepository.save(producto);
    }
}
