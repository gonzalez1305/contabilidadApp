package com.bling.contabilidadApp.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "inventarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="id_inventario")
    private long id;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "cantidad_disponible", nullable = false)
    private int cantidadDisponible;

    @Column(name = "referencia", nullable = false, length = 40)
    private String referencia;

    /*@ManyToOne
    @JoinColumn(name = "fk_cod_vendedor", nullable = false)
    private Vendedor vendedor;*/
}
