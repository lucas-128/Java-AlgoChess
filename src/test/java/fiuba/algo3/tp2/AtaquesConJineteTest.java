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
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtaquesConJineteTest {

    @Test
    public void test01JineteAtacaOtroJineteYLeQuita5PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete(blanco);
        Jinete jineteEnemigo = new Jinete(negro);

        jugadorBlanco.insertarPiezaEnPosicion(jinete,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(jineteEnemigo,10,9,tablero);

        jugadorBlanco.atacarCon(jinete,10,9,tablero);

        /**jinete enemigo pasa de tener 100 puntos de vida a tener 95. */
        assertEquals(95, jineteEnemigo.getPuntosDeVida());
    }

    @Test
    public void test02JineteAtacaCatapultaYLeQuita5PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        jugadorBlanco.insertarPiezaEnPosicion(jinete,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(catapultaEnemiga,10,9,tablero);

        jugadorBlanco.atacarCon(jinete,10,9,tablero);

        assertEquals(45, catapultaEnemiga.getPuntosDeVida());
    }

    @Test
    public void test03JineteAtacaSoldadoDeInfanteriaYLeQuita5PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete(blanco);
        Jinete soldadoEnemigo = new Jinete(negro);

        jugadorBlanco.insertarPiezaEnPosicion(jinete,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(soldadoEnemigo,10,9,tablero);

        jugadorBlanco.atacarCon(jinete,10,9,tablero);

        assertEquals(95, soldadoEnemigo.getPuntosDeVida());
    }

    @Test
    public void test04JineteAtacaCuranderoYLeQuita5PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete(blanco);
        Curandero curanderoEnemigo = new Curandero(negro);

        jugadorBlanco.insertarPiezaEnPosicion(jinete,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(curanderoEnemigo,10,9,tablero);

        jugadorBlanco.atacarCon(jinete,10,9,tablero);

        assertEquals(70, curanderoEnemigo.getPuntosDeVida());
    }

    @Test
    public void test05JineteNoPuedeAtacarPiezaMuerta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        jugadorBlanco.insertarPiezaEnPosicion(jinete,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(catapultaEnemiga,10,9,tablero);


        /** ataca 10 veces y la deja en 0 de vida */
        for(int i = 0; i < 10; i++) {
            jugadorBlanco.atacarCon(jinete, 10, 9, tablero);
            jugadorBlanco.terminarTurno();
        }

        /** falla atacar devuelta porque ya esta muerta */
        assertThrows(PiezaEstaMuertaException.class,
                ()->{
                    jugadorBlanco.atacarCon(jinete, 10, 9, tablero);
                });
    }

    @Test
    public void test06JineteNoPuedeAtacarUnidadAliada() {

        Color blanco = new Blanco();
        Jinete jinete = new Jinete(blanco);
        SoldadoDeInfanteria soldadoAliado = new SoldadoDeInfanteria(blanco);
        Jugador jugadorBlanco = new Jugador(blanco);
        Tablero tablero = new Tablero();

        jugadorBlanco.insertarPiezaEnPosicion(jinete,9,9,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldadoAliado,8,9,tablero);
        jugadorBlanco.atacarCon(jinete,8,9,tablero);

        assertEquals(soldadoAliado.getPuntosDeVida(), 100);
    }

    @Test
    public void test07JineteAtacaCasilleroVacioNoPasaNada() {

        Color blanco = new Blanco();
        Jinete jinete = new Jinete(blanco);
        Jugador jugadorBlanco = new Jugador(blanco);
        Tablero tablero = new Tablero();

        jugadorBlanco.insertarPiezaEnPosicion(jinete,9,9,tablero);
        jugadorBlanco.atacarCon(jinete,10,10,tablero);

    }
}
