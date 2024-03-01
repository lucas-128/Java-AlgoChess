package fiuba.algo3.tp2.entidadesPrincipales.piezas.batallon;

import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;

import java.util.ArrayList;

public abstract class TipoDeBatallon {

    private final int TAMANIO_MAX_BATALLON = 3;

    protected ArrayList<Pieza> soldados;

    public TipoDeBatallon() {

        soldados = new ArrayList<Pieza>();
    }

    public abstract void armarBatallon(Pieza pieza, ArrayList<Pieza> piezas);

    public boolean estaCompleto() {

        return  (soldados.size() == 3);
    }

    public void moverSoldados(Tablero tablero, Direccion direccion) {

        for(int i = 0; i<TAMANIO_MAX_BATALLON; i++)
            tablero.moverPieza(soldados.get(i),direccion);
    }

    public boolean contiene(Pieza pieza) {

        return soldados.contains(pieza);
    }

    public void agregar(Pieza pieza) {

        if(!this.contiene(pieza) && !this.estaCompleto())
            soldados.add(pieza);
    }


    public void moverBatallon(Pieza pieza, Tablero tablero, Direccion direccion) {

        if(this.estaCompleto())
            moverSoldados(tablero,direccion);
        else
            tablero.moverPieza(pieza,direccion);
    }
}
