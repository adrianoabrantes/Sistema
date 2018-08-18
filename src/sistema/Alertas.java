package sistema;

import javafx.scene.control.Alert;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class Alertas {

    public Alertas() {
    }

    public void Informativo(String cabecalho, String info) {
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("INFORMATIVO");
        dialogoInfo.setHeaderText(cabecalho);
        dialogoInfo.setContentText(info);
        dialogoInfo.showAndWait();
    }

    public void Erro(String cabecalho, String info) {
        Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
        dialogoErro.setTitle("ERRO");
        dialogoErro.setHeaderText(cabecalho);
        dialogoErro.setContentText(info);
        dialogoErro.showAndWait();

    }

    public void Aviso(String cabecalho, String info) {
        Alert dialogoAviso = new Alert(Alert.AlertType.WARNING);
        dialogoAviso.setTitle("AVISO");
        dialogoAviso.setHeaderText(cabecalho);
        dialogoAviso.setContentText(info);
        dialogoAviso.showAndWait();

    }

}
