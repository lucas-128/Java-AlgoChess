package fiuba.algo3.tp2.entidadesPrincipales.piezas;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.atributos.Ataque;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.atributos.PuntosDeVida;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.batallon.TipoDeBatallon;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.NoPuedeAtacarPiezaDelMismoEquipo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public class SoldadoDeInfanteria extends Danina {
    private StreamHandler streamHandler = new StreamHandler();
    private static final Logger logger = Logger.getLogger( SoldadoDeInfanteria.class.getName() );

    private static final int PRECIO = 1;
    private static final int DANIO_SOLDADO = 10;

    public SoldadoDeInfanteria(Color color) {
        logger.addHandler(streamHandler);
        this.precio = PRECIO;
        this.color = color;
        this.puntosDeDanio = DANIO_SOLDADO;
        puntosDeVida = new PuntosDeVida(this);
        ataque = new Ataque();
        nombre = "soldado";
    }

    public void atacar(Pieza pieza, int distanciaConPieza, ArrayList<Pieza> contiguas) {

        this.setRangoDeAlcance(distanciaConPieza);
        try{
            if (this.esDeMiEquipo(pieza))
                throw new NoPuedeAtacarPiezaDelMismoEquipo("Esa pieza es de tu equipo");
        }catch (NoPuedeAtacarPiezaDelMismoEquipo e){
            logger.log(Level.SEVERE, e.getMessage());
            return;
        }

        ataque.atacar(this, pieza, this.rangoDeAlcance);

    }

    @Override
    public void unirseABatallonHorizontal(TipoDeBatallon batallon, Pieza pieza) {

        if(this.esContiguoHorizontalmente(pieza))
            batallon.agregar(this);
    }

    @Override
    public void unirseABatallonVertical(TipoDeBatallon batallon, Pieza pieza) {

        if(this.esContiguoVerticalmente(pieza))
            batallon.agregar(this);
    }

    public void setRangoJineteCercano(Jinete jinete){

        if(jinete.esDeMiEquipo(this)){
            jinete.setRangoMediaDistancia();
        }
        if(!jinete.esDeMiEquipo(this)){
            jinete.setRangoCercano();
        }
    }
}
