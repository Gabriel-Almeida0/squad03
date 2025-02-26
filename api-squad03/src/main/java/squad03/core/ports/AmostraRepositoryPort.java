package squad03.core.ports;

import squad03.adapter.entities.AmostraEntity;
import java.util.List;

public interface AmostraRepositoryPort {
    void save(AmostraEntity amostraEntity);
    List<AmostraEntity> findAll();
    List<AmostraEntity> findByMunicipioId(Long municipioId);
}
