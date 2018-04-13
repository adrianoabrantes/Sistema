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
        String sql = "INSERT INTO contaspagar (nome, mercadoria, datacompra, datavencimento, valor, primeiro, segundo, terceiro) VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, contasPagar.getNome());
            preparedStatement.setString(2, contasPagar.getMercadoria());
            preparedStatement.setString(3, contasPagar.getDataCompra());
            preparedStatement.setString(4, contasPagar.getDataVencimento());
            preparedStatement.setDouble(5, contasPagar.getValor());
            preparedStatement.setString(6, contasPagar.getPrimeiroAlerta());
            preparedStatement.setString(7, contasPagar.getSegundoAlerta());
            preparedStatement.setString(8, contasPagar.getTerceiroAlerta());
            preparedStatement.executeQuery();
            preparedStatement.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            new Alertas().Alertas("erro", "Problema encontrado:", "Erro ao cadastrar: " + contasPagar.getNome() + " ERRO: " + ex);
            return false;
        }
    }
}
