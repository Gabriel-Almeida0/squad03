package squad03.adapter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import squad03.adapter.entities.MunicipioEntity;

@Repository
public interface MunicipioRepository extends JpaRepository<MunicipioEntity, Long> {
    MunicipioEntity findByNome(String nome);
}
