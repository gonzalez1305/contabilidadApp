package com.bling.contabilidadApp.Contoller;

import com.bling.contabilidadApp.Entity.Rol;
import com.bling.contabilidadApp.Services.imp.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//http://localhost:4000/roles
@RestController
@RequestMapping("/roles")
public class RolController  {
    @Autowired
    private RolService rolService;

    @GetMapping("/mostrar-por-consola")
    public ResponseEntity<List<Rol>> mostrarPorConsola() {
        List<Rol> rol = rolService.obtenerTodosLosRoles();
        return ResponseEntity.ok(rol);
    }
}