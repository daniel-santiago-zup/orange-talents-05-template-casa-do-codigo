package br.com.zupacademy.daniel.casadocodigo.controller;

import br.com.zupacademy.daniel.casadocodigo.DTO.CategoriaDTO;
import br.com.zupacademy.daniel.casadocodigo.form.CategoriaForm;
import br.com.zupacademy.daniel.casadocodigo.model.Categoria;
import br.com.zupacademy.daniel.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public CategoriaDTO cadastraCategoria(@RequestBody @Valid CategoriaForm categoriaForm) {
        Categoria categoria = categoriaRepository.save(categoriaForm.converte());
        return new CategoriaDTO(categoria);
    }
}
