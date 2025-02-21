package repository;

import model.AmostraRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmostraRepository extends JpaRepository<AmostraRequest, Long> {
}
