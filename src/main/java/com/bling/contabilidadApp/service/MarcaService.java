package com.bling.contabilidadApp.service;

import com.bling.contabilidadApp.Entity.Marca;

import java.util.List;

public interface MarcaService {
    public List<Marca> findAll() throws Exception;
    public Marca findById(int id_marcas);
    public void create(Marca marca);
    public void update(Marca marca);
    public void delete(Marca marca);
}