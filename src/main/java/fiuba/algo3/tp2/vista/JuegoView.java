package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.juego.Algochess;
import fiuba.algo3.tp2.vista.handlers.BotonTerminarTurnoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class JuegoView extends VBox {

    private BorderPane interfaz;
    private Algochess algochess;
    private TableroView vistaTablero;
    private ControlesView controles;
    private MenuBar menuBar;
    private Stage stage;
    private BotonTerminarTurnoEventHandler botonTerminarTurnoEventHandler;

    public JuegoView(Algochess algochess, TableroView vistaTablero, Stage stage, ControlesView controles){
        this.stage = stage;
        this.algochess = algochess;
        this.interfaz = new BorderPane();
        this.vistaTablero = vistaTablero;
        this.controles = controles;

        this.setAlignment(Pos.CENTER);

        menuBar = new MenuBar();
        BackgroundImage imagenDeFondo = new BackgroundImage(new Image("file:src/main/resources/bg-madera.jpg"), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        interfaz.setCenter(vistaTablero);
        interfaz.setLeft(controles);

        Button botonTerminarTurno = setBotonTerminarTurno();
        interfaz.setRight(botonTerminarTurno);
        interfaz.setAlignment(botonTerminarTurno, Pos.CENTER_LEFT);

        BorderPane.setAlignment(vistaTablero, Pos.CENTER);
        BorderPane.setAlignment(controles, Pos.CENTER_RIGHT);

        this.getChildren().add(interfaz);
    }

    private Button setBotonTerminarTurno() {
        botonTerminarTurnoEventHandler = new BotonTerminarTurnoEventHandler(algochess, this);
        Button botonTerminarTurno = new Button("Terminar Turno");
        botonTerminarTurno.getStylesheets().add("css/terminar-turno.css");
        BorderPane.setMargin(botonTerminarTurno, new Insets(0, 100, 0, 0));
        botonTerminarTurno.setOnAction(botonTerminarTurnoEventHandler);
        return botonTerminarTurno;
    }

    public void actualizar(Jugador jugador) {

        controles.setNombreJugadorConTurno(jugador);
    }
}
