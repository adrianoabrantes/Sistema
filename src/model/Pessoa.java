package model;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class Pessoa {

    private int id;
    private String nome;
    private int idade;
    private String senha;

    public Pessoa(String nome, int idade, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.senha = senha;
    }

    public Pessoa(int id, String nome, int idade, String senha) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.senha = senha;
    }

    public Pessoa() {

    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void mostraPessoas() {
        System.out.printf("ID: %04d\nNome: %s\nIdade: %d\nSenha: %s\n", id, nome, idade, senha);
    }
}
