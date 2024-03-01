package fiuba.algo3.tp2.colores;

import fiuba.algo3.tp2.movimiento.Posicion;

public interface Color {


    public boolean esBlanco();

    public boolean esNegro();

    public boolean esDelMismoColor(Color color);

    public boolean estoyDelLadoEnemigo(Posicion posicion);

    public String comoString();
}
