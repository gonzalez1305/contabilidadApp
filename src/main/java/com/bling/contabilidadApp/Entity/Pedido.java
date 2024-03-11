package com.bling.contabilidadApp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="id_pedido")
    private long id;

    @Column(name ="fecha", length = 30, nullable = false)
    private Date fecha;

    @Column(name ="situacion", length = 30, nullable = false)
    private String situacion;

    @ManyToOne
    @JoinColumn(name = "fk_id_usuario", nullable = false)
    private Usuario usuario;

    //muchos pedidos pueden contener muchos productos
    @ManyToMany
    @JoinTable(
            name = "detalles_pedido",
            joinColumns = @JoinColumn(name = "pedido_id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "producto_id_producto"))
    List<Producto> producto_pedido;

}
