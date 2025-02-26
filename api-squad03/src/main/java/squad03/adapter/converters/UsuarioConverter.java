package squad03.adapter.converters;

import squad03.adapter.dtos.UsuarioDto;
import squad03.core.domain.Municipio;
import squad03.core.domain.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {

    public Usuario toTomain(UsuarioDto usuarioDto) {
        return new Usuario(usuarioDto.getId(),
                usuarioDto.getNome(),
                usuarioDto.getSenha(),
                new Municipio(null, usuarioDto.getNome())
        );
    }

    public UsuarioDto toDto(Usuario usuario) {
        return new UsuarioDto(usuario.getId(),
                usuario.getMunicipio().getNome(),
                usuario.getNome()
        );
    }
}
