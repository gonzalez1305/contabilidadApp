package com.bling.contabilidadApp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "vendedores")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Vendedor implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vendedor")
    private long id;

    @Column(name = "nombre", length = 40)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_id_usuario")
    private Usuario usuario;
}
