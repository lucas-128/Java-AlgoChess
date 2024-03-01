package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Catapulta;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Jinete;
import fiuba.algo3.tp2.juego.Algochess;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.SoldadoDeInfanteria;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.*;

public class FasesDeJuegoTest {

    /*
    @Test
    public void test01JugadorBlancoPuedeComprarPiezasEnLaFaseDeCompra() {
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.jugadorComprarPieza(soldado, 2, 2);

        assertTrue(jugadorBlanco.sigueEnJuego());
    }
    @Test
    public void test02JugadorNegroPuedeComprarPiezasEnLaFaseDeCompra(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(negro);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.terminarTurno();
        juego.jugadorComprarPieza(soldado,15,15);

        assertTrue(jugadorNegro.sigueEnJuego());
    }
    @Test
    public void test03JugadorBlancoNoPuedeComprarPiezasEnElTurnoDelNegro(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(negro);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.terminarTurno();

        juego.jugadorComprarPieza(soldado,2,2);

        assertFalse(juego.casilleroOcupado(2,2));
    }
    @Test
    public void test04JugadorNegroNoPuedeComprarPiezasEnElTurnoDelBlanco(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);

        juego.jugadorComprarPieza(soldado,15,15);

        assertFalse(juego.casilleroOcupado(15,15));
    }
    @Test
    public void test05JugadorBlancoNoPuedeMoverPiezasEnLaFaseDeCompra(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.jugadorComprarPieza(soldado,2,2);
        juego.moverPieza(soldado, Direccion.derecha());

        assertFalse(juego.casilleroOcupado(2,3));
    }
    @Test
    public void test06JugadorNegroNoPuedeMoverPiezasEnLaFaseDeCompra(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(negro);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.terminarTurno();
        juego.jugadorComprarPieza(soldado,15,15);
        juego.moverPieza(soldado, Direccion.derecha());

        assertFalse(juego.casilleroOcupado(15,16));
    }

    @Test
    public void test07JugadorNegroNoPuedeAcomodarPiezasEnLaFaseDeCompra(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(negro);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.terminarTurno();
        juego.jugadorComprarPieza(soldado,15,15);
        juego.acomodarPieza(soldado, 19,19);

        assertFalse(juego.casilleroOcupado(19,19));
    }

    @Test
    public void test08JugadorBlancoNoPuedeComprarPiezasEnLaFaseDeBatalla(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldadoBlanco = new SoldadoDeInfanteria(blanco);
        SoldadoDeInfanteria soldadoNegro = new SoldadoDeInfanteria(negro);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.jugadorComprarPieza(soldadoBlanco,2,2);
        juego.terminarTurno();
        juego.jugadorComprarPieza(soldadoNegro,12,12);
        juego.terminarTurno();
        juego.terminarTurno();
        juego.terminarTurno();

        juego.jugadorComprarPieza(soldadoBlanco,3,3);

        assertFalse(juego.casilleroOcupado(3,3));
    }
    @Test
    public void test09JugadorNegroNoPuedeComprarPiezasEnLaFaseDeBatalla(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldadoNegro = new SoldadoDeInfanteria(negro);
        SoldadoDeInfanteria soldadoBlanco = new SoldadoDeInfanteria(blanco);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.jugadorComprarPieza(soldadoBlanco,2,2);
        juego.terminarTurno();
        juego.jugadorComprarPieza(soldadoNegro,12,12);
        juego.terminarTurno();
        juego.terminarTurno();
        juego.terminarTurno();
        juego.terminarTurno();

        juego.jugadorComprarPieza(soldadoNegro,15,15);

        assertFalse(juego.casilleroOcupado(15,15));
    }
    @Test
    public void test10JugadorNegroNoPuedeAcomodarPiezasEnLaFaseDeBatalla(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldadoNegro = new SoldadoDeInfanteria(negro);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.terminarTurno();
        juego.jugadorComprarPieza(soldadoNegro,12,12);
        juego.terminarTurno();
        juego.terminarTurno();
        juego.terminarTurno();
        juego.terminarTurno();

        juego.acomodarPieza(soldadoNegro,15,15);

        assertFalse(juego.casilleroOcupado(15,15));
    }
    @Test
    public void test11JugadorNegroNoPuedeComprarPiezasEnLaFaseDeDistribucion(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldadoNegro = new SoldadoDeInfanteria(negro);
        SoldadoDeInfanteria soldadoBlanco = new SoldadoDeInfanteria(blanco);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.jugadorComprarPieza(soldadoBlanco,2,2);
        juego.terminarTurno();
        juego.jugadorComprarPieza(soldadoNegro,12,12);
        juego.terminarTurno();
        juego.terminarTurno();

        juego.jugadorComprarPieza(soldadoNegro,15,15);

        assertFalse(juego.casilleroOcupado(15,15));
    }
    @Test
    public void test12JugadorNegroNoPuedeMoverPiezasEnLaFaseDeDistribucion(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldadoNegro = new SoldadoDeInfanteria(negro);
        SoldadoDeInfanteria soldadoBlanco = new SoldadoDeInfanteria(blanco);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.jugadorComprarPieza(soldadoBlanco,2,2);
        juego.terminarTurno();
        juego.jugadorComprarPieza(soldadoNegro,12,12);
        juego.terminarTurno();
        juego.terminarTurno();

        juego.moverPieza(soldadoNegro,Direccion.derecha());

        assertFalse(juego.casilleroOcupado(12,13));
    }
    @Test
    public void test13JugadorNegroNoPuedeAtacarPiezasEnLaFaseDeDistribucion(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldadoBlanco = new SoldadoDeInfanteria(blanco);
        Catapulta catapultaNegra = new Catapulta(negro);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.jugadorComprarPieza(soldadoBlanco,2,2);
        juego.terminarTurno();
        juego.jugadorComprarPieza(catapultaNegra,12,12);
        juego.terminarTurno();
        juego.terminarTurno();

        juego.atacarCon(catapultaNegra,2,2);

        assertEquals(soldadoBlanco.getPuntosDeVida(), 100);
    }
    @Test
    public void test14JugadorNegroPuedeAcomodarPiezasEnLaFaseDeDistribucion(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldadoNegro = new SoldadoDeInfanteria(negro);
        SoldadoDeInfanteria soldadoBlanco = new SoldadoDeInfanteria(blanco);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.jugadorComprarPieza(soldadoBlanco,2,2);
        juego.terminarTurno();
        juego.jugadorComprarPieza(soldadoNegro,15,15);
        juego.terminarTurno();
        juego.terminarTurno();

        juego.acomodarPieza(soldadoNegro,16,16);

        assertFalse(juego.casilleroOcupado(18,18));
    }*/

}
