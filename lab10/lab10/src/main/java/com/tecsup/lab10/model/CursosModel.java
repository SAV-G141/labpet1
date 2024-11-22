package com.tecsup.lab10.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "cursos")
public class CursosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CursoID")
    private Long cursoID;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NombreCurso", nullable = false, length = 100)
    private String nombreCurso;

    @Column(name = "Descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @NotNull
    @Min(1)
    @Column(name = "Creditos", nullable = false)
    private Integer creditos;

    @Size(max = 50)
    @Column(name = "Departamento", length = 50)
    private String departamento;

    @Size(max = 100)
    @Column(name = "Instructor", length = 100)
    private String instructor;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "FechaInicio")
    private Date fechaInicio;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "FechaFin")
    private Date fechaFin;
}
