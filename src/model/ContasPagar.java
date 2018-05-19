package model;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class ContasPagar {

    private int id;
    private String nomeFornecedor;
    private String mercadoria;
    private String dataCompra;
    private String dataVencimento;
    private double valor;
    private boolean alertaMensal;

    public ContasPagar() {
    }

    public ContasPagar(int id, String nomeFornecedor, String mercadoria, String dataCompra, String dataVencimento, double valor, boolean alertaMensal) {
        this.id = id;
        this.nomeFornecedor = nomeFornecedor;
        this.mercadoria = mercadoria;
        this.dataCompra = dataCompra;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.alertaMensal = alertaMensal;
    }

    public ContasPagar(String nomeFornecedor, String mercadoria, String dataCompra, String dataVencimento, double valor, boolean alertaMensal) {
        this.nomeFornecedor = nomeFornecedor;
        this.mercadoria = mercadoria;
        this.dataCompra = dataCompra;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.alertaMensal = alertaMensal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
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

    public boolean isAlertaMensal() {
        return alertaMensal;
    }

    public void setAlertaMensal(boolean alertaMensal) {
        this.alertaMensal = alertaMensal;
    }
    
}
