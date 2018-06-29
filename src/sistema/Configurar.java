package sistema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class Configurar {

    private final String diretorioAtual = System.getProperty("user.dir");
    private final LocalDateTimeStringConverter dataHora = new LocalDateTimeStringConverter();
    private final String data = dataHora.toString(LocalDateTime.of(LocalDate.now(), LocalTime.now()));

    public LocalDateTimeStringConverter getDataHora() {
        return dataHora;
    }

    public String getData() {
        return data;
    }

    public String usuarioMaster(String nome, String senha) {

        int[] u = {Integer.parseInt(data.substring(0, 1)), Integer.parseInt(data.substring(1, 2)),
            Integer.parseInt(data.substring(3, 4)), Integer.parseInt(data.substring(4, 5)),
            Integer.parseInt(data.substring(6, 7)), Integer.parseInt(data.substring(7, 8)),
            Integer.parseInt(data.substring(7, 9)), Integer.parseInt(data.substring(9, 10))};

        int[] d = {Integer.parseInt(data.substring(0, 2)), Integer.parseInt(data.substring(3, 5)),
            Integer.parseInt(data.substring(6, 8)), Integer.parseInt(data.substring(8, 10))};

        int t1 = 0;
        int t2 = 0;

        for (int i = 0; i < u.length; i++) {
            t1 += u[i];
        }

        for (int i = 0; i < d.length; i++) {
            t2 += d[i];
        }
        return "MASTER" + t1 + t2;
    }

    public String getDiretorioAtual() {
        return diretorioAtual;
    }

    public int calculoPeriodoAvaliacao() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dataInicial = Calendar.getInstance();
        Calendar dataAtual = Calendar.getInstance();
        String arquivo = ".ini.dat";
        int dias = 0;
        
        try {
            dataInicial.setTime(sdf.parse(new LerArquivos().LerArquivos(arquivo, "config").substring(12, 14)
                    + "/" + new LerArquivos().LerArquivos(arquivo, "config").substring(33, 35)
                    + "/" + new LerArquivos().LerArquivos(arquivo, "config").substring(57, 59)
                    + new LerArquivos().LerArquivos(arquivo, "config").substring(70, 72)));
            dataAtual.setTime(sdf.parse(new Configurar().getData().substring(0, 10)));

            dias = dataAtual.get(Calendar.DAY_OF_YEAR)
                    - dataInicial.get(Calendar.DAY_OF_YEAR);
            return 30 - dias;

        } catch (ParseException ex) {
            System.out.println("Dados invalidos " + ex);
        }
        return 30;
    }
}
