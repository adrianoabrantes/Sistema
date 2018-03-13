package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class ConnectionFactory {

    public Connection getConnection() {
        String nomeUsuario = "postgres";
        String senhaUsuario = "postgres";
        String enderecoBanco = "localhost";
        String nomeBanco = "sistema";

        try {
            return DriverManager.getConnection("jdbc:postgresql://" + enderecoBanco + "/" + nomeBanco, nomeUsuario, senhaUsuario);
        } catch (SQLException ex) {
            System.out.println("Servidor nao encontrado. ERRO: " + ex);
            throw new RuntimeException(ex);
        }
    }
}
