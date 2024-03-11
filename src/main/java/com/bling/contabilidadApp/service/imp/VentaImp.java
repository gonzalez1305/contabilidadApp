package com.bling.contabilidadApp.service.imp;
import com.bling.contabilidadApp.Entity.Venta;
import com.bling.contabilidadApp.repository.VentaRepository;
import com.bling.contabilidadApp.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaImp implements VentaService{

    @Autowired
    private VentaRepository ventaRepository;


    @Override
    public List<com.bling.contabilidadApp.Entity.Venta> findAll() throws Exception {
        return this.ventaRepository.findAll();
    }
    @Override
    public com.bling.contabilidadApp.Entity.Venta findById(int id_ventas) {
        return this.ventaRepository.findById((long) id_ventas).orElse(null);
    }

    @Override
    public void create(com.bling.contabilidadApp.Entity.Venta venta) {

        this.ventaRepository.save(venta);
    }

    @Override
    public void update(com.bling.contabilidadApp.Entity.Venta venta) {
        this.ventaRepository.save(venta);
    }

    @Override
    public void delete(com.bling.contabilidadApp.Entity.Venta venta) {
        this.ventaRepository.save(venta);
    }
}
