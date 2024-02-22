package com.bling.contabilidadApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="id_usuario") //nombre de la llave primaria
    private long id;

    @Column(name ="name", length = 50)//nombre de la columna y el tipo de caracteres
    private String name;

}
