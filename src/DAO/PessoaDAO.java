package DAO;

import JDBC.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public boolean salvarPessoa(Pessoa pessoa) {
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

    public boolean alterarPessoa(Pessoa pessoa) {
        String sql = "UPDATE pessoa SET nome=?, idade=?, senha=? WHERE id=" + pessoa.getId();

        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, pessoa.getNome());
            prepareStatement.setInt(2, pessoa.getIdade());
            prepareStatement.setString(3, pessoa.getSenha());
            prepareStatement.setLong(4, pessoa.getId());
            prepareStatement.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro ao alterar: " + pessoa.getNome() + " ERRO: " + ex);
            return false;
        }
    }

    public boolean excluirPessoa(Pessoa pessoa) {
        String sql = "DELETE FROM pessoa WHERE id=" + pessoa.getId();

        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setLong(1, pessoa.getId());
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro ao excluir: " + pessoa.getNome() + " ERRO: " + ex);
            return false;
        }
    }

    public boolean existe(Pessoa pessoa) {
        String sql = "SELECT id, nome FROM pessoa WHERE nome LIKE ?";
        ResultSet resultSet;

        PreparedStatement prepareStatement;
        try {
            prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, pessoa.getNome() + "%");
            resultSet = prepareStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Nome de usuario ja esta em uso.");
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao Cadastrar novo usuario.: " + pessoa.getNome() + " ERRO: " + ex);
            return false;
        }

    }
}
