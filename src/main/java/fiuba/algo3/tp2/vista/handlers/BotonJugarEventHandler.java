package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.juego.Algochess;
import fiuba.algo3.tp2.vista.FaseDeCompraView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class BotonJugarEventHandler implements EventHandler<ActionEvent> {


    private Algochess algochess;
    private TextField entradaBlanco;
    private TextField entradaNegro;
    private Stage stage;
    private Scene escenaJuego;

    public BotonJugarEventHandler(Algochess algochess, TextField entradaBlanco, TextField entradaNegro, Stage stage) {

        this.algochess = algochess;
        this.entradaBlanco = entradaBlanco;
        this.entradaNegro = entradaNegro;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        String nombreNegro = entradaNegro.getText();
        String nombreBlanco = entradaBlanco.getText();


        if(nombreBlanco.equals("") || nombreNegro.equals("")) {

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setContentText("INGRESAR AMBOS NOMBRES");

            entradaBlanco.clear(); entradaNegro.clear();
            alerta.show();

        } else if(nombreBlanco.equals(nombreNegro)) {

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setContentText("NO PUEDEN LLEVAR EL MISMO NOMBRE");

            entradaBlanco.clear(); entradaNegro.clear();
            alerta.show();

        } else {

            algochess.cargarNombreBlanco(nombreBlanco);
            algochess.cargarNombreNegro(nombreNegro);

            FaseDeCompraView faseCompras = new FaseDeCompraView(stage,algochess);
            Scene escenaJuego = new Scene(faseCompras);

            stage.setScene(escenaJuego);
            stage.setFullScreenExitHint("");
            stage.setFullScreen(true);
        }

        Label comoJugar = new Label("¿CÓMO JUGAR?\n\n" +
                "IMPORTANTE: EL JUEGO ESTA IMPLEMENTADO PARA SER JUGADO SOLAMENTE EN RESOLUCIÓN 1920x1080.\n\n" +
                "Mover: Hacer click sobre la pieza que se desee mover y tocar el boton en la direccion correspondiente\n" +
                "Atacar: Hacer click sobre la pieza que va a atacar, clickear el boton de ataque (espadas cruzadas) y clickear el objetivo\n" +
                "Curar: Hacer click sobre el curandero + clickear el boton de curar (cruz verde) y clickear el objetivo\n"+
                "Al posicionar el cursor sobre las piezas se pueden conocer sus atributos\n" +
                "Clickear para sacar los Pop-Ups\n\n\n" +
                "SUPUESTOS\n\n" +
                "- La curacion del curandero puede exceder la vida maxima inicial de la pieza\n" +
                "- No se pueden colocar piezas en el campo rival\n"+
                "- No se puede atacar con el curandero\n" +
                "- No se puede curar con otra pieza que no sea el curandero\n"+
                "- No se pueden usar piezas del adversario\n");
        comoJugar.setTextAlignment(TextAlignment.LEFT);
        comoJugar.getStylesheets().add("css/instrucciones.css");
        StackPane texto = new StackPane();
        texto.getChildren().add(comoJugar);
        Stage manual = new Stage();
        Scene textoManual = new Scene(texto,1280,720);

        manual.initModality(Modality.APPLICATION_MODAL);
        manual.initOwner(stage);
        manual.setTitle("Manual de juego");
        manual.setScene(textoManual);

        manual.showAndWait();
    }
}
