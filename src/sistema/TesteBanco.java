package sistema;

import DAO.PessoaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pessoa;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class TesteBanco {

    public static void main(String[] args) {
        //salvar();
        deletar();
    }
    static PessoaDAO dao = new PessoaDAO();
    static Pessoa pessoa = new Pessoa();

    public static void salvar() {
        pessoa.setNome("nome");
        pessoa.setUsuario("usuario");
        pessoa.setSenha("senha");
        if (dao.salvarPessoa(pessoa)) {
            System.out.println("salvou.");
        }
    }

    public static void deletar() {
        //pessoa.setId(14);
        pessoa.setNome("sd");
        //pessoa.setId(4);
        //pessoa.setId(14);
        try {
            if (dao.excluirPessoa(pessoa)) {
                System.out.println("excluiu");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void alterar() {

    }

    public static void listar() {

    }

    public static void verificar() {

    }
}
