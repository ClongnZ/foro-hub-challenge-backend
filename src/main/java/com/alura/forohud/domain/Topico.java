package com.alura.forohud.domain;

import com.alura.forohud.dto.DatosActualizarTopico;
import com.alura.forohud.dto.DatosRegistroTopicos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha_Creacion;
    private Boolean status;
    private String autor;
    private String curso;


    public Topico(DatosRegistroTopicos datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.status = true;
        this.autor = datos.autor();
        this.curso = datos.curso();
        this.fecha_Creacion = LocalDateTime.now();
    }

    public void actualizarDatos(DatosActualizarTopico datos) {
        if (datos.autor() != null && !datos.autor().isEmpty()) {
            this.autor = datos.autor();
        }
        if (datos.titulo() != null && !datos.titulo().isEmpty()) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null && !datos.mensaje().isEmpty()) {
            this.mensaje = datos.mensaje();
        }
        if (datos.curso() != null && !datos.curso().isEmpty()) {
            this.curso = datos.curso();
        }
    }

    public void desactivarTopico(){
        this.status = false;
    }
}