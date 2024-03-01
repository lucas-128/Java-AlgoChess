package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Algochess;
import fiuba.algo3.tp2.vista.handlers.BotonJugarEventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;


public class PresentacionView extends VBox {

    Stage stage;

    public PresentacionView(Algochess algochess,Stage stage){

        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);

        Background fondo = new Background(new BackgroundImage(new Image("bg-presentacion.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT));

        this.setBackground(fondo);

        Text textoPresentacion = new Text("AlgoChess !");
        textoPresentacion.setFill(Color.LAVENDER);
        textoPresentacion.setStroke(Color.BLACK);
        textoPresentacion.setStrokeWidth(2);
        textoPresentacion.setFont(Font.font("Verdana", FontWeight.BOLD,120));

        HBox elementosNegro = new HBox();
        elementosNegro.setAlignment(Pos.CENTER);
        elementosNegro.setSpacing(50);

        Label mensajeNegro = new Label("Jugador negro:");
        TextField entradaNegro = new TextField();
        entradaNegro.setPromptText("escriba un nombre");

        elementosNegro.getChildren().addAll(mensajeNegro, entradaNegro);

        HBox elementosBlanco = new HBox();
        elementosBlanco.setAlignment(Pos.CENTER);
        elementosBlanco.setSpacing(50);

        Label mensaje = new Label("Jugador blanco:");
        TextField entradaBlanco = new TextField();
        entradaBlanco.setPromptText("escriba un nombre");

        elementosBlanco.getChildren().addAll(mensaje, entradaBlanco);


        Button comenzar = new Button("Jugar!");
        comenzar.setMaxWidth(200);

        BotonJugarEventHandler botonJugar = new BotonJugarEventHandler(algochess,entradaBlanco,entradaNegro,stage);
        comenzar.setOnAction(botonJugar);

        this.getChildren().add(textoPresentacion);
        this.getChildren().add(elementosBlanco);
        this.getChildren().add(elementosNegro);
        this.getChildren().add(comenzar);
    }
}