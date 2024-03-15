package com.bling.contabilidadApp.controllers;
import com.bling.contabilidadApp.Entity.Vendedor;
import com.bling.contabilidadApp.Entity.Venta;
import com.bling.contabilidadApp.service.imp.VendedorImp;
import com.bling.contabilidadApp.service.imp.VentaImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/venta", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.HEAD})
@CrossOrigin("*")
public class VentaController {

    @Autowired
    private VentaImp ventaImp;
    @Autowired
    private VendedorImp vendedorImp;

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> create(@RequestBody List<Map<String, Object>> requests) {
        Map<String, Object> response = new HashMap<>();

        try {
            for (Map<String, Object> request : requests) {
                Venta venta = new Venta();
                venta.setEstado(request.get("estado").toString());
                venta.setFecha(Date.valueOf(request.get("fecha").toString()));
                venta.setTotal_cantidad(Integer.parseInt(request.get("total_cantidad").toString()));
                venta.setTotal_venta(Integer.parseInt(request.get("total_venta").toString()));
                Vendedor vendedor = vendedorImp.findById(Long.parseLong(request.get("fk_cod_vendedor").toString()));
                venta.setVendedor(vendedor);
                this.ventaImp.create(venta);

            }

            response.put("status", "success");
            response.put("data", "registros exitosos");

        } catch (Exception e) {
            response.put("status", HttpStatus.BAD_REQUEST);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> finAll(){
        Map<String, Object> response = new HashMap<>();

        try {
            List<Venta> ventaList=this.ventaImp.findAll();
            response.put("status", "success");
            response.put("data", ventaList);

        } catch (Exception e) {
            response.put("status", HttpStatus.BAD_REQUEST);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    // actualizar los datos de la venta
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            Venta venta = this.ventaImp.findById(id);
            if (venta == null) {
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("data", "Venta no encontrada");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            venta.setEstado(request.get("estado").toString());
            venta.setFecha(Date.valueOf(request.get("fecha").toString()));
            venta.setTotal_cantidad(Integer.parseInt(request.get("total_cantidad").toString()));
            venta.setTotal_venta(Integer.parseInt(request.get("total_venta").toString()));
            this.ventaImp.create(venta);

            response.put("status", "success");
            response.put("data", "actualización exitosa");

        } catch (Exception e) {
            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // eliminar venta
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Venta venta = this.ventaImp.findById(id);
            if (venta == null) {
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("data", "Venta no encontrada");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            this.ventaImp.delete(venta);

            response.put("status", "success");
            response.put("data", "eliminación exitosa");

        } catch (Exception e) {
            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
