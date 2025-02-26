package squad03.adapter.repositories;

import squad03.adapter.entities.AmostraEntity;
import org.springframework.stereotype.Repository;
import squad03.core.ports.AmostraRepositoryPort;

import java.util.List;

@Repository
public class AmostraRepositoryAdapter implements AmostraRepositoryPort {

    private final AmostraRepository amostraRepository;

    public AmostraRepositoryAdapter(AmostraRepository amostraRepository) {
        this.amostraRepository = amostraRepository;
    }

    @Override
    public void save(AmostraEntity amostraEntity) {
        amostraRepository.save(amostraEntity);
    }

    @Override
    public List<AmostraEntity> findAll() {
        return amostraRepository.findAll();
    }

    @Override
    public List<AmostraEntity> findByMunicipioId(Long municipioId) {
        return amostraRepository.findByMunicipio_Id(municipioId);
    }
}
