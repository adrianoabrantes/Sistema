package sistema;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public final class CriarArquivos {

    private final String diretorioAtual = System.getProperty("user.dir");
    private String nome;
    private String local;
    private Enum tipo;

    public enum TIPO {
        DIRETORIO, ARQUIVO
    };

    public CriarArquivos(String nome, String local, Enum tipo) throws IOException {
        this.nome = nome;

        if (local.isEmpty()) {
            this.local = diretorioAtual;
        } else {
            this.local = diretorioAtual + "/" + local;
        }
        this.tipo = tipo;
        criarArquivo();
    }

    private void criarArquivo() throws IOException {
        File arquivo = new File(local + "/" + nome);

        if (tipo.equals(TIPO.ARQUIVO)) {
            arquivo.createNewFile();
            //System.out.println(local + "/" + nome);

        } else {
            arquivo.mkdir();
            //System.out.println(local + "/" + nome);
        }

    }
}
