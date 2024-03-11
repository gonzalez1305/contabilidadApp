package com.bling.contabilidadApp.controllers;

import com.bling.contabilidadApp.Entity.Producto;
import com.bling.contabilidadApp.Entity.Venta;
import com.bling.contabilidadApp.service.imp.ProductoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/producto", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.HEAD})
@CrossOrigin("*")
public class ProductoController {
@Autowired
    ProductoImp productoImp;
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            System.out.println("@@@"+request);
            Producto producto=new Producto();

            producto.setNombre(request.get("nombre").toString());
            producto.setDescripcion(request.get("descripcion").toString());
            producto.setPrecioUnitario(Integer.parseInt("precio_unitario"));
            producto.setCantidad(Integer.parseInt("cantidad"));
            producto.setCategoria(request.get("categoria").toString());
            producto.setEstado(request.get("estado").toString());
            producto.setTalla(request.get("talla").toString());
            producto.setColor(request.get("color").toString());
            producto.setMarca(request.get("marca").toString());

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
            List<Producto> productoList=this.productoImp.findAll();
            response.put("status", "succes");
            response.put("data",productoList);

        } catch (Exception e) {

            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
