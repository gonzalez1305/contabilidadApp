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
    public List<Venta> findAll()  {
        return this.ventaRepository.findAll();
    }

    @Override
    public Venta findById(Long id_venta) {
        return this.ventaRepository.findById(id_venta).orElse(null);
    }

    @Override
    public void create(Venta venta){this.ventaRepository.save(venta);}

    @Override
    public void update(Venta venta){this.ventaRepository.save(venta);}

    @Override
    public void delete(Venta venta){this.ventaRepository.save(venta);}
    }

