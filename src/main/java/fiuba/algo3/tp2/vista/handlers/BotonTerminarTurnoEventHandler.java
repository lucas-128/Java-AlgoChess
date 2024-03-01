package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.juego.Algochess;
import fiuba.algo3.tp2.vista.JuegoView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonTerminarTurnoEventHandler implements EventHandler<ActionEvent> {
    private Algochess algochess;
    private JuegoView vistaDelJuego;

    public BotonTerminarTurnoEventHandler(Algochess algochess, JuegoView vistaDelJuego){

        this.vistaDelJuego = vistaDelJuego;
        this.algochess = algochess;
    }

    @Override
    public void handle(ActionEvent actionEvent){

        this.algochess.terminarTurno();
        this.vistaDelJuego.actualizar(algochess.obtenerJugadorConTurno());


    }
}
