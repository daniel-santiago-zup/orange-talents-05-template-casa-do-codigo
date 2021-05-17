package br.com.zupacademy.daniel.casadocodigo.controller;

import br.com.zupacademy.daniel.casadocodigo.DTO.AutorDTO;
import br.com.zupacademy.daniel.casadocodigo.form.AutorForm;
import br.com.zupacademy.daniel.casadocodigo.model.Autor;
import br.com.zupacademy.daniel.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> detalhaAutor(@PathVariable Long id) {
        Optional<Autor> autorOptional = autorRepository.findById(id);

        if (autorOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new AutorDTO(autorOptional.get()));
    }

    @GetMapping
    public Page<AutorDTO> listaAutores(Pageable pageable) {
        Page<Autor> autorPage = autorRepository.findAll(pageable);
        return autorPage.map(AutorDTO::new);
    }

    @PostMapping
    public ResponseEntity<AutorDTO> cadastraAutor(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriComponentsBuilder) {
        Autor autor = autorForm.converte();
        autorRepository.save(autor);
        URI uri = uriComponentsBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new AutorDTO(autor));
    }
}
