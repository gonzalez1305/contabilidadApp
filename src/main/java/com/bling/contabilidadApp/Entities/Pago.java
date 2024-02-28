package com.bling.contabilidadApp.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "marcas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="id_pago")
    private long id;

    @Column(name = "total")
    private int total;

    @Column(name = "fecha_pago")
    private Date fecha_pago;

    /*@ManyToOne
    @JoinColumn(name = "fk_id_venta", nullable = false)
    private Venta venta;*/
}

