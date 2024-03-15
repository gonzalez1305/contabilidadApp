package com.bling.contabilidadApp.service.imp;
import com.bling.contabilidadApp.Entity.Pedido;
import com.bling.contabilidadApp.repository.PedidoRepository;
import com.bling.contabilidadApp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoImp implements PedidoService{
    @Autowired
    private PedidoRepository pedidoRepository;


    @Override
    public List<Pedido> findAll()  {
        return this.pedidoRepository.findAll();
    }

    @Override
    public Pedido findById(Long id_pedido) {return this.pedidoRepository.findById(id_pedido).orElse(null);
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
