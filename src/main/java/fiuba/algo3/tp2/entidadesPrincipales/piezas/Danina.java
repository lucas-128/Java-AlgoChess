package fiuba.algo3.tp2.entidadesPrincipales.piezas;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.atributos.Ataque;

import java.util.ArrayList;

public abstract class Danina extends Pieza {

    protected Ataque ataque;
    protected int puntosDeDanio;

    public abstract void atacar(Pieza pieza, int distanciaConPieza, ArrayList<Pieza> contiguas);

    public void atacar(Pieza pieza){
        pieza.perderVida(this.puntosDeDanio);
    }

    public int getPuntosDePoder(){
        return puntosDeDanio;
    }
}
