package DAO;

import JDBC.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pessoa;
import sistema.Alertas;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class PessoaDAO {

    private final Connection con;

    public PessoaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public boolean salvarPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, usuario, senha) VALUES (?,?,?)";

        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, pessoa.getNome());
            prepareStatement.setString(2, pessoa.getUsuario());
            prepareStatement.setString(3, pessoa.getSenha());
            prepareStatement.execute();
            prepareStatement.close();
            con.close();
            new Alertas().Alertas("info", "Resumo", pessoa.getNome() + " salvo com sucesso.");
            return true;

        } catch (SQLException ex) {
            new Alertas().Alertas("erro", "Problema encontrado:", "Erro ao cadastrar: " + pessoa.getNome() + " ERRO: " + ex);
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
                prepareStatement.setString(2, pessoa.getUsuario());
                prepareStatement.setString(3, pessoa.getSenha());
                prepareStatement.setLong(4, pessoa.getId());
                prepareStatement.execute();
                prepareStatement.close();
                con.close();
                return true;

            } catch (SQLException ex) {
                new Alertas().Alertas("erro", "Problema encontrado:", "Erro ao alterar: " + pessoa.getNome() + " ERRO: " + ex);
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
                pessoa.setUsuario(resultSet.getString("usuario"));
                pessoa.setSenha(resultSet.getString("senha"));
                pessoas.add(pessoa);
            }
            preparedStatement.close();
            resultSet.close();
            con.close();

        } catch (Exception e) {
            new Alertas().Alertas("erro", "Problema encontrado:", "Erro ao carregar dados da tabela Pessoa ERRO: " + e);
            return null;
        }
        return pessoas;
    }

    public boolean login(Pessoa pessoa) {
        String sql = "SELECT usuario,senha FROM pessoa WHERE usuario=? and senha=?";

        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, pessoa.getUsuario());
            prepareStatement.setString(2, pessoa.getSenha());
            ResultSet resultado = prepareStatement.executeQuery();
            if (resultado.next()) {
                prepareStatement.close();
                con.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            new Alertas().Alertas("erro", "Problema encontrado:", "ERRO: " + ex);
            return false;

        }

    }

    public boolean existe(String usuario) {
        String sql = "SELECT usuario FROM pessoa WHERE usuario=?";
        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, usuario);
            ResultSet resultado = prepareStatement.executeQuery();
            if (resultado.next()) {
                prepareStatement.close();
                con.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            new Alertas().Alertas("erro", "Problema encontrado:", "ERRO: " + ex);
            return false;

        }
    }
}
