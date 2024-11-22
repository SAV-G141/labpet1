package com.tecsup.lab10.service;

import com.tecsup.lab10.model.CursosModel;
import com.tecsup.lab10.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<CursosModel> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }

    public void guardarCurso(CursosModel cursosModel) {
        cursoRepository.save(cursosModel);
    }

    public CursosModel obtenerCursoPorId(Long id) {
        Optional<CursosModel> cursoOptional = cursoRepository.findById(id);
        return cursoOptional.orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
    }

    public void borrarCurso(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Curso no encontrado con ID: " + id);
        }
    }
}
