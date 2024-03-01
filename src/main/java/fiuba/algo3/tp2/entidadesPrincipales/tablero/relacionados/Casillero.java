package fiuba.algo3.tp2.entidadesPrincipales.tablero.relacionados;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.PiezasContiguas;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.CasilleroDeLadoEnemigoException;
import fiuba.algo3.tp2.excepciones.CasilleroEstaOcupadoException;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.excepciones.CasilleroEstaVacioException;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public class Casillero {
    private StreamHandler streamHandler = new StreamHandler();
    private static final Logger logger = Logger.getLogger( Casillero.class.getName() );
    private Color color;
    private Pieza pieza;

    public Casillero(Color color) {
        logger.addHandler(streamHandler);
        this.color = color;
        pieza = null;
    }

    public boolean puedoAgregarla(Color unColor) {

        try {
            if(pieza != null)
                throw new CasilleroEstaOcupadoException("No podes colocar una pieza en un casillero ocupado");

            if (!color.esDelMismoColor(unColor))
                throw new CasilleroDeLadoEnemigoException("No podes colocar piezas en el lado enemigo");

        }   catch (CasilleroEstaOcupadoException | CasilleroDeLadoEnemigoException e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw e;
        }


        return true;
    }

    public void agregarPieza(Pieza pieza) {

       if(this.puedoAgregarla(pieza.getColor()))
           this.pieza = pieza;
    }

    public void setPieza(Pieza pieza) {

        this.pieza = pieza;
    }

    public void borrarPieza() {

        pieza = null;
    }

    public Pieza getPieza() {

        if(pieza == null)
            throw  new CasilleroEstaVacioException("La posicion indicada esta vacia");

        return pieza;
    }

    public boolean estaOcupado() {

        return pieza != null;
    }

    public void agregarPiezaAContiguos(PiezasContiguas contiguas) {

        if(pieza != null)
            contiguas.agregar(pieza);
    }

    public Color getColor() {

        return color;
    }
}
