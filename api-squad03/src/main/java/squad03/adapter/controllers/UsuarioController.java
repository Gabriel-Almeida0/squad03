package squad03.adapter.controllers;

import squad03.adapter.dtos.UsuarioDto;
import squad03.core.ports.UsuarioServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServicePort usuarioServicePort;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody UsuarioDto usuarioDto) {
        return usuarioServicePort.login(usuarioDto.getNome(), usuarioDto.getSenha());
    }
}
