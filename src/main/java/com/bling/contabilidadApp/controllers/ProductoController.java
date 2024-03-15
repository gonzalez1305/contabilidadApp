package com.bling.contabilidadApp.controllers;
import com.bling.contabilidadApp.Entity.*;
import com.bling.contabilidadApp.service.imp.*;
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
    private ProductoImp productoImp;
    @Autowired
    private VentaImp ventaImp;

    @Autowired
    private PedidoImp pedidoImp;

    //@Autowired
    //private InventarioImp inventarioImp;
    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> create(@RequestBody List<Map<String, Object>> requests) {
        Map<String, Object> response = new HashMap<>();

        try {
            for (Map<String, Object> request : requests) {
                Producto producto = new Producto();

                producto.setNombre(request.get("nombre").toString());
                producto.setDescripcion(request.get("descripcion").toString());
                producto.setPrecioUnitario(Integer.parseInt(request.get("precio_unitario").toString()));
                producto.setCantidad(Integer.parseInt(request.get("cantidad").toString()));
                producto.setCategoria(request.get("categoria").toString());
                producto.setEstado(request.get("estado").toString());
                producto.setTalla(request.get("talla").toString());
                producto.setColor(request.get("color").toString());
                producto.setMarca(request.get("marca").toString());
                Venta venta = ventaImp.findById(Long.parseLong(request.get("fk_id_venta").toString()));
                producto.setVenta(venta);
                Pedido pedido = pedidoImp.findById(Long.parseLong(request.get("fk_id_pedido").toString()));
                producto.setPedido(pedido);
                //Inventario inventario = inventarioImp.findById(Long.parseLong(request.get("fk_id_inventario").toString()));
                //producto.setInventario(inventario);
                this.productoImp.create(producto);
            }
            response.put("status", "succes");
            response.put("data", "registro exitoso");

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
            List<Producto> productoList=this.productoImp.findAll();
            response.put("status", "succes");
            response.put("data",productoList);

        } catch (Exception e) {
            response.put("status", HttpStatus.BAD_REQUEST);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // actualizar los datos del producto
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            Producto producto = this.productoImp.findById(id);
            if (producto == null) {
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("data", "Producto no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            producto.setNombre(request.get("nombre").toString());
            producto.setDescripcion(request.get("descripcion").toString());
            producto.setPrecioUnitario(Integer.parseInt(request.get("precio_unitario").toString()));
            producto.setCantidad(Integer.parseInt(request.get("cantidad").toString()));
            producto.setCategoria(request.get("categoria").toString());
            producto.setEstado(request.get("estado").toString());
            producto.setTalla(request.get("talla").toString());
            producto.setColor(request.get("color").toString());
            producto.setMarca(request.get("marca").toString());

            this.productoImp.create(producto);

            response.put("status", "success");
            response.put("data", "actualización exitosa");

        } catch (Exception e) {
            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // eliminar producto
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Producto producto = this.productoImp.findById(id);
            if (producto == null) {
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("data", "Producto no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            this.productoImp.delete(producto);

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
