package fiuba.algo3.tp2.entidadesPrincipales.piezas;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.atributos.Ataque;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.atributos.PuntosDeVida;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.batallon.TipoDeBatallon;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.NoPuedeCurarPiezaDelOtroEquipo;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public class Curandero extends Saludable {
    private StreamHandler streamHandler = new StreamHandler();
    private static final Logger logger = Logger.getLogger( Curandero.class.getName() );

    private static final int PRECIO = 2;
    private static final int CURACION = 15;

    public Curandero(Color color) {
        logger.addHandler(streamHandler);
        this.curacion = new Ataque();
        this.precio = PRECIO;
        this.color = color;
        this.puntosDeCuracion = CURACION;
        this.puntosDeVida = new PuntosDeVida(this);
        this.nombre = "curandero";
    }

    @Override
    public void curar(Pieza pieza, int distanciaConPieza) {
        try{
            if(!this.esDeMiEquipo(pieza))
                throw new NoPuedeCurarPiezaDelOtroEquipo("Esa pieza es enemiga");
        }catch (NoPuedeCurarPiezaDelOtroEquipo e){
            logger.log(Level.SEVERE, e.getMessage());
        }
        this.setRangoDeAlcance(distanciaConPieza);
        curacion.curar(this, pieza, this.rangoDeAlcance);

    }

    @Override
    public void unirseABatallonHorizontal(TipoDeBatallon batallon, Pieza pieza) {

    }
    @Override
    public void unirseABatallonVertical(TipoDeBatallon batallon, Pieza pieza) {

    }

    public void setRangoJineteCercano(Jinete jinete){
        if(!jinete.esDeMiEquipo(this)){
            jinete.setRangoCercano();
        }
    }

}
