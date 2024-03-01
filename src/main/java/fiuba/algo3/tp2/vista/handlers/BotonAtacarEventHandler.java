package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.juego.Algochess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class BotonAtacarEventHandler implements EventHandler<ActionEvent> {

    private Algochess algochess;
    private Pieza atacante;
    private Pieza victima;
    protected Boolean ataqueEnProgreso;
    private Stage stage;

    public BotonAtacarEventHandler(Algochess algochess, Stage stage){
        this.algochess = algochess;
        atacante = null;
        victima = null;
        ataqueEnProgreso = false;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        ataqueEnProgreso = true;
    }
    public void setAtacante(Pieza pieza){
        this.atacante = pieza;
    }

    public void setVictima(Pieza victima) {

        if(algochess.obtenerJugadorConTurno().quedanAtaques()) {
            final Popup popup = new Popup();
            VBox popupVBox = new VBox();
            popup.setAutoFix(true);
            popup.setAnchorX(1440);
            popup.setAnchorY(180);
            popup.setAutoHide(true);
            popup.setHideOnEscape(true);
            Label popupText = new Label("Ataque realizado.");
            Label dismissMensaje = new Label("clickea para hacer desaparecer este mensaje");
            dismissMensaje.setId("dismiss-mensaje");
            popupVBox.getChildren().addAll(popupText, dismissMensaje);
            popupVBox.setAlignment(Pos.CENTER);
            popupVBox.getStylesheets().add("css/popup.css");
            popup.getContent().add(popupVBox);
            popup.show(stage);
        }

        this.victima = victima;
        algochess.atacarCon((Danina) atacante,victima.getPosicion().getPosicionFila(),victima.getPosicion().getPosicionColumna());
        algochess.obtenerJugadorDelTurnoSiguiente().actualizarPiezas(algochess.getTablero());
        if(algochess.juegoTerminado()){
            final Stage finDelJuego = new Stage();
            finDelJuego.setTitle("Game Over");
            finDelJuego.initModality(Modality.APPLICATION_MODAL);
            finDelJuego.initOwner(stage);

            VBox finDelJuegoVBox = new VBox(20);
            Button botonSalirDelJuego = new Button("salir");
            botonSalirDelJuego.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    stage.close();
                }
            });
            HBox lineaJugadorGanador = new HBox();
            Label ganador = new Label(algochess.obtenerJugadorConTurno().getNombre());

            ganador.setId("ganador");
            lineaJugadorGanador.getChildren().addAll(new Label("El ganador es: "), ganador);
            lineaJugadorGanador.setAlignment(Pos.CENTER);
            finDelJuegoVBox.getChildren().addAll(new Label("Juego terminado"), lineaJugadorGanador, botonSalirDelJuego);
            VBox.setMargin(botonSalirDelJuego, new Insets(60,0,0,0));
            finDelJuegoVBox.setAlignment(Pos.CENTER);
            finDelJuegoVBox.getStylesheets().add("css/game-over.css");
            Scene dialogScene = new Scene(finDelJuegoVBox, 600, 600);
            finDelJuego.setScene(dialogScene);
            finDelJuego.show();
        }

        algochess.getTablero().notifyObservers();
        ataqueEnProgreso = false;
    }

    public Boolean ataqueEnProgreso(){
        return ataqueEnProgreso;
    }
}
