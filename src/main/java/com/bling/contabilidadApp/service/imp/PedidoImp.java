package com.bling.contabilidadApp.service.imp;
import com.bling.contabilidadApp.Entity.Pedido;
import com.bling.contabilidadApp.repository.PedidoRepository;
import com.bling.contabilidadApp.repository.VentaRepository;
import com.bling.contabilidadApp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoImp implements PedidoService{
    @Autowired
    private PedidoRepository pedidoRepository;
    @Override
    public List<Pedido> findAll() throws Exception {
        return this.pedidoRepository.findAll();
    }

    @Override
    public Pedido findById(int id_pedido) {
        return this.pedidoRepository.findById((long) id_pedido).orElse(null);
    }

    @Override
    public void create(Pedido pedido) {
        this.pedidoRepository.save(pedido);
    }

    @Override
    public void update(Pedido pedido) {
        this.pedidoRepository.save(pedido);
    }

    @Override
    public void delete(Pedido pedido) {
        this.pedidoRepository.save(pedido);
    }
}
