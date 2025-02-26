package squad03.core.domain;

import java.time.LocalDate;

public class Amostra {
    private String municipio;
    private int quantidadeAmostras;
    private String tipoAmostra;
    private String enderecoCaptura;
    private LocalDate dataCaptura;
    private String identificacaoInseto;

    public Amostra(String municipio, int quantidadeAmostras, String tipoAmostra, String enderecoCaptura, LocalDate dataCaptura, String identificacaoInseto) {
        this.municipio = municipio;
        this.quantidadeAmostras = quantidadeAmostras;
        this.tipoAmostra = tipoAmostra;
        this.enderecoCaptura = enderecoCaptura;
        this.dataCaptura = dataCaptura;
        this.identificacaoInseto = identificacaoInseto;
    }

    // Getters e Setters
    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getQuantidadeAmostras() {
        return quantidadeAmostras;
    }

    public void setQuantidadeAmostras(int quantidadeAmostras) {
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

    public String getIdentificacaoInseto() {
        return identificacaoInseto;
    }

    public void setIdentificacaoInseto(String identificacaoInseto) {
        this.identificacaoInseto = identificacaoInseto;
    }
}
