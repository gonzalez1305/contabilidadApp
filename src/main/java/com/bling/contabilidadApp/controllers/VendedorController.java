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
           // vendedor.setId(Long.parseLong(request.get("id").toString()));
            vendedor.setNombre(request.get("name").toString());
            // Obtener el id del usuario desde la solicitud
            long userId = Long.parseLong(request.get("userId").toString());
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
        }


