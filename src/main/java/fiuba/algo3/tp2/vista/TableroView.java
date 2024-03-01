package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.Observer;
import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.excepciones.CasilleroEstaVacioException;
import fiuba.algo3.tp2.excepciones.JugadorQuiereUtilizarMasDineroDelDisponibleException;
import fiuba.algo3.tp2.flujoDelJuego.fasesDeJuego.FaseDeCompra;
import fiuba.algo3.tp2.juego.Algochess;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.logging.Level;


public class TableroView extends Group implements Observer {

    public double ancho;
    public double largo;
    private final static double ANCHO_CASILLERO = 40;
    private final static double LARGO_CASILLERO = 40;

    private Algochess algochess;
    private Tablero tablero;
    private GridPane tableroView;
    private Pane[][] casilleros;
    private PiezasView piezasView;
    private ControlesView control;
    private FaseDeCompraView faseDeCompra;
    private Stage stage;


    public TableroView(Algochess algochess, FaseDeCompraView faseDeCompra, Stage stage,ControlesView controles) {
        this.control = controles;
        this.stage = stage;
        this.faseDeCompra = faseDeCompra;
        this.algochess = algochess;
        this.tablero = algochess.getTablero();
        this.tablero.addObserver(this);
        tableroView = new GridPane();
        ancho = ANCHO_CASILLERO * tablero.obtenerTamanioTablero();
        largo = LARGO_CASILLERO * tablero.obtenerTamanioTablero();
        casilleros = new Pane[(int)ancho][(int)largo];
        piezasView = new PiezasView();

        for(int i = 0; i < tablero.obtenerTamanioTablero(); i++){
            for(int j = 0; j < tablero.obtenerTamanioTablero()/2; j++){
                Pane v = new Pane();
                v.setMinHeight(LARGO_CASILLERO);
                v.setMinWidth(ANCHO_CASILLERO);
                v.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                this.setearRecibirPieza(v,this);
                casilleros[i][j] = v;
                tableroView.add(v,i,j);
            }
        }

        for(int i = 0; i < tablero.obtenerTamanioTablero(); i++){
            for(int j = tablero.obtenerTamanioTablero()/2; j < tablero.obtenerTamanioTablero(); j++){
                Pane v = new Pane();
                v.setMinHeight(LARGO_CASILLERO);
                v.setMinWidth(ANCHO_CASILLERO);
                v.setBackground(new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY)));
                this.setearRecibirPieza(v,this);
                casilleros[i][j] = v;
                tableroView.add(v,i,j);
            }
        }

        tableroView.setGridLinesVisible(true);
        tableroView.setPadding(new Insets(10));
        this.getChildren().add(tableroView);
    }

    private void addView(ImageView imagen,int fila,int columna) {

        this.tableroView.add(imagen,fila,columna);
    }

    private void setearRecibirPieza(Pane casillero, TableroView vista){

        casillero.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.ANY);
            }
        });
        casillero.setOnDragDropped(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {

                String piezaNuevaString = event.getDragboard().getString();
                Image piezaNuevaImg = event.getDragboard().getImage();
                ImageView piezaNueva = new ImageView(piezaNuevaImg);
                Tooltip tooltip = piezasView.getTooltip(piezaNuevaString);
                tooltip.setShowDuration(Duration.INDEFINITE);
                tooltip.setShowDelay(Duration.seconds(.1));
                Tooltip.install(piezaNueva, tooltip);

                Jugador actual = algochess.obtenerJugadorConTurno();
                fiuba.algo3.tp2.colores.Color colorJugador = actual.getColor();

                algochess.jugadorComprarPieza(piezasView.colocar(piezaNuevaString,colorJugador), tableroView.getRowIndex(casillero), tableroView.getColumnIndex(casillero));

                casillero.getChildren().clear();
                casillero.getChildren().add(piezaNueva);

                piezasView.setTooltip(obtenerPiezaDeInterfaz(casillero), tooltip);

                final Popup popup = new Popup();
                VBox popupVBox = new VBox();
                popup.setAutoFix(true);
                popup.setAnchorX(1440);
                popup.setAnchorY(180);
                popup.setAutoHide(true);
                popup.setHideOnEscape(true);
                Label popupText = new Label(obtenerPiezaDeInterfaz(casillero).getNombre() + " comprado.");
                Label dismissMensaje = new Label("clickea para hacer desaparecer este mensaje");
                dismissMensaje.setId("dismiss-mensaje");
                popupVBox.getChildren().addAll(popupText, dismissMensaje);
                popupVBox.setAlignment(Pos.CENTER);
                popupVBox.getStylesheets().add("css/popup.css");
                popup.getContent().add(popupVBox);
                popup.show(stage);

                faseDeCompra.actualizarInformacionJugador(actual);

            }
        });
        casillero.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actualizarVistaTablero();
                control.setPiezaAMover(obtenerPiezaDeInterfaz(casillero));
                control.setAtaque(obtenerPiezaDeInterfaz(casillero));
                control.setCuracion(obtenerPiezaDeInterfaz(casillero));
                seleccionarPieza(casillero);
                actualizarTooltipPiezaDaniada(casillero);
            }
        });
    }

    private void seleccionarPieza(Pane casillero) {

        Image imagenPieza;
        imagenPieza = piezasView.seleccionarPieza(obtenerPiezaDeInterfaz(casillero));
        ImageView piezaNueva = new ImageView(imagenPieza);
        casillero.getChildren().clear();
        casillero.getChildren().add(piezaNueva);
    }

    private void actualizarTooltipPiezaDaniada(Pane casillero) {

        Tooltip tooltip = piezasView.getTooltip(obtenerPiezaDeInterfaz(casillero).getNombre(), obtenerPiezaDeInterfaz(casillero));
        Node piezaImageView = casillero.getChildren().get(0);
        Tooltip.install(piezaImageView, tooltip);
        tooltip.setShowDuration(Duration.INDEFINITE);
        tooltip.setShowDelay(Duration.seconds(.1));
        casillero.getChildren().clear();
        casillero.getChildren().add(piezaImageView);
        piezasView.setTooltip(obtenerPiezaDeInterfaz(casillero), tooltip);
    }

    public Pieza obtenerPiezaDeInterfaz(Pane casillero){

        return this.tablero.obtenerPieza(tableroView.getRowIndex(casillero),tableroView.getColumnIndex(casillero));
    }

    private void actualizarVistaTablero(){

        for(int i = 0;i < tablero.obtenerTamanioTablero();i++){
            for(int j = 0;j < tablero.obtenerTamanioTablero();j++){

                try {
                    casilleros[j][i].getChildren().clear();
                    Tooltip tooltipPieza = piezasView.getTooltip(obtenerPiezaDeInterfaz(casilleros[j][i]));
                    ImageView imagenPieza = new ImageView(piezasView.dibujar(tablero.obtenerPieza(i,j).getNombre(),tablero.obtenerPieza(i,j).getColor()));
                    Tooltip.install(imagenPieza, tooltipPieza);
                    casilleros[j][i].getChildren().add(imagenPieza);

                } catch (CasilleroEstaVacioException e){

                }
            }
        }
    }

    public void change(){
        actualizarVistaTablero();
    }



}
