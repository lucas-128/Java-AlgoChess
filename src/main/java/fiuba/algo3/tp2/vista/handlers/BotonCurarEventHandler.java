package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;
import fiuba.algo3.tp2.juego.Algochess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class BotonCurarEventHandler implements EventHandler<ActionEvent> {

    private final Stage stage;
    private Algochess algochess;
    private Pieza curandero;
    private Pieza paciente;
    protected Boolean curacionEnProgreso;

    public BotonCurarEventHandler(Algochess algochess, Stage stage) {
        this.algochess = algochess;
        curandero = null;
        paciente = null;
        curacionEnProgreso = false;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        curacionEnProgreso = true;
    }

    public void setCurandero(Pieza pieza) {
        this.curandero = pieza;
    }

    public void setPaciente(Pieza victima) {

        if(algochess.obtenerJugadorConTurno().quedanAtaques()) {
            final Popup popup = new Popup();
            VBox popupVBox = new VBox();
            popup.setAutoFix(true);
            popup.setAnchorX(1440);
            popup.setAnchorY(180);
            popup.setAutoHide(true);
            popup.setHideOnEscape(true);
            Label popupText = new Label("Curación realizada.");
            Label dismissMensaje = new Label("clickea para hacer desaparecer este mensaje");
            dismissMensaje.setId("dismiss-mensaje");
            popupVBox.getChildren().addAll(popupText, dismissMensaje);
            popupVBox.setAlignment(Pos.CENTER);
            popupVBox.getStylesheets().add("css/popup.css");
            popup.getContent().add(popupVBox);
            popup.show(stage);
        }

        this.paciente = victima;
        algochess.curarCon((Saludable) curandero, victima.getPosicion().getPosicionFila(), victima.getPosicion().getPosicionColumna());
        algochess.obtenerJugadorDelTurnoSiguiente().actualizarPiezas(algochess.getTablero());
        algochess.getTablero().notifyObservers();
        curacionEnProgreso = false;
    }

    public Boolean curacionEnProgreso() {
        return curacionEnProgreso;
    }

}
