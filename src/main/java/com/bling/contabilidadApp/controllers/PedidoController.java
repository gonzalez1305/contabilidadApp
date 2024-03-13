package com.bling.contabilidadApp.controllers;

import com.bling.contabilidadApp.Entity.Pedido;
import com.bling.contabilidadApp.Entity.Venta;
import com.bling.contabilidadApp.service.imp.PedidoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/pedido", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.HEAD})
@CrossOrigin("*")
public class PedidoController {
@Autowired
PedidoImp pedidoImp;
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            System.out.println("@@@"+request);
            Pedido pedido =new Pedido();

            pedido.setFecha(Date.valueOf(request.get("fecha").toString()));
            pedido.setSituacion(request.get("situacion").toString());

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
            List<Pedido> pedidoList=this.pedidoImp.findAll();
            response.put("status", "succes");
            response.put("data",pedidoList);

        } catch (Exception e) {

            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    // actualizar los datos del pedido
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            Pedido pedido = this.pedidoImp.findById(id);
            if (pedido == null) {
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("data", "Pedido no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            pedido.setFecha(Date.valueOf(request.get("fecha").toString()));
            pedido.setSituacion(request.get("situacion").toString());

            this.pedidoImp.create(pedido);

            response.put("status", "success");
            response.put("data", "actualización exitosa");

        } catch (Exception e) {
            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // eliminar pedido
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Pedido pedido = this.pedidoImp.findById(id);
            if (pedido == null) {
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("data", "Pedido no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            this.pedidoImp.delete(pedido);

            response.put("status", "success");
            response.put("data", "eliminación exitosa");

        } catch (Exception e) {
            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
