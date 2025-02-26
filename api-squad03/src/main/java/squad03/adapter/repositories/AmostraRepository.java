package squad03.adapter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import squad03.adapter.entities.AmostraEntity;
import java.util.List;

public interface AmostraRepository extends JpaRepository<AmostraEntity, Long> {
    List<AmostraEntity> findByMunicipio_Id(Long municipioId);
}
