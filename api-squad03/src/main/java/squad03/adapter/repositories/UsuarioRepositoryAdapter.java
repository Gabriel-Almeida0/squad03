package squad03.adapter.repositories;

import squad03.adapter.entities.MunicipioEntity;
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
    private final MunicipioRepositoryAdapter municipioRepositoryAdapter;
    private final ModelMapper modelMapper;

    @Override
    public Usuario create(Usuario usuario) {
        MunicipioEntity municipioEntity = modelMapper.map(usuario.getMunicipio(), MunicipioEntity.class);

        UsuarioEntity usuarioEntity = modelMapper.map(usuario, UsuarioEntity.class);

        usuarioEntity.setMunicipioEntity(municipioRepositoryAdapter.createMunicipio(municipioEntity));

        UsuarioEntity novoUsuario = usuarioRepository.save(usuarioEntity);

        return modelMapper.map(novoUsuario, Usuario.class);
    }

    @Override
    public Usuario obtainByNome(String nome) {
        UsuarioEntity usuarioByNome = usuarioRepository.findByNome(nome);
        if (usuarioByNome == null) {
            return null;
        }
        return modelMapper.map(usuarioByNome, Usuario.class);
    }
}
