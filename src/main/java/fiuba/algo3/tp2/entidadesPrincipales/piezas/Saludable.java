package fiuba.algo3.tp2.entidadesPrincipales.piezas;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.atributos.Ataque;

public abstract class Saludable extends Pieza {

    protected Ataque curacion;
    protected int puntosDeCuracion;

    public abstract void curar(Pieza pieza, int distanciaConPieza);

    public void curar(Pieza pieza){
        pieza.recibirVida(this.puntosDeCuracion);
    }

    public int getPuntosDePoder(){
        return puntosDeCuracion;
    }
}
