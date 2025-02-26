package squad03.adapter.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String senha;
    @ManyToOne
    @JoinColumn(name = "municipio_id")
    private MunicipioEntity municipioEntity;
}
