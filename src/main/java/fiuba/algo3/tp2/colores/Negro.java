package fiuba.algo3.tp2.colores;

import fiuba.algo3.tp2.movimiento.Posicion;

public class Negro implements Color {

    @Override
    public boolean esBlanco() {
        return false;
    }

    @Override
    public boolean esNegro() {
        return true;
    }

    @Override
    public boolean esDelMismoColor(Color unColor) {
        return unColor.esNegro();
    }

    @Override
    public boolean estoyDelLadoEnemigo(Posicion posicion) {

        return posicion.ladoBlanco();
    }

    public String comoString() {

        return "negro";
    }

}
