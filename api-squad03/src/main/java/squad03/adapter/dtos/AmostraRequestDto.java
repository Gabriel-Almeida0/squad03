package squad03.adapter.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AmostraRequestDto {
    private String municipio;
    private int quantidadeAmostras;
    private String tipoAmostra;
    private String enderecoCaptura;
    private LocalDate dataCaptura;
    private String identificacaoInseto;
}
