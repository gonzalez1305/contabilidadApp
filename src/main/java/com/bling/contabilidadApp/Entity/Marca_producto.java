package com.bling.contabilidadApp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "marca_productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marca_producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="id_marca_producto")
    private long id;

    @ManyToOne
    @JoinColumn(name = "fk_id_producto", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "fk_id_marca", nullable = false)
    private Marca marca;
}
