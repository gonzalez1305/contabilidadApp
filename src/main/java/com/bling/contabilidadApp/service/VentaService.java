package com.bling.contabilidadApp.service;

import com.bling.contabilidadApp.Entity.Venta;

import java.util.List;

public interface VentaService {
    public List<Venta> findAll() throws Exception;
    public Venta findById(int id_ventas);
    public void create(Venta venta);
    public void update(Venta venta);
    public void delete(Venta venta);
}
