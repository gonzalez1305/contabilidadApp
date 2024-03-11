package com.bling.contabilidadApp.Repository;

import com.bling.contabilidadApp.Entity.Inventario;
import com.bling.contabilidadApp.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {

}