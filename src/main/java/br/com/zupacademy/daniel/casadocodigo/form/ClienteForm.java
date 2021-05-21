package br.com.zupacademy.daniel.casadocodigo.form;

import br.com.zupacademy.daniel.casadocodigo.common.PaisEstadoId;
import br.com.zupacademy.daniel.casadocodigo.config.validacao.CpfOuCnpj;
import br.com.zupacademy.daniel.casadocodigo.config.validacao.EstadoObrigatorioSeExisteNoPais;
import br.com.zupacademy.daniel.casadocodigo.config.validacao.ValorUnico;
import br.com.zupacademy.daniel.casadocodigo.model.Cliente;
import br.com.zupacademy.daniel.casadocodigo.model.Estado;
import br.com.zupacademy.daniel.casadocodigo.model.Pais;
import br.com.zupacademy.daniel.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.daniel.casadocodigo.repository.PaisRepository;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class ClienteForm {
    @Email
    @NotBlank
    @ValorUnico(classe = Cliente.class, campo = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @CpfOuCnpj
    private String cpfCnpj;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @Valid
    @EstadoObrigatorioSeExisteNoPais
    private PaisEstadoId paisEstadoId;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteForm(String email,
                       String nome,
                       String sobrenome,
                       String cpfCnpj,
                       String endereco,
                       String complemento,
                       String cidade,
                       Long idPais,
                       Long idEstado,
                       String telefone,
                       String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisEstadoId = new PaisEstadoId(idPais, idEstado);
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente convert(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        Optional<Pais> paisOptional = paisRepository.findById(this.paisEstadoId.getIdPais());
        if (paisOptional.isEmpty()) {
            throw new IllegalArgumentException("Não foi encontrado nenhum país no banco de dados com esse id");
        }

        Cliente cliente =  new Cliente( this.email,
                                        this.nome,
                                        this.sobrenome,
                                        this.cpfCnpj,
                                        this.endereco,
                                        this.complemento,
                                        this.cidade,
                                        paisOptional.get(),
                                        this.telefone,
                                        this.cep);

        if (this.paisEstadoId.getIdEstado() != null) {
            Optional<Estado> estadoOptional = estadoRepository.findById(this.paisEstadoId.getIdEstado());
            if (estadoOptional.isEmpty()) {
                throw new IllegalArgumentException("Não foi encontrado nenhum estado no banco de dados com esse id");
            }
            cliente.setEstado(estadoOptional.get());
        }
        return cliente;
    }

    public PaisEstadoId getPaisEstadoId() {
        return paisEstadoId;
    }
}
