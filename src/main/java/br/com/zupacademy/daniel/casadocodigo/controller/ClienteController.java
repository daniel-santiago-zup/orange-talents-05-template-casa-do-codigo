package br.com.zupacademy.daniel.casadocodigo.controller;

import br.com.zupacademy.daniel.casadocodigo.form.ClienteForm;
import br.com.zupacademy.daniel.casadocodigo.model.Cliente;
import br.com.zupacademy.daniel.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.daniel.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.daniel.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    PaisRepository paisRepository;
    @Autowired
    EstadoRepository estadoRepository;

    @PostMapping
    public Long cadastraCliente(@RequestBody @Valid ClienteForm clienteForm) {
        Cliente cliente =  clienteRepository.save(clienteForm.convert(paisRepository,estadoRepository));
        return cliente.getId();
    }
}
