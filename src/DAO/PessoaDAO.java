package DAO;

import JDBC.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pessoa;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class PessoaDAO {

    private Connection con;

    public PessoaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public boolean add(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa(nome, idade, senha) VALUES (?,?,?);";

        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, pessoa.getNome());
            prepareStatement.setInt(2, pessoa.getIdade());
            prepareStatement.setString(3, pessoa.getSenha());
            prepareStatement.execute();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: " + pessoa.getNome() + " ERRO: " + ex);
            return false;
        }
    }
}
