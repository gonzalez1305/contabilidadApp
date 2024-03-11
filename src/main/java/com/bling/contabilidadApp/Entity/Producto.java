package com.bling.contabilidadApp.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="id_producto")
    private long id;

    @Column(name = "nombre",length = 40)
    private String nombre;

    @Column(name = "descripcion", length = 40)
    private String descripcion;

    @Column(name = "precio_unitario",  length = 50)
    private int precioUnitario;

    @Column(name = "cantidad", length = 50)
    private int cantidad;

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "talla", length = 50)
    private String talla;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "marca", length = 50)
    private String marca;

    @ManyToOne
    @JoinColumn(name = "fk_id_inventario")
    private Inventario inventario;

    @ManyToOne
    @JoinColumn(name = "fk_id_venta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "fk_id_pedido")
    private Pedido pedido;

    //muchos productos pertenecen a muchos pedidos
    @ManyToMany(mappedBy = "producto_pedido")
    List<Pedido> productos;
}
