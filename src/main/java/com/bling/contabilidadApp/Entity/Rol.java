package com.bling.contabilidadApp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_rol")
    private long id;

    @Column(name ="nombre", length = 30)
    private String nombre;

    @Column(name ="estado_del_rol", length = 30)
    private String estado_del_rol;

    //varios roles pertenecen a varios usuarios
    @ManyToMany(mappedBy = "usuario_rol")
    List<Usuario> rol;

}

