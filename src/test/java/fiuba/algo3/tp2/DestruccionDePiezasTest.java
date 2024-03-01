package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Catapulta;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Jinete;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.SoldadoDeInfanteria;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DestruccionDePiezasTest {


    @Test
    public void test01SeDestuyeUnaPiezaDelJugadorYDesocupaElCasillero() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);

        jugador.insertarPiezaEnPosicion(soldado,5,5,tablero);
        jugador.insertarPiezaEnPosicion(soldado,6,5,tablero);
        jugador.borrarPieza(tablero,5,5);

        assertFalse(tablero.casilleroOcupado(5,5));
    }

    @Test
    public void testo02SeDestruyenTodasLasUnidadesDelJugadorYPierde() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete(blanco);

        jugador.insertarPiezaEnPosicion(jinete,5,5,tablero);
        jugador.borrarPieza(tablero,5,5);

        /** jugador 1 se queda sin unidades, pierde. */
        assertFalse(jugador.sigueEnJuego());
    }
    @Test
    public void test03JugadorDestruyePiezaEnemigaYDesocupaSuPosicion() {

        Jugador jugadorBlanco = new Jugador(new Blanco());
        Jugador jugadorNegro = new Jugador(new Negro());
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(new Blanco());
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(new Negro());

        jugadorBlanco.insertarPiezaEnPosicion(catapulta,5,5,tablero);
        jugadorNegro.insertarPiezaEnPosicion(soldado,11,11,tablero);

        jugadorBlanco.atacarCon(catapulta,11,11,tablero);
        jugadorBlanco.terminarTurno();
        jugadorBlanco.atacarCon(catapulta,11,11,tablero);
        jugadorBlanco.terminarTurno();
        jugadorBlanco.atacarCon(catapulta,11,11,tablero);
        jugadorBlanco.terminarTurno();
        jugadorBlanco.atacarCon(catapulta,11,11,tablero);
        jugadorBlanco.terminarTurno();
        jugadorBlanco.atacarCon(catapulta,11,11,tablero);

        jugadorNegro.actualizarPiezas(tablero);

        assertFalse(tablero.casilleroOcupado(11,11));

    }




}
