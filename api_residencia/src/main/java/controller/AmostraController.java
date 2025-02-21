package controller;

import model.AmostraRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import repository.AmostraRepository;

import javax.validation.Valid;

@RestController
@RequestMapping("/amostra")
public class AmostraController {

    @Autowired
    private AmostraRepository amostraRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String mostra(@Valid @RequestBody AmostraRequest amostraRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "Erro de validação: " + bindingResult.getAllErrors().get(0).getDefaultMessage();
        }

        if (amostraRequest.getQuantidadeAmostras() <= 0) {
            return "Erro: A quantidade de amostras deve ser maior que zero.";
        }

        amostraRepository.save(amostraRequest);
        return "Amostra salva com sucesso!";
    }
}
