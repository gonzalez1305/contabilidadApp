package com.bling.contabilidadApp.controllers;

import com.bling.contabilidadApp.Entity.Vendedor;
import com.bling.contabilidadApp.service.VendedorService;
import com.bling.contabilidadApp.service.imp.VendedorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/vendedor/", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.HEAD})
@CrossOrigin("*")
public class VendedorController {

    @Autowired
    private VendedorImp vendedorImp;
    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> create(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            System.out.println("@@@"+request);
            Vendedor vendedor=new Vendedor();
            //vendedor.setId(Long.parseLong(request.get("id").toString()));
            vendedor.setNombre(request.get("name").toString());

            this.vendedorImp.create(vendedor);

            response.put("status", "succes");
            response.put("data", "registro exitoso");

        } catch (Exception e) {

            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> finAll(){
        Map<String, Object> response = new HashMap<>();

        try {
            List<Vendedor> vendedorList=this.vendedorImp.findAll();
            response.put("status", "succes");
            response.put("data",vendedorList);

        } catch (Exception e) {

            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    //actualizar los datos del vendedor
    @PutMapping("update/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            Vendedor vendedor = this.vendedorImp.findById(id);
            if (vendedor == null) {
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("data", "Vendedor no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            vendedor.setNombre(request.get("name").toString());

            this.vendedorImp.create(vendedor);

            response.put("status", "succes");
            response.put("data", "actualización exitosa");

        } catch (Exception e) {
            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //eliminar vendedor
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Vendedor vendedor = this.vendedorImp.findById(id);
            if (vendedor == null) {
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("data", "Vendedor no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            this.vendedorImp.delete(vendedor);

            response.put("status", "succes");
            response.put("data", "eliminación exitosa");

        } catch (Exception e) {
            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}


