package fiuba.algo3.tp2.entidadesPrincipales.piezas.administrador;


import fiuba.algo3.tp2.entidadesPrincipales.piezas.PiezasContiguas;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.entidadesPrincipales.tienda.Tienda;
import fiuba.algo3.tp2.entidadesPrincipales.tienda.relacionados.Billetera;
import fiuba.algo3.tp2.excepciones.CasilleroDeLadoEnemigoException;
import fiuba.algo3.tp2.excepciones.CasilleroEstaOcupadoException;
import fiuba.algo3.tp2.excepciones.JugadorQuiereUtilizarMasDineroDelDisponibleException;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.batallon.Batallon;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;


public class AdministradorDePiezas {

    private StreamHandler streamHandler = new StreamHandler();
    private static final Logger logger = Logger.getLogger( AdministradorDePiezas.class.getName() );

    private final int CANTIDAD_DINERO_INICIAL = 20;

    private ArrayList<Pieza> piezas;
    private PiezasContiguas piezasContiguas;
    private Billetera billetera;
    private Tienda tienda;
    private Batallon batallon;


    public AdministradorDePiezas() {
        logger.addHandler(streamHandler);
        piezas = new ArrayList();
        piezasContiguas = new PiezasContiguas();
        batallon = new Batallon();
        billetera = new Billetera(CANTIDAD_DINERO_INICIAL);
        tienda = new Tienda();
    }

    public boolean sigueEnJuego() {

        return !(piezas.isEmpty()); /* Jugador se queda sin piezas, pierde. */
    }

    public void borrarPieza(Pieza pieza) {

        piezas.remove(pieza);
    }

    public void agregarPieza(Pieza pieza, int posicionFila, int posicionColumna, Tablero tablero) {

        Posicion posicion = new Posicion(posicionFila,posicionColumna);
        pieza.setPosicion(posicion);

        Pieza piezaComprada;
        piezaComprada = tienda.comprarPieza(pieza, billetera);

        try{

            tablero.agregarPieza(piezaComprada, posicionFila, posicionColumna);
            piezas.add(pieza);

        } catch (JugadorQuiereUtilizarMasDineroDelDisponibleException | CasilleroEstaOcupadoException | CasilleroDeLadoEnemigoException e){

            logger.log(Level.SEVERE, e.getMessage());
            billetera.reembolsar(piezaComprada.getCosto());
            throw e;
        }

    }

    public ArrayList<Pieza> obtenerPiezasContiguas(Posicion posicion, Tablero tablero) {

        return piezasContiguas.obtenerPiezasContiguas(posicion,tablero);
    }

    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero) {

        batallon.armadoBatallon(pieza,piezas);
        batallon.moverBatallon(pieza,direccion,tablero);
    }

    public void actualizarPiezas(Tablero tablero) {
        for(int i = 0; i<piezas.size(); i++) {
            Pieza pieza = piezas.get(i);
            if(pieza.estaMuerta()) {
                this.borrarPieza(pieza);
                tablero.borrarPieza(pieza.getPosicion());
            }
        }
    }


    public int getPuntosDeCompraDisponibles() {

        return billetera.dineroRestante();
    }

    public int getCantidadDePiezas() {

        return piezas.size();
    }
}
