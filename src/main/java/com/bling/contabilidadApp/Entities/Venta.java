package com.bling.contabilidadApp.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Entity
@Table(name = "ventas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_venta")
    private long id;

    @Column(name ="estado", length = 40, nullable = false)
    private String estado;

    @Column(name ="fecha", length = 30, nullable = false)
    private Date fecha;

    @Column(name ="Total_cantidad", length = 15, nullable = false)
    private int Total_cantidad;

    @Column(name ="Total_venta", length = 60, nullable = false)
    private int Total_venta;

    /*@ManyToOne
    @JoinColumn(name = "fk_cod_vendedor", nullable = false)
    private Vendedor vendedor;*/

}

