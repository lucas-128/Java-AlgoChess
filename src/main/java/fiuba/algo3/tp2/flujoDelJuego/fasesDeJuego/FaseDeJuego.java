package fiuba.algo3.tp2.flujoDelJuego.fasesDeJuego;

import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.flujoDelJuego.AdministradorEventosPorTurno;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;

public abstract class FaseDeJuego {

    protected AdministradorEventosPorTurno administradorEventosPorTurno;

    public void actualizarInformacionJugador(Tablero tablero){
        administradorEventosPorTurno.actualizarInformacionJugador(tablero);
    }

    public void jugadorComprarPieza(Pieza pieza, int fila, int columna, Tablero tablero) {
        administradorEventosPorTurno.jugadorComprarPieza(pieza, fila, columna, tablero);
    }

    public void pasarASiguienteTurno(){
        administradorEventosPorTurno.pasarASiguienteTurno();
    }

    public abstract FaseDeJuego cambiarDeFaseSiEsNecesario();

    public abstract void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero);

    public abstract void atacarCon(Danina pieza, int fila, int columna, Tablero tablero);

    public abstract void curarCon(Saludable pieza, int fila, int columna, Tablero tablero);

    public abstract void acomodarPieza(Pieza pieza, int fila, int columna, Tablero tablero);
}
