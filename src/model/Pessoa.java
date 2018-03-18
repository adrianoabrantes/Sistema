package model;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class Pessoa {

    private int id;
    private String nome;
    private String usuario;
    private String senha;

    public Pessoa() {

    }

    public Pessoa(int id, String nome, String usuario, String senha) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Pessoa(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void mostraPessoas() {
        System.out.printf("ID: %04d\nNome: %s\nUsuario: %d\nSenha: %s\n", id, nome, usuario, senha);
    }

}
