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
        String banco = "derby";
        String nomeUsuario = "sistema";
        String senhaUsuario = "sistema";
        int porta = 1527;
        String enderecoBanco = "localhost";
        String nomeBanco = "sistema";
        try {
           return DriverManager.getConnection("jdbc:" + banco + "://" + enderecoBanco + ":" + porta + "/" + nomeBanco, nomeUsuario, senhaUsuario);
        } catch (SQLException ex) {
            new Alertas().Erro("Problema encontrado:", "Servidor nao encontrado. ERRO: " + ex);
            throw new RuntimeException(ex);
        }
    }

    public ConnectionFactory() {

    }

    ConnectionFactory(String banco, String nomeUsuario, String senhaUsuario, int porta, String enderecoBanco, String nomeBanco) {
        try {
            DriverManager.getConnection("jdbc:" + banco + "://" + enderecoBanco + ":" + porta + "/" + nomeBanco, nomeUsuario, senhaUsuario);
        } catch (SQLException ex) {
            new Alertas().Erro("Problema encontrado:", "Servidor nao encontrado. ERRO: " + ex);
            throw new RuntimeException(ex);
        }
    }

}
