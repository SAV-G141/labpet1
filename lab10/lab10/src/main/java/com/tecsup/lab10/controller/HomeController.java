package com.tecsup.lab10.controller;

import com.tecsup.lab10.model.CursosModel;
import com.tecsup.lab10.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class HomeController {

    private final CursoService cursoService;

    @Autowired
    public HomeController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public String listarCursos(Model model) {
        List<CursosModel> cursos = cursoService.obtenerTodosLosCursos();
        model.addAttribute("cursos", cursos);
        return "listaCursos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoCurso(Model model) {
        model.addAttribute("cursosModel", new CursosModel());
        return "nuevoCurso";
    }

    @PostMapping
    public String crearCurso(@ModelAttribute CursosModel cursosModel, BindingResult result, Model model) {
        // Validación manual
        if (cursosModel.getNombreCurso() == null || cursosModel.getNombreCurso().isEmpty()) {
            result.rejectValue("nombreCurso", "error.nombreCurso", "El nombre del curso es obligatorio.");
        }
        if (cursosModel.getCreditos() == null || cursosModel.getCreditos() <= 0) {
            result.rejectValue("creditos", "error.creditos", "Los créditos deben ser mayores a cero.");
        }
        // Agrega más validaciones según sea necesario

        if (result.hasErrors()) {
            return "nuevoCurso"; // Regresar al formulario si hay errores
        }

        cursoService.guardarCurso(cursosModel);
        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCurso(@PathVariable long id, Model model) {
        CursosModel curso = cursoService.obtenerCursoPorId(id);
        model.addAttribute("cursosModel", curso);
        return "editarCurso";
    }

    @PostMapping("/editar")
    public String actualizarCurso(@ModelAttribute CursosModel cursosModel, BindingResult result, Model model) {
        // Validación manual
        if (cursosModel.getNombreCurso() == null || cursosModel.getNombreCurso().isEmpty()) {
            result.rejectValue("nombreCurso", "error.nombreCurso", "El nombre del curso es obligatorio.");
        }
        if (cursosModel.getCreditos() == null || cursosModel.getCreditos() <= 0) {
            result.rejectValue("creditos", "error.creditos", "Los créditos deben ser mayores a cero.");
        }
        // Agrega más validaciones según sea necesario

        if (result.hasErrors()) {
            return "editarCurso"; // Regresar al formulario si hay errores
        }

        cursoService.guardarCurso(cursosModel);
        return "redirect:/cursos";
    }

    @PostMapping("/borrar/{id}")
    public String borrarCurso(@PathVariable long id) {
        cursoService.borrarCurso(id);
        return "redirect:/cursos";
    }
}
