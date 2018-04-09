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

}
