package sistema;

import javafx.scene.control.Alert;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class Alertas {

    public Alertas() {
    }

    public void Alertas(String titulo, String cabecalho, String info) {
        switch (titulo) {
            case "info":
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("Mensagem do Sistema");
                dialogoInfo.setHeaderText(cabecalho);
                dialogoInfo.setContentText(info);
                dialogoInfo.showAndWait();
                break;
            case "erro":
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Mensagem do Sistema");
                dialogoErro.setHeaderText(cabecalho);
                dialogoErro.setContentText(info);
                dialogoErro.showAndWait();
                break;
            case "aviso":
                Alert dialogoAviso = new Alert(Alert.AlertType.WARNING);
                dialogoAviso.setTitle("Mensagem do Sistema");
                dialogoAviso.setHeaderText(cabecalho);
                dialogoAviso.setContentText(info);
                dialogoAviso.showAndWait();
                break;

        }
    }

}
