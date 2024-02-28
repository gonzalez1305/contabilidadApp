package com.bling.contabilidadApp.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "transacciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_transaccion")
    private long id;


    @Column(name ="nombre_propietario", length = 30, nullable = false)
    private String nombre_propietario;

    @Column(name = "metodo_pago",length = 30,nullable = false)
    private String metodo_pago;

    @Column(name = "cedula",length = 30, nullable = false)
    private int cedula;

    @Column(name = "numero_tarjeta",length = 30,nullable = false)
    private String numero_tarjeta;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    /*@ManyToOne
    @JoinColumn(name = "fk_id_pago", nullable = false)
    private Pago pago;*/
}

