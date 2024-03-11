package com.bling.contabilidadApp.service;

import com.bling.contabilidadApp.Entity.Vendedor;

import java.util.List;

public interface VendedorService {
    public List<Vendedor> findAll() throws Exception;
    public Vendedor findById(Long id_vendedor);
    public void create(Vendedor vendedor);
    public void update(Vendedor vendedor);
    public void delete(Vendedor vendedor);
}
