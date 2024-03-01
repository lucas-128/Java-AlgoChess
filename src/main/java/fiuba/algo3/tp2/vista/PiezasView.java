package fiuba.algo3.tp2.vista;
import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.*;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import java.util.HashMap;

public class PiezasView  {

    private HashMap<String,Image> mapDeImagenes;
    private HashMap<String,Tooltip> mapTooltipPiezas;
    private HashMap<String,Pieza> mapDePiezas;
    private HashMap<String,Image> mapDePiezasSeleccionadas;
    private HashMap<String,Tooltip> mapPiezaYSuTooltip;


    public PiezasView() {
        mapPiezaYSuTooltip = new HashMap();
        mapTooltipPiezas = this.iniciarMapDeTooltips();
        iniciarMapDePiezasSeleccionadas();
    }

    private void iniciarMapDePiezasSeleccionadas() {
        mapDePiezasSeleccionadas = new HashMap();
        Color blanco = new Blanco();
        Color negro = new Negro();

        String urlSoldadoNegro = "file:src/main/resources/ic-soldado-" + negro.comoString() + "-seleccionado" + ".png";
        String urlJineteNegro = "file:src/main/resources/ic-jinete-" + negro.comoString() + "-seleccionado" + ".png";
        String urlCuranderoNegro = "file:src/main/resources/ic-curandero-" + negro.comoString() + "-seleccionado" + ".png";
        String urlCatapultaNegro = "file:src/main/resources/ic-catapulta-" + negro.comoString() + "-seleccionado" + ".png";
        String urlSoldadoBlanco = "file:src/main/resources/ic-soldado-" + blanco.comoString() + "-seleccionado" + ".png";
        String urlJineteBlanco = "file:src/main/resources/ic-jinete-" + blanco.comoString() + "-seleccionado" + ".png";
        String urlCuranderoBlanco = "file:src/main/resources/ic-curandero-" + blanco.comoString() + "-seleccionado" + ".png";
        String urlCatapultaBlanco = "file:src/main/resources/ic-catapulta-" + blanco.comoString() + "-seleccionado" + ".png";

        mapDePiezasSeleccionadas.put("soldado"+blanco.comoString(), new Image(urlSoldadoBlanco, 40,40,false,false));
        mapDePiezasSeleccionadas.put("soldado"+negro.comoString(), new Image(urlSoldadoNegro, 40,40,false,false));
        mapDePiezasSeleccionadas.put("jinete"+blanco.comoString(), new Image(urlJineteBlanco, 40,40,false,false));
        mapDePiezasSeleccionadas.put("jinete"+negro.comoString(), new Image(urlJineteNegro, 40,40,false,false));
        mapDePiezasSeleccionadas.put("curandero"+blanco.comoString(), new Image(urlCuranderoBlanco, 40,40,false,false));
        mapDePiezasSeleccionadas.put("curandero"+negro.comoString(), new Image(urlCuranderoNegro, 40,40,false,false));
        mapDePiezasSeleccionadas.put("catapulta"+blanco.comoString(), new Image(urlCatapultaBlanco, 40,40,false,false));
        mapDePiezasSeleccionadas.put("catapulta"+negro.comoString(), new Image(urlCatapultaNegro, 40,40,false,false));
    }

    private HashMap<String, Tooltip> iniciarMapDeTooltips() {

        HashMap mapDeTooltips = new HashMap();
        mapDeTooltips.put("soldado", new Tooltip("Danio: 10\n" +
                                                    "Vida maxima: 100"));

        mapDeTooltips.put("jinete", new Tooltip("Danio con espada: 5\n" +
                                                    "Danio con arco: 15\n" +
                                                    "Vida maxima: 100"));

        mapDeTooltips.put("curandero", new Tooltip("Curacion: 15\n" +
                                                        "Vida maxima: 75"));

        mapDeTooltips.put("catapulta", new Tooltip("Danio: 20\n" +
                                                        "Vida maxima: 50"));

        return mapDeTooltips;
    }

    private void actualizarMapDeTooltips(Pieza pieza) {

        mapTooltipPiezas.put(pieza.getNombre()+System.identityHashCode(pieza), new Tooltip("Vida actual: " + pieza.getPuntosDeVida()));
    }


    private HashMap iniciarMapDePiezas(Color color){

        HashMap mapDePiezas = new HashMap();
        mapDePiezas.put("soldado",new SoldadoDeInfanteria(color));
        mapDePiezas.put("jinete",new Jinete(color));
        mapDePiezas.put("curandero",new Curandero(color));
        mapDePiezas.put("catapulta",new Catapulta(color));
        return mapDePiezas;
    }

    private HashMap iniciarMapDeImagenes(Color color){

        HashMap mapDeImagenes = new HashMap();

        String urlSoldado = "file:src/main/resources/ic-soldado-" + color.comoString() + ".png";
        String urlJinete = "file:src/main/resources/ic-jinete-" + color.comoString() + ".png";
        String urlCurandero = "file:src/main/resources/ic-curandero-" + color.comoString() + ".png";
        String urlCatapulta = "file:src/main/resources/ic-catapulta-" + color.comoString() + ".png";

        System.out.println(color.comoString());


        mapDeImagenes.put("soldado", new Image(urlSoldado, 40, 40, false, false));
        mapDeImagenes.put("jinete", new Image(urlJinete, 40, 40, false, false));
        mapDeImagenes.put("curandero", new Image(urlCurandero, 40, 40, false, false));
        mapDeImagenes.put("catapulta", new Image(urlCatapulta, 40, 40, false, false));

        return mapDeImagenes;


    }

    public Pieza colocar(String pieza, Color color) {


        mapDePiezas = this.iniciarMapDePiezas(color);
        return mapDePiezas.get(pieza);
    }

    public Image dibujar(String pieza, Color color){

        mapDeImagenes = this.iniciarMapDeImagenes(color);
        return mapDeImagenes.get(pieza);
    }

    public Tooltip getTooltip(String pieza) {

        return mapTooltipPiezas.get(pieza);
    }

    public Tooltip getTooltip(String nombrePieza, Pieza pieza) {

        actualizarMapDeTooltips(pieza);
        return mapTooltipPiezas.get(nombrePieza+System.identityHashCode(pieza));
    }

    public Image seleccionarPieza(Pieza pieza) {
        return mapDePiezasSeleccionadas.get(pieza.getNombre()+pieza.getColor().comoString());
    }

    public void setTooltip(Pieza pieza, Tooltip tooltip) {
        this.mapPiezaYSuTooltip.put(pieza.getNombre()+System.identityHashCode(pieza), tooltip);
    }
    public Tooltip getTooltip(Pieza pieza) {
        return this.mapPiezaYSuTooltip.get(pieza.getNombre()+System.identityHashCode(pieza));
    }
}
