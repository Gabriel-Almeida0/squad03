package squad03.adapter.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_municipio")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MunicipioEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
}
