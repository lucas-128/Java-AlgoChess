package fiuba.algo3.tp2.flujoDelJuego;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.excepciones.YaNoSePuedeAtacarEsteTurnoException;
import fiuba.algo3.tp2.excepciones.YaNoSePuedeCurarEsteTurnoException;
import fiuba.algo3.tp2.excepciones.YaSeMovioUnaPiezaEsteTurnoException;
import fiuba.algo3.tp2.flujoDelJuego.fasesDeJuego.FaseDeBatalla;
import fiuba.algo3.tp2.flujoDelJuego.fasesDeJuego.FaseDeCompra;
import fiuba.algo3.tp2.flujoDelJuego.fasesDeJuego.FaseDeDistribucion;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public class AdministradorEventosPorTurno {
    private StreamHandler streamHandler = new StreamHandler();
    private static final Logger logger = Logger.getLogger( AdministradorEventosPorTurno.class.getName() );
    private Turno turno;
    private Jugador jugadorConTurno;
    private LimitacionesDeJugadorPorTurno limitaciones;

    public AdministradorEventosPorTurno(Jugador jugadorBlanco, Jugador jugadorNegro){
        logger.addHandler(streamHandler);
        this.turno = new Turno(jugadorBlanco, jugadorNegro);
        this.jugadorConTurno = turno.getJugadorConTurno();
        this.limitaciones = new LimitacionesDeJugadorPorTurno();

    }

    public void actualizarInformacionJugador(Tablero tablero) {
        turno.actualizarInformacionJugador(this.jugadorConTurno, tablero);
    }

    public void pasarASiguienteTurno() {
        jugadorConTurno = turno.pasarASiguiente();
        limitaciones.reiniciarLimitaciones();
    }

    public void jugadorComprarPieza(Pieza pieza, int fila, int columna, Tablero tablero) {
        jugadorConTurno.insertarPiezaEnPosicion(pieza, fila, columna, tablero);
    }

    public boolean terminoLaFase(FaseDeCompra faseDeJuego) {
        return turno.turnosDeCompraCumplidos();
    }
    public boolean terminoLaFase(FaseDeDistribucion faseDeJuego){
        return turno.turnosDeDistribucionCumplidos();
    }

    public boolean terminoLaFase(FaseDeBatalla faseDeJuego) {
        return this.turno.hayAlgunJugadorMuerto();
    }

    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero) {
        try{
            if(!limitaciones.puedoRealizarMovimiento())
                throw new YaSeMovioUnaPiezaEsteTurnoException("Solo se puede mover 1 pieza por turno");
        }catch (YaSeMovioUnaPiezaEsteTurnoException e){
            logger.log(Level.SEVERE, e.getMessage());
            return;
        }

        jugadorConTurno.moverPieza(pieza,direccion,tablero);
        limitaciones.limitarMovimiento();
    }

    public void atacarCon(Danina pieza, int fila, int columna, Tablero tablero) {
        try{
            if (!limitaciones.puedoRealizarAtaque())
                throw new YaNoSePuedeAtacarEsteTurnoException("Solo se puede atacar/curar 1 vez por turno");
        }catch (YaNoSePuedeAtacarEsteTurnoException e){
            logger.log(Level.SEVERE, e.getMessage());
            return;
        }

        jugadorConTurno.atacarCon(pieza, fila, columna, tablero);
        limitaciones.limitarAtaque();
    }

    public void curarCon(Saludable pieza, int fila, int columna, Tablero tablero) {
        try{
            if(!limitaciones.puedoRealizarCuracion())
                throw new YaNoSePuedeCurarEsteTurnoException("Solo se puede atacar/curar 1 vez por turno");
        }catch (YaNoSePuedeCurarEsteTurnoException e){
            logger.log(Level.SEVERE, e.getMessage());
            return;
        }


        jugadorConTurno.curarCon(pieza,fila,columna,tablero);
        limitaciones.limitarCuracion();
    }

    public void acomodarPieza(Pieza pieza, int fila, int columna, Tablero tablero) {
        tablero.acomodarPieza(pieza, fila, columna, tablero);
    }
}