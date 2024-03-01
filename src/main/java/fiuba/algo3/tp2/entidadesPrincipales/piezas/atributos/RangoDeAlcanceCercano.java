package fiuba.algo3.tp2.entidadesPrincipales.piezas.atributos;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.*;

import java.util.ArrayList;

public class RangoDeAlcanceCercano implements RangoDeAlcance {


    @Override
    public void atacar(SoldadoDeInfanteria soldado, Pieza receptor) {

        soldado.atacar(receptor);
    }

    @Override
    public void atacar(Jinete jinete, Pieza receptor) {

        if(jinete.calcularDistancia(receptor.getPosicion()) <= 2){
            jinete.atacar(receptor, new AtaqueConEspada());
        }


    }

    @Override
    public void atacar(Catapulta catapulta, Pieza receptor, ArrayList<Pieza> contiguas) {


        // no ataca de cerca
    }

    @Override
    public void curar(Curandero curandero, Pieza receptor) {

        curandero.curar(receptor);

    }

}
