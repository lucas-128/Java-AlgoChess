package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class InformacionJugadorView extends VBox {

    Label nombre;
    Label color;
    Label puntosRestantes;
    Label cantidadDePiezas;
    Label tip;

    public InformacionJugadorView(Jugador jugadorConTurno) {
        this.setPadding(new Insets(20,20,20,20));
        this.setSpacing(20);

        this.actualizarInformacion(jugadorConTurno);

        this.getStylesheets().add("css/informacion-jugador.css");
    }

    private void actualizarInformacion(Jugador jugadorConTurno) {
        Label nombre = new Label(jugadorConTurno.getNombre());
        nombre.setId("jugador-label");
        Label color = new Label("Color: "  + jugadorConTurno.colorComoString());
        Label puntosRestantes = new Label(Integer.toString(jugadorConTurno.getPuntosDeCompraDisponibles()));
        Label cantidadDePiezas = new Label(Integer.toString(jugadorConTurno.getCantidadPiezasDeJugador()));


        ImageView monedaIcono = new ImageView(new Image("file:src/main/resources/ic-coin.png", 100, 100, false, false));
        ImageView piezaIcono = new ImageView(new Image("file:src/main/resources/ic-pieza.png", 100, 72, false, false));
        puntosRestantes.setGraphic(monedaIcono);
        cantidadDePiezas.setGraphic(piezaIcono);

        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);

        this.getChildren().addAll(nombre, color, puntosRestantes,cantidadDePiezas);
    }
    public void actualizarInformacionJugador(Jugador jugadorConTurno){
        this.getChildren().clear();
        this.actualizarInformacionJugador(jugadorConTurno);
    }

}
