package squad03.adapter.repositories;

import squad03.core.ports.MunicipioRepositoryPort;
import squad03.adapter.entities.MunicipioEntity;
import squad03.adapter.repositories.MunicipioRepository;
import org.springframework.stereotype.Component;

@Component
public class MunicipioRepositoryAdapter implements MunicipioRepositoryPort {

    private final MunicipioRepository municipioRepository;

    public MunicipioRepositoryAdapter(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    @Override
    public MunicipioEntity findByNome(String nome) {
        return municipioRepository.findByNome(nome);
    }

    public MunicipioEntity createMunicipio(MunicipioEntity municipioEntity) {
        return municipioRepository.save(municipioEntity);
    }
}
