package squad03.adapter.repositories;

import squad03.adapter.entities.MunicipioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipioRepository extends JpaRepository<MunicipioEntity, Long> {
}
