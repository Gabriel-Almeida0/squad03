package squad03.adapter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "tb_amostra")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AmostraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "municipio_id", referencedColumnName = "id")
    private MunicipioEntity municipio;

    private Integer quantidadeAmostras;
    private String tipoAmostra;
    private String enderecoCaptura;
    private Date dataCaptura;
    private String identificacaoInseto;
    private String protocolo;
}
