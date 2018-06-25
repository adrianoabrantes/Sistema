package sistema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class EscreverArquivo {

    private FileWriter fileWriter;

    public EscreverArquivo() {
    }

    public EscreverArquivo(String nome, String local, String conteudo) {
        try {
            fileWriter = new FileWriter(new Configurar().getDiretorioAtual() + "/" + local + "/" + nome);
            try (BufferedWriter escrever = new BufferedWriter(fileWriter)) {
                escrever.write(conteudo);
                escrever.newLine();

            } catch (IOException ex) {
                System.out.println("ERRO ao escrever no arquivo " + nome + ex);
            }

        } catch (IOException ex) {
            System.out.println("ERRO ao escrever na entrada do arquivo " + nome + ex);
        }

    }
    

}
