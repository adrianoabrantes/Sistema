package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import sistema.Alertas;

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
           return DriverManager.getConnection("jdbc:derby://" + enderecoBanco + ":1527/" + nomeBanco, nomeUsuario, senhaUsuario);
            } catch (SQLException ex) {
         new Alertas().Alertas("erro", "Problema encontrado:", "Servidor nao encontrado. ERRO: " + ex);
            throw new RuntimeException(ex);
        }
    }
}
