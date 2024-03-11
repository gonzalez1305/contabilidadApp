package com.bling.contabilidadApp.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @Column(name = "nombre_marca", nullable = false, length = 50)
    private String nombreMarca;


}

