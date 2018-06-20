package model;

import java.io.IOException;
import sistema.CriarArquivos;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class Licenca {

    public Licenca() {
    }

    private String chaveAtivacao;
    private boolean ativado;

    public String getChaveAtivada() {
        return chaveAtivacao;
    }

    public void setChaveAtivada(String chaveAtivacao) {
        this.chaveAtivacao = chaveAtivacao;
    }

    public boolean ativarChave() throws IOException {
        if (!chaveAtivacao.isEmpty()) {
            String[] chave = {chaveAtivacao.substring(0, 2), chaveAtivacao.substring(2, 4), chaveAtivacao.substring(4, 6), chaveAtivacao.substring(6, 8), chaveAtivacao.substring(8, 10)};
            int[] licanca = new int[5];
            try {

                licanca[0] = Integer.parseInt(chave[0], 16);
                licanca[1] = Integer.parseInt(chave[1], 16);
                licanca[2] = Integer.parseInt(chave[2], 16);
                licanca[3] = Integer.parseInt(chave[3], 16);
                licanca[4] = Integer.parseInt(chave[4], 16);
            } catch (NumberFormatException numberFormatException) {
                return false;
            }
            int soma = 0;

            for (int i : licanca) {
                soma += i;

            }

            double raiz = Math.sqrt(soma);

            if (soma % 2 == 0) {
                raiz %= 2;
                if (raiz > 1.77) {
                    new CriarArquivos(".SisConf.cfg","config",CriarArquivos.TIPO.ARQUIVO);
        
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;

        }
    }

    public boolean isAtivado() {
        return ativado;
    }

    public void setAtivado(boolean ativado) {
        this.ativado = ativado;
    }
}
