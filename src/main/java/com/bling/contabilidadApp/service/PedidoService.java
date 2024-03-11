package com.bling.contabilidadApp.service;
import com.bling.contabilidadApp.Entity.Pedido;
import java.util.List;

public interface PedidoService {
    public List<Pedido> findAll() throws Exception;
    public Pedido findById(int id_pedido);
    public void create(Pedido pedido);
    public void update(Pedido pedido);
    public void delete(Pedido pedido);
}
