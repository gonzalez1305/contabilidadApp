package com.bling.contabilidadApp.service.imp;
import com.bling.contabilidadApp.Entity.Vendedor;
import com.bling.contabilidadApp.repository.VendedorRepository;
import com.bling.contabilidadApp.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VendedorImp implements VendedorService {
    @Autowired
    private VendedorRepository vendedorRepository;

    @Override
    public List<Vendedor> findAll()  {
        return this.vendedorRepository.findAll();
    }

    @Override
    public Vendedor findById(Long id_vendedor) {

        return this.vendedorRepository.findById(id_vendedor).orElse(null);
    }

    @Override
    public void create(Vendedor vendedor){
        this.vendedorRepository.save(vendedor);
    }

    @Override
    public void update(Vendedor vendedor){
        this.vendedorRepository.save(vendedor);
    }

    @Override
    public void delete(Vendedor vendedor){
        this.vendedorRepository.delete(vendedor);
    }
}
