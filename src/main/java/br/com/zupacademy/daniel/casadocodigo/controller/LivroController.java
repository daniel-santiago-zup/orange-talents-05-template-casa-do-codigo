package br.com.zupacademy.daniel.casadocodigo.controller;

import br.com.zupacademy.daniel.casadocodigo.DTO.LivroDTO;
import br.com.zupacademy.daniel.casadocodigo.form.LivroForm;
import br.com.zupacademy.daniel.casadocodigo.model.Livro;
import br.com.zupacademy.daniel.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.daniel.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.daniel.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    public LivroDTO registraLivro(@RequestBody @Valid LivroForm livroForm) {
        Livro livro = livroRepository.save(livroForm.convert(categoriaRepository, autorRepository));
        return new LivroDTO(livro);
    }
}
