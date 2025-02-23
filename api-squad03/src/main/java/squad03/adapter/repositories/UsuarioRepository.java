package squad03.adapter.repositories;

import squad03.adapter.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository <UsuarioEntity, Long>{
    UsuarioEntity findByNome(String nome);
}
