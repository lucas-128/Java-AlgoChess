package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.juego.Algochess;
import fiuba.algo3.tp2.vista.handlers.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class ControlesView extends VBox {

    private Jugador jugador;
    private VBox controles;
    private Label nombre;
    private BotonArribaEventHandler botonArribaEventHandler;
    private BotonAbajoEventHandler botonAbajoEventHandler;
    private BotonDerechaEventHandler botonDerechaEventHandler;
    private BotonIzquierdaEventHandler botonIzquierdaEventHandler;
    private BotonAtacarEventHandler botonAtacarEventHandler;
    private JuegoView vistaDelJuego;
    private BotonCurarEventHandler botonCurarEventHandler;
    private Label nombreJugadorConTurno;

    public ControlesView(Algochess algochess, Stage stage){

        jugador = algochess.obtenerJugadorConTurno();

        this.controles = new VBox();
        controles.setId("controles");
        VBox boxJugador = new VBox();
        nombre = new Label("Turno de: ");

        nombreJugadorConTurno = new Label(jugador.getNombre());
        nombreJugadorConTurno.setId("jugador-label");

        Button botonArriba = new Button();
        Button botonAbajo = new Button();
        Button botonDerecha = new Button() ;
        Button botonIzquierda = new Button();
        Button botonAtacar = new Button();
        Button botonCurar = new Button();

        controles.getStylesheets().add("css/controles.css");

        Image flechaIzquierda = new Image("file:src/main/resources/ic-arrow-left.png", 80, 80, false, false);
        Image flechaDerecha = new Image("file:src/main/resources/ic-arrow-right.png", 80,80,false,false);
        Image flechaArriba = new Image("file:src/main/resources/ic-arrow-up.png", 80,80,false,false);
        Image flechaAbajo = new Image("file:src/main/resources/ic-arrow-down.png", 80,80,false,false);
        Image espadasCruzadas = new Image("file:src/main/resources/ic-swords.png", 80,80,false,false);
        Image cruzVerde = new Image("file:src/main/resources/ic-green-cross.png", 80,80,false,false);

        botonIzquierda.setGraphic(new ImageView(flechaIzquierda));
        botonDerecha.setGraphic(new ImageView(flechaDerecha));
        botonArriba.setGraphic(new ImageView(flechaArriba));
        botonAbajo.setGraphic(new ImageView(flechaAbajo));
        botonAtacar.setGraphic(new ImageView(espadasCruzadas));
        botonCurar.setGraphic(new ImageView(cruzVerde));

        botonArribaEventHandler = new BotonArribaEventHandler(algochess, stage);
        botonAbajoEventHandler = new BotonAbajoEventHandler(algochess, stage);
        botonDerechaEventHandler = new BotonDerechaEventHandler(algochess, stage);
        botonIzquierdaEventHandler = new BotonIzquierdaEventHandler(algochess, stage);
        botonAtacarEventHandler = new BotonAtacarEventHandler(algochess, stage);
        botonCurarEventHandler = new BotonCurarEventHandler(algochess, stage);

        botonArriba.setOnAction(botonArribaEventHandler);
        botonAbajo.setOnAction(botonAbajoEventHandler);
        botonDerecha.setOnAction(botonDerechaEventHandler);
        botonIzquierda.setOnAction(botonIzquierdaEventHandler);
        botonAtacar.setOnAction(botonAtacarEventHandler);
        botonCurar.setOnAction(botonCurarEventHandler);

        StackPane mando = new StackPane();

        mando.setAlignment(botonArriba,Pos.TOP_CENTER);
        mando.setAlignment(botonAbajo,Pos.BOTTOM_CENTER);
        mando.setAlignment(botonDerecha,Pos.CENTER_RIGHT);
        mando.setAlignment(botonIzquierda,Pos.CENTER_LEFT);
        mando.setAlignment(botonAtacar,Pos.CENTER);
        mando.setAlignment(botonCurar, Pos.TOP_RIGHT);
        mando.setPrefWidth(250);
        mando.setPrefHeight(350);
        mando.getChildren().addAll(botonAbajo,botonArriba,botonAtacar,botonDerecha,botonIzquierda, botonCurar);

        controles.setSpacing(50);
        boxJugador.getChildren().addAll(nombre, nombreJugadorConTurno);
        controles.getChildren().add(boxJugador);
        controles.getChildren().add(mando);

        this.setPrefWidth(363);
        this.getChildren().add(controles);
    }

    public void setPiezaAMover(Pieza pieza){

        if(pieza != null){
            botonAbajoEventHandler.setPieza(pieza);
            botonArribaEventHandler.setPieza(pieza);
            botonDerechaEventHandler.setPieza(pieza);
            botonIzquierdaEventHandler.setPieza(pieza);
        }
    }

    public void setAtaque(Pieza pieza){
        if(botonAtacarEventHandler.ataqueEnProgreso()){
            botonAtacarEventHandler.setVictima(pieza);
        }
        else {
            botonAtacarEventHandler.setAtacante(pieza);
        }
    }

    public void setCuracion(Pieza pieza){
        if(botonCurarEventHandler.curacionEnProgreso()){
            botonCurarEventHandler.setPaciente(pieza);
        }
        else{
            botonCurarEventHandler.setCurandero(pieza);
        }
    }

    public void setNombreJugadorConTurno(Jugador jugador) {

        String nombre = jugador.getNombre();
        nombreJugadorConTurno.setText(nombre);


    }
}
