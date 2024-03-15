package com.bling.contabilidadApp.service;

import com.bling.contabilidadApp.Entity.Venta;

import java.util.List;

public interface VentaService {
    List<Venta> findAll();

    Venta findById(Long id_venta);

    public void create(Venta venta);

    public void update(Venta venta);

    public void delete(Venta venta);
}
