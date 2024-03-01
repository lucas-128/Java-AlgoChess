package fiuba.algo3.tp2.entidadesPrincipales.piezas.atributos;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;

public class AtaqueConEspada implements TipoDeAtaque {

    private final int DANIO_JINETE = 5;

    public AtaqueConEspada() {
    }

    @Override
    public void atacar(Pieza pieza) {
        pieza.perderVida(this.DANIO_JINETE);
    }
}
