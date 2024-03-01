package fiuba.algo3.tp2.entidadesPrincipales.piezas.batallon;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.movimiento.Direccion;

import java.util.ArrayList;

public class Batallon {

    private TipoDeBatallon tipoDeBatallon;

    public boolean estaCompleto() {

        return tipoDeBatallon.estaCompleto();
    }

    public void armadoBatallon(Pieza pieza, ArrayList<Pieza> piezas) {

        tipoDeBatallon = new BatallonVertical();
        tipoDeBatallon.armarBatallon(pieza,piezas);

        if(this.estaCompleto())
            return;

        tipoDeBatallon = new BatallonHorizontal();
        tipoDeBatallon.armarBatallon(pieza,piezas);
    }

    public void moverBatallon(Pieza pieza, Direccion direccion, Tablero tablero) {

        tipoDeBatallon.moverBatallon(pieza,tablero,direccion);
    }
}
