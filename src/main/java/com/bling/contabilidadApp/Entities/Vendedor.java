package com.bling.contabilidadApp.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vendedores")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Vendedor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="id_vendedor")
    private long id;

    @ManyToOne
    @JoinColumn(name = "fk_id_usuario", nullable = false)
    private Usuario usuario;
}

