package com.bling.contabilidadApp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Column(name ="name", length = 30, nullable = false)//nombre de la columna y el tipo de caracteres
    private String name;

    @Column(name ="apellido", length = 30, nullable = false)//nombre de la columna y el tipo de caracteres
    private String apellido;

    @Column(name ="telefono", length = 11, nullable = false)//nombre de la columna y el tipo de caracteres
    private int telefono;

    @Column(name ="direccion", length = 40, nullable = false)//nombre de la columna y el tipo de caracteres
    private String direccion;

    @Column(name ="fecha_Nacimiento", length = 30, nullable = false)//nombre de la columna y el tipo de caracteres
    private String fechaNacimiento;

    @Column(name ="email", length = 30, nullable = false)//nombre de la columna y el tipo de caracteres
    private String email;

    @Column(name ="contraseña", length = 80, nullable = false)//nombre de la columna y el tipo de caracteres
    private String contraseña;

    @Column(name ="estado", length = 30, nullable = false)//nombre de la columna y el tipo de caracteres
    private String estado;

    @Column(name ="tipo_Usuario", length = 30, nullable = false)//nombre de la columna y el tipo de caracteres
    private int tipoUsuario;

    @Column(name ="fk_id_rol", length = 30, nullable = false)//nombre de la columna y el tipo de caracteres
    private int fk_id_rol;

    //un usuario puede tener varios roles
    @ManyToMany
    @JoinTable(
            name = "uso_roles",
            joinColumns = @JoinColumn(name = "usuario_fk_id_rol"),
            inverseJoinColumns = @JoinColumn(name = "rol_id_rol"))
    List<Rol> usuario_rol;

}
