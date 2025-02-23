package squad03.adapter.repositories;

import squad03.adapter.entities.UsuarioEntity;
import squad03.core.domain.Usuario;
import squad03.core.ports.UsuarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioRepository usuarioRepository;
    private final MunicipioRepositoryAdapter MunicipioRepository;
    private final ModelMapper modelMapper;

    @Override
    public Usuario create(Usuario usuario) {
        UsuarioEntity usuarioEntity = modelMapper.map(usuario, UsuarioEntity.class);
        usuarioEntity.setMunicipioEntity(MunicipioRepository.createMunicipio(usuario.getMunicipio()));
        UsuarioEntity novoUsuario = usuarioRepository.save(usuarioEntity);
        return modelMapper.map(novoUsuario, Usuario.class);
    }

    @Override
    public Usuario obtainByNome(String nome) {
        UsuarioEntity usuarioByNome = usuarioRepository
                .findByNome(nome);
        if (usuarioByNome == null) {
            return null;
        }
        return modelMapper.map(usuarioByNome, Usuario.class);
    }

}
