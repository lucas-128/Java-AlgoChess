package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.excepciones.PiezaEstaMuertaException;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Catapulta;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Curandero;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Jinete;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.SoldadoDeInfanteria;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtaquesConSoldadoDeInfanteriaTest {
    @Test
    public void test01SoldadoDeInfanteriaAtacaJineteYLeQuita10PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Jinete jineteEnemigo = new Jinete(negro);

        jugadorBlanco.insertarPiezaEnPosicion(soldado,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(jineteEnemigo,10,9,tablero);

        jugadorBlanco.atacarCon(soldado,10,9,tablero);

        assertEquals(90, jineteEnemigo.getPuntosDeVida());
    }


    @Test
    public void test02SoldadoDeInfanteriaAtacaCatapultaYLeQuita10PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Catapulta catapulta = new Catapulta(negro);

        jugadorBlanco.insertarPiezaEnPosicion(soldado,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(catapulta,10,9,tablero);

        jugadorBlanco.atacarCon(soldado,10,9,tablero);

        assertEquals(40, catapulta.getPuntosDeVida());
    }

    @Test
    public void test03SoldadoDeInfanteriaAtacaOtroSoldadoDeInfanteriaYLeQuita10PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        SoldadoDeInfanteria soldadoEnemigo = new SoldadoDeInfanteria(negro);

        jugadorBlanco.insertarPiezaEnPosicion(soldado,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(soldadoEnemigo,10,9,tablero);

        jugadorBlanco.atacarCon(soldado,10,9,tablero);

        assertEquals(90, soldadoEnemigo.getPuntosDeVida());
    }

    @Test
    public void test04SoldadoDeInfanteriaAtacaCuranderoYLeQuita10PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Curandero curanderoEnemigo = new Curandero(negro);

        jugadorBlanco.insertarPiezaEnPosicion(soldado,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(curanderoEnemigo,10,9,tablero);

        jugadorBlanco.atacarCon(soldado,10,9,tablero);

        assertEquals(65, curanderoEnemigo.getPuntosDeVida());
    }

    @Test
    public void test05SoldadoDeInfanteriaNoPuedeAtacarPiezaMuerta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        jugadorBlanco.insertarPiezaEnPosicion(soldado,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(catapultaEnemiga,10,9,tablero);

        /** ataca 5 veces y la deja en 0 de vida */
        for(int i = 0; i < 5; i++) {
            jugadorBlanco.atacarCon(soldado,10,9,tablero);
            jugadorBlanco.terminarTurno();
        }

        /** falla atacar devuelta porque ya esta muerta */
        assertThrows(PiezaEstaMuertaException.class,
                ()->{
                    jugadorBlanco.atacarCon(soldado,10,9,tablero);
                });
    }

    @Test
    public void test06SoldadoDeInfanteriaNoPuedeAtacarUnidadAliada() {

        Color blanco = new Blanco();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Jinete jineteAliado = new Jinete(blanco);
        Jugador jugadorBlanco = new Jugador(blanco);
        Tablero tablero = new Tablero();

        jugadorBlanco.insertarPiezaEnPosicion(soldado,9,9,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(jineteAliado,8,9,tablero);
        jugadorBlanco.atacarCon(soldado,8,9,tablero);

        assertEquals(jineteAliado.getPuntosDeVida(), 100);
    }

    @Test
    public void test07SoldadoDeLadoEnemigoRecive5PorcientoMasDeAtaque() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        jugadorBlanco.insertarPiezaEnPosicion(soldado,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(catapultaEnemiga,18,9,tablero);

        jugadorBlanco.moverPieza(soldado, Direccion.abajo(),tablero);
        jugadorBlanco.terminarTurno();
        jugadorBlanco.moverPieza(soldado, Direccion.abajo(),tablero); // posicion pasa a ser Fila:11 - Columna:9

        jugadorNegro.atacarCon(catapultaEnemiga,11,9,tablero);

        assertEquals(79, soldado.getPuntosDeVida());
    }

    @Test
    public void test08SoldadoADistanciaMediaNoHaceDanio() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        jugadorBlanco.insertarPiezaEnPosicion(soldado,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(catapultaEnemiga,13,9,tablero);

        jugadorBlanco.atacarCon(soldado,13,9,tablero);
        assertEquals(50, catapultaEnemiga.getPuntosDeVida());
    }

    @Test
    public void test09SoldadoADistanciaLejanaNoHaceDanio() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        jugadorBlanco.insertarPiezaEnPosicion(soldado,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(catapultaEnemiga,18,9,tablero);

        jugadorBlanco.atacarCon(soldado,18,9,tablero);
        assertEquals(50, catapultaEnemiga.getPuntosDeVida());

    }

    @Test
    public void test10SoldadoAtacaPosicionVaciaNoPasaNada() {

        Jugador jugador = new Jugador(new Blanco());
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(new Blanco());
        Tablero tablero = new Tablero();


        jugador.insertarPiezaEnPosicion(soldado,3,3,tablero);
        jugador.atacarCon(soldado,5,5,tablero);
    }
}
