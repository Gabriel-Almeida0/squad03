package squad03.adapter.repositories;

import squad03.adapter.entities.MunicipioEntity;
import squad03.core.domain.Municipio;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MunicipioRepositoryAdapter {

    private final MunicipioRepository municipioRepository;
    private final ModelMapper modelMapper;

    public MunicipioEntity createMunicipio(Municipio municipio) {
        MunicipioEntity municipioEntity = modelMapper.map(municipio, MunicipioEntity.class);
        return municipioRepository.save(municipioEntity);
    }
}
