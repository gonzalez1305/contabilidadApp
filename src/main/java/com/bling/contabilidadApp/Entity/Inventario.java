package com.bling.contabilidadApp.Entity;
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

    @Column(name = "cantidad", length = 50)
    private int cantidad;

    @Column(name = "fecha",length = 50)
    private Date fecha;

    @Column(name = "cantidad_disponible", length = 50)
    private int cantidadDisponible;

    @Column(name = "referencia", length = 40)
    private String referencia;

    @ManyToOne
    @JoinColumn(name = "fk_cod_vendedor")
    private Vendedor vendedor;
}
