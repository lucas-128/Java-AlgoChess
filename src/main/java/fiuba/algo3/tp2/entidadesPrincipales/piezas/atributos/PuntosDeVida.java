package fiuba.algo3.tp2.entidadesPrincipales.piezas.atributos;

import fiuba.algo3.tp2.excepciones.PiezaEstaMuertaException;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Catapulta;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Curandero;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Jinete;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.SoldadoDeInfanteria;

public class PuntosDeVida {

    private int vidaActual;

    private final int VIDA_INICIAL_SOLDADO = 100;
    private final int VIDA_INICIAL_JINETE = 100;
    private final int VIDA_INICIAL_CATAPULTA = 50;
    private final int VIDA_INICIAL_CURANDERO = 75;


    public PuntosDeVida(SoldadoDeInfanteria soldado) {

        vidaActual = VIDA_INICIAL_SOLDADO;
    }

    public PuntosDeVida(Jinete jinete) {

        vidaActual = VIDA_INICIAL_JINETE;
    }

    public PuntosDeVida(Catapulta catapulta) {

        vidaActual = VIDA_INICIAL_CATAPULTA;
    }

    public PuntosDeVida(Curandero curandero) {

        vidaActual = VIDA_INICIAL_CURANDERO;
    }

    public void quitarVida(int puntos){

        if(this.estoyMuerta())
            throw new PiezaEstaMuertaException();

        vidaActual -= puntos;
    }

    public void aumentarVida(int puntos){

        if(this.estoyMuerta())
            throw new PiezaEstaMuertaException();

        vidaActual += puntos;
    }

    public int getVidaRestante() {

        return vidaActual;
    }

    public boolean estoyMuerta() {

        return (vidaActual <= 0);
    }
}
