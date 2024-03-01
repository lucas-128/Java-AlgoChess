package fiuba.algo3.tp2.flujoDelJuego;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;

public class Turno{

    protected Jugador jugadorBlanco;
    protected Jugador jugadorNegro;
    protected Turno turno;
    protected int cantidadDeTurnosJugados;
    private final static int TURNOS_DE_FASE_DE_COMPRA = 2;
    private final static int TURNOS_DE_FASE_DE_DISTRIBUCION = 4;


    Turno(){

    }

    Turno(Jugador jugadorBlanco, Jugador jugadorNegro){
        turno = new TurnoBlanco(jugadorBlanco, jugadorNegro);
        this.cantidadDeTurnosJugados = 0;
    }

    public Jugador getJugadorConTurno() {
        return turno.getJugadorConTurno();
    }

    public Jugador pasarASiguiente(){
        this.cantidadDeTurnosJugados++;
        return turno.pasarASiguiente();
    }

    public void actualizarInformacionJugador(Jugador jugadorConTurno, Tablero tablero){
        turno.actualizarInformacionJugador(jugadorConTurno, tablero);
    }

    public boolean turnosDeCompraCumplidos() {
        return (this.cantidadDeTurnosJugados >= TURNOS_DE_FASE_DE_COMPRA);
    }
    public boolean turnosDeDistribucionCumplidos() {
        return (this.cantidadDeTurnosJugados >= TURNOS_DE_FASE_DE_DISTRIBUCION);
    }
    public boolean hayAlgunJugadorMuerto() {
        return this.turno.hayAlgunJugadorMuerto();
    }
}
