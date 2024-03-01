package fiuba.algo3.tp2.entidadesPrincipales.tienda;

import fiuba.algo3.tp2.entidadesPrincipales.tienda.relacionados.Billetera;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.*;

public class Tienda {

    public Pieza comprarPieza(Pieza pieza, Billetera billetera){

        return pieza.serComprada(billetera);
    }
}
