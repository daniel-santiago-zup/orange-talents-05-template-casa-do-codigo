package br.com.zupacademy.daniel.casadocodigo.controller;

import br.com.zupacademy.daniel.casadocodigo.DTO.LivroDTO;
import br.com.zupacademy.daniel.casadocodigo.DTO.LivroDetalheDTO;
import br.com.zupacademy.daniel.casadocodigo.form.LivroForm;
import br.com.zupacademy.daniel.casadocodigo.model.Livro;
import br.com.zupacademy.daniel.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.daniel.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.daniel.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    AutorRepository autorRepository;

    @GetMapping
    public Page<LivroDTO> listaLivros(Pageable pageable) {
        Page<Livro> pageLivros = livroRepository.findAll(pageable);
        return pageLivros.map(LivroDTO::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalheDTO> detalhaLivro(@PathVariable Long id) {
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        if (optionalLivro.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new LivroDetalheDTO(optionalLivro.get()));
    }

    @PostMapping
    public LivroDTO registraLivro(@RequestBody @Valid LivroForm livroForm) {
        Livro livro = livroRepository.save(livroForm.convert(categoriaRepository, autorRepository));
        return new LivroDTO(livro);
    }
}
