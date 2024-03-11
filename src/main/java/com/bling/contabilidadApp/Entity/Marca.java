package com.bling.contabilidadApp.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "marcas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="id_marcas")
    private long id;

    @Column(name = "nombre_marca", length = 50)
    private String nombreMarca;

    //muchas marcas pertenecen a muchos productos
    @ManyToMany
    @JoinTable(
            name = "marca_producto",
            joinColumns = @JoinColumn(name = "marca_id_marcas"),
            inverseJoinColumns = @JoinColumn(name = "producto_id_producto"))
    List<Producto> producto_marca;
    
}

