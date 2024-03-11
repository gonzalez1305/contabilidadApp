package com.bling.contabilidadApp.service;
import com.bling.contabilidadApp.Entity.Producto;

import java.util.List;

public interface ProductoService {
    public List<Producto> findAll() throws Exception;
    public Producto findById(long id_producto);
    public void create(Producto producto);
    public void update(Producto producto);
    public void delete(Producto producto);
}
