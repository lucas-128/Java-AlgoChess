package fiuba.algo3.tp2.entidadesPrincipales.piezas;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.atributos.Ataque;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.atributos.PuntosDeVida;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.batallon.TipoDeBatallon;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.movimiento.Posicion;

import java.util.ArrayList;

public class Catapulta extends Danina {

    private static final int PRECIO = 5;
    private static final int DANIO_CATAPULTA = 20;

    public Catapulta(Color color) {

        precio = PRECIO;
        this.color = color;
        this.puntosDeDanio = DANIO_CATAPULTA;
        puntosDeVida = new PuntosDeVida(this);
        ataque = new Ataque();
        nombre = "catapulta";
    }

    @Override
    public void atacar(Pieza pieza, int distanciaConPieza, ArrayList<Pieza> contiguas) {

        this.setRangoDeAlcance(distanciaConPieza);
        ataque.atacar(this, pieza,contiguas, this.rangoDeAlcance);
    }

    @Override
    public void recibirVida(int vidaRecibida) {

    }

    @Override
    public void unirseABatallonHorizontal(TipoDeBatallon batallon, Pieza pieza) {

    }
    @Override
    public void unirseABatallonVertical(TipoDeBatallon batallon, Pieza pieza) {

    }

    @Override
    public void moverA(Posicion posicionNueva) {

    }

    @Override

    public void setRangoJineteCercano(Jinete jinete){
        if(!jinete.esDeMiEquipo(this)){
            jinete.setRangoCercano();
        }
    }
}
