package fiuba.algo3.tp2.colores;

import fiuba.algo3.tp2.movimiento.Posicion;

public class Blanco implements Color{

    @Override
    public boolean esBlanco() {
        return true;
    }

    @Override
    public boolean esNegro() {
        return false;
    }

    @Override
    public boolean esDelMismoColor(Color unColor) {
        return unColor.esBlanco();
    }

    @Override
    public boolean estoyDelLadoEnemigo(Posicion posicion) {

        return posicion.ladoNegro();
    }


    public String comoString() {

        return "blanco";
    }
}
