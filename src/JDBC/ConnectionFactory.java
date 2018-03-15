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
        String nomeUsuario = "sistema";
        String senhaUsuario = "sistema";
        String enderecoBanco = "localhost";
        String nomeBanco = "sistema";

        try {
            //System.out.println("Conectato!");
        return DriverManager.getConnection("jdbc:derby://" + enderecoBanco + ":1527/" + nomeBanco, nomeUsuario, senhaUsuario);
            } catch (SQLException ex) {
            System.out.println("Servidor nao encontrado. ERRO: " + ex);
            throw new RuntimeException(ex);
        }
    }
}
