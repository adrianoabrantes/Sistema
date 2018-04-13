package model;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class ContasPagar {

    private int ID;
    private String nome;
    private String mercadoria;
    private String dataCompra;
    private String dataVencimento;
    private double valor;
    private String primeiroAlerta;
    private String segundoAlerta;
    private String terceiroAlerta;

    public ContasPagar() {
    }

    public ContasPagar(int ID, String nome, String mercadoria, String dataCompra, String dataVencimento, double valor, String primeiroAlerta, String segundoAlerta, String terceiroAlerta) {
        this.ID = ID;
        this.nome = nome;
        this.mercadoria = mercadoria;
        this.dataCompra = dataCompra;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.primeiroAlerta = primeiroAlerta;
        this.segundoAlerta = segundoAlerta;
        this.terceiroAlerta = terceiroAlerta;
    }

    public ContasPagar(String nome, String mercadoria, String dataCompra, String dataVencimento, double valor, String primeiroAlerta, String segundoAlerta, String terceiroAlerta) {
        this.nome = nome;
        this.mercadoria = mercadoria;
        this.dataCompra = dataCompra;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.primeiroAlerta = primeiroAlerta;
        this.segundoAlerta = segundoAlerta;
        this.terceiroAlerta = terceiroAlerta;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMercadoria() {
        return mercadoria;
    }

    public void setMercadoria(String mercadoria) {
        this.mercadoria = mercadoria;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getPrimeiroAlerta() {
        return primeiroAlerta;
    }

    public void setPrimeiroAlerta(String primeiroAlerta) {
        this.primeiroAlerta = primeiroAlerta;
    }

    public String getSegundoAlerta() {
        return segundoAlerta;
    }

    public void setSegundoAlerta(String segundoAlerta) {
        this.segundoAlerta = segundoAlerta;
    }

    public String getTerceiroAlerta() {
        return terceiroAlerta;
    }

    public void setTerceiroAlerta(String terceiroAlerta) {
        this.terceiroAlerta = terceiroAlerta;
    }

}
