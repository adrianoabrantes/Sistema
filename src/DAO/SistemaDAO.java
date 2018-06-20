package DAO;

import JDBC.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class SistemaDAO {

    private final Connection con;

    public SistemaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void guardaImagens(int id, String local) {
        if (id != 0) {
            String sql = "INSERT INTO imagens (id, local) VALUES (?,?);";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {

                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

    }

    public String carregarImagens(int id) {
        String sql = "select * from imagens where id=?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(id, "local");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return (resultSet.getString("local"));

            }

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex);
        }
        return null;

    }
}
