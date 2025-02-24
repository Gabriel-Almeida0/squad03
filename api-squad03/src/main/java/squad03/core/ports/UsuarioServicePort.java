package squad03.core.ports;

import squad03.core.domain.Usuario;

public interface UsuarioServicePort {

    Usuario createUsuario(Usuario usuario);

    String login(String nome, String senha);
}
