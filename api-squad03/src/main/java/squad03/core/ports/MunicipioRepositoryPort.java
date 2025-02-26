package squad03.core.ports;

import squad03.adapter.entities.MunicipioEntity;

public interface MunicipioRepositoryPort {
    MunicipioEntity findByNome(String nome);
}
