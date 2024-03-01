package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Algochess;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class TiendaView extends Group {

    private VBox vistaTienda;
    private HBox tiendaHBox;
    private HBox primeraHBox;
    private HBox segundaHBox;
    private HBox plataJugador;
    private VBox tienda;
    private Algochess algochess;
    ImageView soldado;
    ImageView jinete;
    ImageView curandero;
    ImageView catapulta;
    Image imagenDragSoldado;
    Image imagenDragJinete;
    Image imageDragCurandero;
    Image imagenDragCatapulta;

    public TiendaView(Algochess algochess) {

        vistaTienda = new VBox();
        this.prepararLaTienda(false);
        this.algochess = algochess;
    }
    public TiendaView(Algochess algochess, boolean tiendaDeNegras){
        vistaTienda = new VBox();
        this.prepararLaTienda(tiendaDeNegras);
        this.algochess = algochess;
    }

    private void prepararLaTienda(boolean sonPiezasNegras) {

        tienda = new VBox();
        plataJugador = new HBox();
        tiendaHBox = new HBox();
        primeraHBox = new HBox();
        segundaHBox = new HBox();


        Tooltip tooltipSoldado = new Tooltip("Precio: 1\n" +
                                                "Danio: 10\n" +
                                                "Tip: tiene la mejor relacion en costo-stats");
        Tooltip tooltipJinete = new Tooltip("Precio: 3\n" +
                                               "Danio con espada: 5\n" +
                                               "Danio con arco: 15\n" +
                                               "Tip: Cuando hay enemigos cerca utiliza la espada");
        Tooltip tooltipCurandero = new Tooltip("Precio: 2\n" +
                                                  "Curacion: 15\n" +
                                                  "Tip: No puede atacar, cura piezas aliadas");
        Tooltip tooltipCatapulta = new Tooltip("Precio: 5\n" +
                                                  "Danio: 20\n" +
                                                  "Tip: No puede ser curada pero tiene un gran alcance. No se puede mover");

        vistaTienda.setId("tienda");

        ImageView tiendaIcono = new ImageView(new Image("file:src/main/resources/ic-shop-open.png", 200, 200, false, false));
        if(!sonPiezasNegras) {
            soldado = new ImageView(new Image("file:src/main/resources/ic-soldado-blanco.png", 200, 200, false, false));
            jinete = new ImageView(new Image("file:src/main/resources/ic-jinete-blanco.png", 200, 200, false, false));
            curandero = new ImageView(new Image("file:src/main/resources/ic-curandero-blanco.png"));
            catapulta = new ImageView(new Image("file:src/main/resources/ic-catapulta-blanco.png", 200, 200, false, false));
        }else{
            soldado = new ImageView(new Image("file:src/main/resources/ic-soldado-negro.png", 200, 200, false, false));
            jinete = new ImageView(new Image("file:src/main/resources/ic-jinete-negro.png", 200, 200, false, false));
            curandero = new ImageView(new Image("file:src/main/resources/ic-curandero-negro.png"));
            catapulta = new ImageView(new Image("file:src/main/resources/ic-catapulta-negro.png", 200, 200, false, false));
        }
        curandero.setFitWidth(200);
        curandero.setFitHeight(200);


        tiendaIcono.setFitWidth(100);
        tiendaIcono.setFitHeight(100);

        soldado.setCursor(Cursor.CLOSED_HAND);
        curandero.setCursor(Cursor.CLOSED_HAND);
        jinete.setCursor(Cursor.CLOSED_HAND);
        catapulta.setCursor(Cursor.CLOSED_HAND);


        Tooltip.install(soldado, tooltipSoldado);
        tooltipSoldado.setShowDuration(Duration.INDEFINITE);
        tooltipSoldado.setShowDelay(Duration.seconds(.1));

        Tooltip.install(curandero, tooltipCurandero);
        tooltipCurandero.setShowDuration(Duration.INDEFINITE);
        tooltipCurandero.setShowDelay(Duration.seconds(.1));

        Tooltip.install(jinete, tooltipJinete);
        tooltipJinete.setShowDuration(Duration.INDEFINITE);
        tooltipJinete.setShowDelay(Duration.seconds(.1));

        Tooltip.install(catapulta, tooltipCatapulta);
        tooltipCatapulta.setShowDuration(Duration.INDEFINITE);
        tooltipCatapulta.setShowDelay(Duration.seconds(.1));

        tiendaHBox.getChildren().add(tiendaIcono);
        tiendaHBox.setAlignment(Pos.CENTER);

        primeraHBox.getChildren().addAll(soldado,jinete);
        segundaHBox.getChildren().addAll(curandero,catapulta);

        primeraHBox.setSpacing(30);
        segundaHBox.setSpacing(30);

        vistaTienda.getChildren().addAll(tiendaHBox, primeraHBox, segundaHBox);

        vistaTienda.setSpacing(15);


        vistaTienda.getStylesheets().add("css/tienda.css");

        this.getChildren().add(vistaTienda);

        this.habilitarMoverPiezaAlTablero(sonPiezasNegras);

    }

    private void habilitarMoverPiezaAlTablero(boolean sonPiezasNegras) {

        if(!sonPiezasNegras){
            imagenDragSoldado = new Image("file:src/main/resources/ic-soldado-blanco.png", 40, 40, false, false);
            imagenDragJinete = new Image("file:src/main/resources/ic-jinete-blanco.png", 40, 40, false, false);
            imageDragCurandero = new Image("file:src/main/resources/ic-curandero-blanco.png", 40, 40, false, false);
            imagenDragCatapulta = new Image("file:src/main/resources/ic-catapulta-blanco.png", 40, 40, false, false);
        }else{
            imagenDragSoldado = new Image("file:src/main/resources/ic-soldado-negro.png", 40, 40, false, false);
            imagenDragJinete = new Image("file:src/main/resources/ic-jinete-negro.png", 40, 40, false, false);
            imageDragCurandero = new Image("file:src/main/resources/ic-curandero-negro.png", 40, 40, false, false);
            imagenDragCatapulta = new Image("file:src/main/resources/ic-catapulta-negro.png", 40, 40, false, false);
        }

        primeraHBox.getChildren().get(0).setOnDragDetected(event -> {
            Dragboard db = primeraHBox.getChildren().get(0).startDragAndDrop(TransferMode.COPY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString("soldado");
            cb.putImage(imagenDragSoldado);
            db.setContent(cb);
            event.consume();
        });
        primeraHBox.getChildren().get(1).setOnDragDetected(event -> {
            Dragboard db = primeraHBox.getChildren().get(1).startDragAndDrop(TransferMode.COPY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString("jinete");
            cb.putImage(imagenDragJinete);
            db.setContent(cb);
            event.consume();
        });
        segundaHBox.getChildren().get(0).setOnDragDetected(event -> {
            Dragboard db = segundaHBox.getChildren().get(0).startDragAndDrop(TransferMode.COPY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString("curandero");
            cb.putImage(imageDragCurandero);
            db.setContent(cb);
            event.consume();
        });
        segundaHBox.getChildren().get(1).setOnDragDetected(event -> {
            Dragboard db = segundaHBox.getChildren().get(1).startDragAndDrop(TransferMode.COPY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString("catapulta");
            cb.putImage(imagenDragCatapulta);
            db.setContent(cb);
            event.consume();
        });
    }
}
