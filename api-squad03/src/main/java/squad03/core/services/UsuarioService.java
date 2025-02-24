package squad03.core.services;

import squad03.core.domain.Usuario;
import squad03.core.ports.UsuarioRepositoryPort;
import squad03.core.ports.UsuarioServicePort;
import squad03.core.ports.TokenServicePort;

public class UsuarioService implements UsuarioServicePort {

    private final UsuarioRepositoryPort usuarioRepositoryPort;
    private final TokenServicePort tokenServicePort;

    public UsuarioService(UsuarioRepositoryPort usuarioRepositoryPort, TokenServicePort tokenServicePort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
        this.tokenServicePort = tokenServicePort;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public String login(String nome, String senha) {
        Usuario usuario = usuarioRepositoryPort.obtainByNome(nome);
        if (usuario == null || !usuario.getSenha().equals(senha)) {
            throw new IllegalArgumentException("Credenciais inválidas!");
        }

        return tokenServicePort.generateToken(usuario.getNome());
    }
}
