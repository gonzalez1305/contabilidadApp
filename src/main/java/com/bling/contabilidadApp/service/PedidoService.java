package com.bling.contabilidadApp.service;

import com.bling.contabilidadApp.Entity.Pedido;

import java.util.List;

public interface PedidoService {


    List<Pedido> findAll();

    Pedido findById(Long id_pedido);

    public void create(Pedido pedido);

    public void update(Pedido pedido);

    public void delete(Pedido pedido);
}
