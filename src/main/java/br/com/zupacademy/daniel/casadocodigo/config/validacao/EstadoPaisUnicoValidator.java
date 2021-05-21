package br.com.zupacademy.daniel.casadocodigo.config.validacao;

import br.com.zupacademy.daniel.casadocodigo.form.EstadoForm;
import br.com.zupacademy.daniel.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EstadoPaisUnicoValidator implements Validator {

    @Autowired
    EstadoRepository estadoRepository;

    public EstadoPaisUnicoValidator(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    public boolean supports(Class<?> clazz ) {
        return EstadoForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        EstadoForm estadoForm = (EstadoForm) o;
        if (estadoRepository.existsByNomeAndPaisId(estadoForm.getNome(),estadoForm.getIdPais())) {
            errors.rejectValue("idPais", "EstadoPaisUnicoValidator","Não pode existir dois estados iguais no mesmo país");
        }
    }
}
