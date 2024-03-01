package fiuba.algo3.tp2.flujoDelJuego;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;

public class TurnoNegro extends Turno {

    public TurnoNegro(Jugador jugadorBlanco, Jugador jugadorNegro) {
        this.jugadorBlanco = jugadorBlanco;
        this.jugadorNegro = jugadorNegro;
    }

    @Override
    public Jugador getJugadorConTurno(){
        return this.jugadorNegro;
    }
    @Override
    public Jugador pasarASiguiente(){
        this.turno = new TurnoBlanco(jugadorBlanco, jugadorNegro);
        return this.turno.getJugadorConTurno();
    }

    @Override
    public void actualizarInformacionJugador(Jugador jugadorConTurno, Tablero tablero) {
        this.jugadorNegro = jugadorConTurno;
        this.jugadorBlanco.actualizarPiezas(tablero);
        this.jugadorNegro.actualizarPiezas(tablero);
    }

    @Override
    public boolean hayAlgunJugadorMuerto() {
        return (!(jugadorBlanco.sigueEnJuego() && jugadorNegro.sigueEnJuego()));
    }
}
