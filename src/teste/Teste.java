package teste;

import java.util.Random;
import sistema.Configurar;
import sistema.CriarArquivos;
import sistema.CriarArquivos.TIPO;
import sistema.EscreverArquivo;
import sistema.LerArquivos;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class Teste {

    public static void main(String[] args) {
        cripto();
    }

    public static void cripto() {
        System.out.println("New " + new LerArquivos().LerArquivos(".ini.dat", "config").substring(12, 14));
        System.out.println("New " + new LerArquivos().LerArquivos(".ini.dat", "config").substring(33, 35));
        System.out.println("New " + new LerArquivos().LerArquivos(".ini.dat", "config").substring(57, 59));
        System.out.println("New " + new LerArquivos().LerArquivos(".ini.dat", "config").substring(70, 72));
    }
}
