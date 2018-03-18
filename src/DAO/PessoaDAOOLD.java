package DAO;

import JDBC.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pessoa;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class PessoaDAOOLD {

    private final Connection con;

    public PessoaDAOOLD() {
        this.con = new ConnectionFactory().getConnection();
    }

    public boolean salvarPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, idade, senha) VALUES (?,?,?)";

        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, pessoa.getNome());
            //prepareStatement.setInt(2, pessoa.getIdade());
            prepareStatement.setString(3, pessoa.getSenha());
            prepareStatement.execute();
            prepareStatement.close();
            con.close();
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: " + pessoa.getNome() + " ERRO: " + ex);
            return false;
        }
    }

    public boolean alterarPessoa(Pessoa pessoa) throws SQLException {
        String select = "SELECT nome FROM pessoa WHERE nome=?";
        PreparedStatement prepareStatement = con.prepareStatement(select);
        prepareStatement.setString(1, pessoa.getNome());
        ResultSet rs = prepareStatement.executeQuery();

        if (rs.next()) {
            String sql = "UPDATE pessoa SET nome=?, idade=?, senha=? WHERE id=?";

            try {
                prepareStatement = con.prepareStatement(sql);
                prepareStatement.setString(1, pessoa.getNome());
                //prepareStatement.setInt(2, pessoa.getIdade());
                prepareStatement.setString(3, pessoa.getSenha());
                prepareStatement.setLong(4, pessoa.getId());
                prepareStatement.execute();
                prepareStatement.close();
                con.close();
                return true;

            } catch (SQLException ex) {
                System.out.println("Erro ao alterar: " + pessoa.getNome() + " ERRO: " + ex);
                prepareStatement.close();
                con.close();
                return false;
            }

        }
        return false;
    }

    public boolean excluirPessoa(Pessoa pessoa) throws SQLException {

        String select = "SELECT nome FROM pessoa WHERE nome=?";
        PreparedStatement prepareStatement = con.prepareStatement(select);
        prepareStatement.setString(1, pessoa.getNome());
        ResultSet rs = prepareStatement.executeQuery();
        if (rs.next()) {
            if (pessoa.getId() != 0) {
                String sql = "DELETE FROM pessoa WHERE id=?";

                try {
                    prepareStatement = con.prepareStatement(sql);
                    prepareStatement.setInt(1, pessoa.getId());
                    prepareStatement.execute();
                    prepareStatement.close();
                    con.close();
                    return true;

                } catch (SQLException ex) {
                    return false;
                }
            } else if (!pessoa.getNome().isEmpty()) {

                String sql = "DELETE FROM pessoa WHERE nome=?";

                try {
                    prepareStatement = con.prepareStatement(sql);
                    prepareStatement.setString(1, pessoa.getNome());
                    prepareStatement.execute();
                    prepareStatement.close();
                    con.close();
                    return true;

                } catch (SQLException ex) {
                    prepareStatement.close();
                    rs.close();
                    con.close();
                    return false;
                }

            }
        }
        return false;

    }

    public List<Pessoa> getList() {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(resultSet.getInt("id"));
                pessoa.setNome(resultSet.getString("nome"));
                //pessoa.setIdade(resultSet.getInt("idade"));
                pessoa.setSenha(resultSet.getString("senha"));
                pessoas.add(pessoa);
            }
            preparedStatement.close();
            resultSet.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Erro ao carregar dados da tabela Pessoa ERRO: " + e);
            return null;
        }
        return pessoas;
    }

    public boolean existe(Pessoa pessoa) {
        String sql = "SELECT nome FROM pessoa WHERE nome=?";

        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, pessoa.getNome());
            ResultSet resultado = prepareStatement.executeQuery();
            if (resultado.next()) {
                //prepareStatement.close();
                //con.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex);
            return false;

        }

    }

}
