package com.bling.contabilidadApp.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="id_producto")
    private long id;

    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 40)
    private String descripcion;

    @Column(name = "precio_unitario", nullable = false, length = 50)
    private int precioUnitario;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "talla", nullable = false)
    private String talla;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "marca", nullable = false)
    private String marca;

    @ManyToOne
    @JoinColumn(name = "fk_id_inventario", nullable = false)
    private Inventario inventario;

    @ManyToOne
    @JoinColumn(name = "fk_id_venta", nullable = false)
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "fk_id_pedido", nullable = false)
    private Pedido pedido;

    //muchos productos pertenecen a muchos pedidos
    @ManyToMany(mappedBy = "producto_pedido")
    List<Pedido> producto;

    //muchos productos pertenecen a muchos pedidos
    @ManyToMany(mappedBy = "producto_pedido")
    List<Pedido> productos;
}
