package com.bling.contabilidadApp.service;

import com.bling.contabilidadApp.Entity.Rol;
import com.bling.contabilidadApp.Entity.Venta;

import java.util.List;

public interface RolService {
    public List<Rol> findAll() throws Exception;
    public Rol findById(int id_rol);
    public void create(Rol rol);
    public void update(Rol rol);
    public void delete(Rol rol);
}
