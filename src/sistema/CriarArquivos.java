package sistema;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public final class CriarArquivos {

    private String nome;
    private String local;
    private Enum tipo;

    public enum TIPO {
        DIRETORIO, ARQUIVO
    };

    public CriarArquivos(String nome, String local, Enum tipo) {
        this.nome = nome;

        if (local.isEmpty()) {
            this.local = new Configurar().getDiretorioAtual();
        } else {
            this.local = new Configurar().getDiretorioAtual() + "/" + local;
        }
        this.tipo = tipo;
        criarArquivo();
    }

    private void criarArquivo() {
        File arquivo = new File(local + "/" + nome);
        try {
            if (tipo.equals(TIPO.ARQUIVO)) {
                arquivo.createNewFile();

            } else {
                arquivo.mkdir();

            }
        } catch (IOException ex) {
            System.out.println("ERRO ao criar o arquivo " + nome +" ERRO: "+ ex);
        }

    }
}
