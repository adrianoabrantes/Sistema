package DAO;

import JDBC.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.ContasPagar;
import sistema.Alertas;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class ContasPagarDAO {

    private final Connection con;

    public ContasPagarDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public boolean SalvarContaPagar(ContasPagar contasPagar) {
        String sql = "INSERT INTO contaspagar (nomeFornecedor, mercadoria, datacompra, datavencimento, valor, alertaMensal) VALUES (?,?,?,?,?,?)";

        try {
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, contasPagar.getNomeFornecedor());
                preparedStatement.setString(2, contasPagar.getMercadoria());
                preparedStatement.setString(3, contasPagar.getDataCompra());
                preparedStatement.setString(4, contasPagar.getDataVencimento());
                preparedStatement.setDouble(5, contasPagar.getValor());
                preparedStatement.setBoolean(6, contasPagar.isAlertaMensal());

                preparedStatement.executeQuery();
            }
            con.close();
            new Alertas().Alertas("info", "Resumo", "Conta " + contasPagar.getNomeFornecedor() + " Salvo com sucesso.");
            return true;
        } catch (SQLException ex) {
            new Alertas().Alertas("erro", "Problema encontrado:", "Erro ao cadastrar: " + contasPagar.getNomeFornecedor() + " ERRO: " + ex);
            return false;
        }
    }
}
