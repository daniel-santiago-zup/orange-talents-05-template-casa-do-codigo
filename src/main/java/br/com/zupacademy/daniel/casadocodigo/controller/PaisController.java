package br.com.zupacademy.daniel.casadocodigo.controller;

import br.com.zupacademy.daniel.casadocodigo.form.PaisForm;
import br.com.zupacademy.daniel.casadocodigo.model.Pais;
import br.com.zupacademy.daniel.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public void cadastraPais(@RequestBody @Valid PaisForm paisForm) {
        Pais pais = paisForm.converte();
        paisRepository.save(pais);
    }
}
