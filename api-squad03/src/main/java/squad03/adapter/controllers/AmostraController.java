package squad03.adapter.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import squad03.core.ports.AmostraServicePort;
import squad03.adapter.dtos.AmostraRequestDto;
import squad03.adapter.entities.AmostraEntity;
import squad03.core.ports.TokenServicePort;
import squad03.core.ports.AmostraRepositoryPort;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/amostras")
@RequiredArgsConstructor
public class AmostraController {

    private final AmostraServicePort amostraServicePort;
    private final AmostraRepositoryPort amostraRepositoryPort;
    private final TokenServicePort tokenServicePort;

    @PostMapping("/enviar")
    @ResponseStatus(HttpStatus.CREATED)
    public String enviarRequisicao(@RequestBody AmostraRequestDto amostraRequestDto, @RequestHeader("Authorization") String token) {
        if (!tokenServicePort.isValidToken(token)) {
            throw new IllegalArgumentException("Token inválido");
        }

        String protocolo = amostraServicePort.criarProtocolo(amostraRequestDto);
        return protocolo;
    }

    // Novo método GET para buscar todas as amostras por ID de município
    @GetMapping("/municipio/{municipioId}")
    public List<AmostraEntity> getAmostrasByMunicipio(@PathVariable Long municipioId) {
        return amostraRepositoryPort.findByMunicipioId(municipioId);
    }
}
