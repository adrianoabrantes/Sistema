package sistema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class Config {

    private LocalDateTimeStringConverter dataHora = new LocalDateTimeStringConverter();
    private String data = dataHora.toString(LocalDateTime.of(LocalDate.now(), LocalTime.now()));

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

}
