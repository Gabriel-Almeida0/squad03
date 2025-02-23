package squad03.core.ports;

import squad03.core.domain.Usuario;

public interface UsuarioRepositoryPort {

    public Usuario create(Usuario usuario);

    public Usuario obtainByNome(String nome);
}
