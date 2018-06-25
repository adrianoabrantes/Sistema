package sistema;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class LerArquivos {

    private String nome;
    private String linha;

    public String LerArquivos(String nome, String local) {
        this.nome = nome;
        try {
            FileReader arquivo = new FileReader(new Configurar().getDiretorioAtual() + "/" + local + "/" + this.nome);
            BufferedReader bufferedReader = new BufferedReader(arquivo);
            linha = bufferedReader.readLine();

        } catch (FileNotFoundException ex) {
            System.out.println("ERRO ao ler arquivo " + nome + " nao encontrado ERRO " + ex);
        } catch (IOException ex) {
            System.out.println("ERRO ao ler arquivo " + nome + " corrompido ERRO " + ex);
        }
        return getLinha();

    }

    public LerArquivos() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLinha() {
        return linha;
    }

}
