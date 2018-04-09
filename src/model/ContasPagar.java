package model;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class ContasPagar {
   private int id;
   private String nome;
   private String mercadoria;
   private String dataCompra;
   private String dataVencimento;
   private double valor;
   private int totalDiasVencidos;
   private String primeiroAlerta;
   private String segundoAlerta;
   private int diasAdiados;
   private boolean cancelado;
   private boolean pago;
   private String dataPagamento;
   private int numComprovante;

    public ContasPagar() {
    }

    public ContasPagar(int id, String nome, String mercadoria, String dataCompra, String dataVencimento, double valor, int totalDiasVencidos, String primeiroAlerta, String segundoAlerta, int diasAdiados, boolean cancelado, boolean pago, String dataPagamento, int numComprovante) {
        this.id = id;
        this.nome = nome;
        this.mercadoria = mercadoria;
        this.dataCompra = dataCompra;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.totalDiasVencidos = totalDiasVencidos;
        this.primeiroAlerta = primeiroAlerta;
        this.segundoAlerta = segundoAlerta;
        this.diasAdiados = diasAdiados;
        this.cancelado = cancelado;
        this.pago = pago;
        this.dataPagamento = dataPagamento;
        this.numComprovante = numComprovante;
    }

    public ContasPagar(String nome, String mercadoria, String dataCompra, String dataVencimento, double valor, int totalDiasVencidos, String primeiroAlerta, String segundoAlerta, int diasAdiados, boolean cancelado, boolean pago, String dataPagamento, int numComprovante) {
        this.nome = nome;
        this.mercadoria = mercadoria;
        this.dataCompra = dataCompra;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.totalDiasVencidos = totalDiasVencidos;
        this.primeiroAlerta = primeiroAlerta;
        this.segundoAlerta = segundoAlerta;
        this.diasAdiados = diasAdiados;
        this.cancelado = cancelado;
        this.pago = pago;
        this.dataPagamento = dataPagamento;
        this.numComprovante = numComprovante;
    }

    public int getNumComprovante() {
        return numComprovante;
    }

    public void setNumComprovante(int numComprovante) {
        this.numComprovante = numComprovante;
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

    public int getTotalDiasVencidos() {
        return totalDiasVencidos;
    }

    public void setTotalDiasVencidos(int totalDiasVencidos) {
        this.totalDiasVencidos = totalDiasVencidos;
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

    public int getDiasAdiados() {
        return diasAdiados;
    }

    public void setDiasAdiados(int diasAdiados) {
        this.diasAdiados = diasAdiados;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
   
   
   
}
