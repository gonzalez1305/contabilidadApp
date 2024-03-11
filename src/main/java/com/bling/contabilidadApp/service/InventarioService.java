package com.bling.contabilidadApp.service;

import com.bling.contabilidadApp.Entity.Inventario;
import java.util.List;

public interface InventarioService {
    public List<Inventario> findAll() throws Exception;
    public Inventario findById(int id_inventario);
    public void create(Inventario inventario);
    public void update(Inventario inventario);
    public void delete(Inventario inventario);
}
