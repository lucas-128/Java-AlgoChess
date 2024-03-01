package fiuba.algo3.tp2.entidadesPrincipales.piezas.atributos;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.*;

import java.util.ArrayList;

public interface RangoDeAlcance {

    void atacar(SoldadoDeInfanteria soldado, Pieza receptor);

    void atacar(Jinete jinete, Pieza receptor);

    void atacar(Catapulta catapulta, Pieza receptor, ArrayList<Pieza> contiguas);

    void curar(Curandero curandero, Pieza receptor);
}
