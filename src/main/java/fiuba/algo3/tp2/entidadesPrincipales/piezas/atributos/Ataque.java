package fiuba.algo3.tp2.entidadesPrincipales.piezas.atributos;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.*;

import java.util.ArrayList;

public class Ataque {


    public void atacar(SoldadoDeInfanteria soldado, Pieza receptor, RangoDeAlcance rangoDeAlcance) {

        rangoDeAlcance.atacar(soldado, receptor);
    }

    public void atacar(Jinete jinete, Pieza receptor, RangoDeAlcance rangoDeAlcance) {

        rangoDeAlcance.atacar(jinete,receptor);

    }

    public void atacar(Catapulta catapulta, Pieza receptor, ArrayList<Pieza> contiguas, RangoDeAlcance rangoDeAlcance) {

        rangoDeAlcance.atacar(catapulta,receptor,contiguas);

    }

    public void curar(Curandero curandero, Pieza pieza, RangoDeAlcance rangoDeAlcance) {

        rangoDeAlcance.curar(curandero,pieza);
    }
}
