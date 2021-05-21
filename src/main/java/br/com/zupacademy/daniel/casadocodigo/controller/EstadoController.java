package br.com.zupacademy.daniel.casadocodigo.controller;

import br.com.zupacademy.daniel.casadocodigo.config.validacao.EstadoPaisUnicoValidator;
import br.com.zupacademy.daniel.casadocodigo.form.EstadoForm;
import br.com.zupacademy.daniel.casadocodigo.model.Estado;
import br.com.zupacademy.daniel.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.daniel.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    EstadoRepository estadoRepository;
    @Autowired
    PaisRepository paisRepository;
    @Autowired
    EstadoPaisUnicoValidator estadoPaisUnicoValidator;

    @InitBinder
    protected void initBinder(WebDataBinder dataBinder) {
        dataBinder.addValidators(estadoPaisUnicoValidator);
    }

    @PostMapping
    public void cadastraEstado(@RequestBody @Valid EstadoForm estadoForm) {
        Estado estado = estadoForm.converte(paisRepository);
        estadoRepository.save(estado);
    }
}
