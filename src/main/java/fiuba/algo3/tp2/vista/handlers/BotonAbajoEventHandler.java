package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.juego.Algochess;
import fiuba.algo3.tp2.movimiento.Direccion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class BotonAbajoEventHandler implements EventHandler<ActionEvent> {

    private final Stage stage;
    private Algochess algochess;
    private Pieza pieza;

    public BotonAbajoEventHandler(Algochess algochess, Stage stage){
        this.algochess = algochess;
        this.pieza = null;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){

        if(algochess.obtenerJugadorConTurno().quedanMovimientos()) {
            final Popup popup = new Popup();
            HBox popupText = new HBox();
            VBox popupVBox = new VBox();
            popup.setAutoFix(true);
            popup.setAnchorX(450);
            popup.setAnchorY(40);
            popup.setAutoHide(true);
            popup.setHideOnEscape(true);
            Label primeraParteDelTexto = new Label("Moviste la pieza ");
            Label segundaParteDelTexto = new Label(pieza.getNombre() + " ");
            segundaParteDelTexto.setId("nombre-pieza");
            Label terceraParteDelTexto = new Label(pieza.getColor().comoString());
            if (pieza.getColor().comoString() == "blanco") {
                terceraParteDelTexto.setId("color-blanco");
            } else {
                terceraParteDelTexto.setId("color-negro");
            }
            Label cuartaParteDelTexto = new Label(" hacia abajo");
            Label dismissMensaje = new Label("clickea para hacer desaparecer este mensaje");
            dismissMensaje.setId("dismiss-mensaje");
            popupText.getChildren().addAll(primeraParteDelTexto, segundaParteDelTexto, terceraParteDelTexto, cuartaParteDelTexto);
            popupVBox.getChildren().addAll(popupText, dismissMensaje);
            popupVBox.setAlignment(Pos.CENTER);
            popupVBox.getStylesheets().add("css/popup.css");
            popup.getContent().add(popupVBox);
            popup.show(stage);
        }
        
        algochess.moverPieza(pieza, Direccion.abajo());
        algochess.getTablero().notifyObservers();
    }
    public void setPieza(Pieza pieza){
        this.pieza = pieza;
    }
}
