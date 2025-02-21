package model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AmostraRequest {

    @NotNull(message = "O município de envio é obrigatório")
    @Size(min = 3, message = "O município de envio deve ter pelo menos 3 caracteres")
    private String municipioEnvio;

    @NotNull(message = "A quantidade de amostras é obrigatória")
    private Integer quantidadeAmostras;

    @NotNull(message = "O tipo de amostra é obrigatório")
    @Size(min = 3, message = "O tipo de amostra deve ter no mínimo 3 caracteres")
    private String tipoAmostra;

    @NotNull(message = "O endereço de captura é obrigatório")
    private String enderecoCaptura;

    @NotNull(message = "A data de captura é obrigatória")
    @PastOrPresent(message = "A data de captura não pode ser no futuro")
    private LocalDate dataCaptura;

    @NotNull(message = "A identificação do inseto ou larva é obrigatória")
    private String identificacaoInsetoLarva;

    public String getMunicipioEnvio() {
        return municipioEnvio;
    }

    public void setMunicipioEnvio(String municipioEnvio) {
        this.municipioEnvio = municipioEnvio;
    }

    public Integer getQuantidadeAmostras() {
        return quantidadeAmostras;
    }

    public void setQuantidadeAmostras(Integer quantidadeAmostras) {
        this.quantidadeAmostras = quantidadeAmostras;
    }

    public String getTipoAmostra() {
        return tipoAmostra;
    }

    public void setTipoAmostra(String tipoAmostra) {
        this.tipoAmostra = tipoAmostra;
    }

    public String getEnderecoCaptura() {
        return enderecoCaptura;
    }

    public void setEnderecoCaptura(String enderecoCaptura) {
        this.enderecoCaptura = enderecoCaptura;
    }

    public LocalDate getDataCaptura() {
        return dataCaptura;
    }

    public void setDataCaptura(LocalDate dataCaptura) {
        this.dataCaptura = dataCaptura;
    }

    public String getIdentificacaoInsetoLarva() {
        return identificacaoInsetoLarva;
    }

    public void setIdentificacaoInsetoLarva(String identificacaoInsetoLarva) {
        this.identificacaoInsetoLarva = identificacaoInsetoLarva;
    }
}
