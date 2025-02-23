package squad03.core.domain;

public class Usuario {
    private Long id;
    private String nome;
    private String senha;
    private Municipio municipio;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String senha, Municipio municipio) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.municipio = municipio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
