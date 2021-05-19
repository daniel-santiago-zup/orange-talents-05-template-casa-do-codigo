package br.com.zupacademy.daniel.casadocodigo.controller;

import br.com.zupacademy.daniel.casadocodigo.DTO.AutorDTO;
import br.com.zupacademy.daniel.casadocodigo.form.AutorForm;
import br.com.zupacademy.daniel.casadocodigo.model.Autor;
import br.com.zupacademy.daniel.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public AutorDTO cadastraAutor(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriComponentsBuilder) {
        Autor autor = autorForm.converte();
        autorRepository.save(autor);
        return new AutorDTO(autor);
    }
}
