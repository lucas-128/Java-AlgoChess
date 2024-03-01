package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.excepciones.PiezaEstaMuertaException;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Catapulta;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Curandero;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Jinete;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.SoldadoDeInfanteria;
import fiuba.algo3.tp2.juego.Algochess;
import javafx.scene.control.Tab;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CuracionDeCuranderoTest {

    @Test
    public void test01CuranderoCuraJineteAliadoAtacadoPorCatapulta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Curandero curandero = new Curandero(blanco);
        Jinete jineteAliado = new Jinete(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        jugadorBlanco.insertarPiezaEnPosicion(jineteAliado,1,1,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(curandero,2,2,tablero);
        jugadorNegro.insertarPiezaEnPosicion(catapultaEnemiga,19,19,tablero);

        jugadorNegro.atacarCon(catapultaEnemiga,1,1,tablero);

        jugadorBlanco.curarCon(curandero, 1, 1, tablero);
        assertEquals(95, jineteAliado.getPuntosDeVida());
    }

    @Test
    public void test02CuranderoNoPuedeCurarUnidadEnemiga() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Curandero curandero = new Curandero(blanco);
        Catapulta catapulta = new Catapulta(blanco);
        Jinete jineteEnemigo = new Jinete(negro);

        jugadorBlanco.insertarPiezaEnPosicion(curandero,9,9,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(catapulta, 2,2,tablero);
        jugadorNegro.insertarPiezaEnPosicion(jineteEnemigo,10,9,tablero);

        jugadorBlanco.atacarCon(catapulta,10,9,tablero);
        jugadorBlanco.terminarTurno();
        jugadorBlanco.curarCon(curandero, 10, 9, tablero);

        assertEquals( 95, jineteEnemigo.getPuntosDeVida());
    }

    @Test
    public void test03CuranderoNoPuedeCurarUnidadMuerta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Curandero curandero = new Curandero(blanco);
        Jinete jineteAliado = new Jinete(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        jugadorBlanco.insertarPiezaEnPosicion(jineteAliado,1,1,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(curandero,2,2,tablero);
        jugadorNegro.insertarPiezaEnPosicion(catapultaEnemiga,19,19,tablero);

        jugadorNegro.atacarCon(catapultaEnemiga,1,1,tablero);
        jugadorNegro.terminarTurno();
        jugadorNegro.atacarCon(catapultaEnemiga,1,1,tablero);
        jugadorNegro.terminarTurno();
        jugadorNegro.atacarCon(catapultaEnemiga,1,1,tablero);
        jugadorNegro.terminarTurno();
        jugadorNegro.atacarCon(catapultaEnemiga,1,1,tablero);
        jugadorNegro.terminarTurno();
        jugadorNegro.atacarCon(catapultaEnemiga,1,1,tablero);


        assertThrows(PiezaEstaMuertaException.class,
                ()->{
                    jugadorBlanco.curarCon(curandero, 1, 1, tablero);
                });
    }

    @Test
    public void test04CuranderoNoPuedeCurarCatapulta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Curandero curandero = new Curandero(blanco);
        Catapulta catapultaAliada = new Catapulta(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        jugadorBlanco.insertarPiezaEnPosicion(catapultaAliada,1,1,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(curandero,5,5,tablero);
        jugadorNegro.insertarPiezaEnPosicion(catapultaEnemiga,19,19,tablero);

        jugadorNegro.atacarCon(catapultaEnemiga,1,1,tablero);


        /** Los puntos de vida de la catapulta no cambian */
        jugadorBlanco.curarCon(curandero, 1, 1, tablero);


        assertEquals(30, catapultaAliada.getPuntosDeVida());
    }

    /*
    @Test
    public void test05JugadorSoloPuedeCurarCon1PiezaPorTurno() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Curandero curanderoBlanco = new Curandero(blanco);
        SoldadoDeInfanteria soldadoBlanco = new SoldadoDeInfanteria(blanco);
        Catapulta catapultaNegra = new Catapulta(negro);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.jugadorComprarPieza(curanderoBlanco,2,2);
        juego.jugadorComprarPieza(soldadoBlanco, 3,3);
        juego.terminarTurno();
        juego.jugadorComprarPieza(catapultaNegra, 14,14);
        juego.terminarTurno();
        juego.terminarTurno();
        juego.terminarTurno();
        juego.terminarTurno();
        juego.atacarCon(catapultaNegra, 3,3);
        juego.terminarTurno();
        juego.terminarTurno();
        juego.atacarCon(catapultaNegra, 3,3);
        juego.terminarTurno();
        juego.curarCon(curanderoBlanco, 3, 3);
        juego.curarCon(curanderoBlanco, 3, 3);

        assertEquals(soldadoBlanco.getPuntosDeVida(), 75);
    }*/

    @Test
    public void test06CuranderoCuraPosicionVaciaNoPasaNada() {

        Jugador jugador = new Jugador(new Blanco());
        Tablero tablero = new Tablero();
        Curandero cura = new Curandero(new Blanco());

        jugador.insertarPiezaEnPosicion(cura,5,5,tablero);
        jugador.curarCon(cura,9,9,tablero);
    }
}