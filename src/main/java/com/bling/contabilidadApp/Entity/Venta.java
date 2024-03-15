package com.bling.contabilidadApp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "ventas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_venta")
    private long id;

    @Column(name ="estado", length = 40)
    private String estado;

    @Column(name ="fecha", length = 30)
    private Date fecha;

    @Column(name ="Total_cantidad", length = 15)
    private int Total_cantidad;

    @Column(name ="Total_venta", length = 60)
    private int Total_venta;

    @ManyToOne
    @JoinColumn(name = "fk_cod_vendedor")
    private Vendedor vendedor;

}

