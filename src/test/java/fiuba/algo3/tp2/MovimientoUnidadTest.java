package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Catapulta;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Curandero;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Jinete;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.SoldadoDeInfanteria;
import fiuba.algo3.tp2.juego.Algochess;
import fiuba.algo3.tp2.movimiento.Direccion;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovimientoUnidadTest {


    @Test
    public void test01UnidadSeMueveALaDerecha(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete(blanco);

        jugador.insertarPiezaEnPosicion(jinete,3,5,tablero);
        jugador.moverPieza(jinete,Direccion.derecha(),tablero);

        assertTrue(tablero.casilleroOcupado(3,6));
    }


    @Test
    public void test02UnidadSeMueveALaIzquierda(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero(blanco);

        jugador.insertarPiezaEnPosicion(curandero,3,5,tablero);
        jugador.moverPieza(curandero,Direccion.izquierda(),tablero);

        assertTrue(tablero.casilleroOcupado(3,4));
    }

    @Test
    public void test03UnidadSeMueveHaciaArriba(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);

        jugador.insertarPiezaEnPosicion(soldado,8,10,tablero);
        jugador.moverPieza(soldado,Direccion.arriba(),tablero);

        assertTrue(tablero.casilleroOcupado(7,10));
    }

    @Test
    public void test04UnidadSeMueveHaciaAbajo(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);

        jugador.insertarPiezaEnPosicion(soldado,9,6,tablero);
        jugador.moverPieza(soldado,Direccion.abajo(),tablero);

        assertTrue(tablero.casilleroOcupado(10,6));
    }

    @Test
    public void test05UnidadNoSePuedeMoverAUnaPosicionOcupada(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Jinete jinete = new Jinete(blanco);

        jugador.insertarPiezaEnPosicion(soldado,9,6,tablero);
        jugador.insertarPiezaEnPosicion(jinete,9,5,tablero);

        jugador.moverPieza(soldado,Direccion.izquierda(),tablero);

        assertEquals(true,tablero.casilleroOcupado(9,5));

    }

    @Test
    public void test06CatapultaNoSePuedeMover() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta(blanco);

        jugador.insertarPiezaEnPosicion(catapulta,9,6,tablero);
        jugador.moverPieza(catapulta,Direccion.abajo(),tablero);

        assertTrue(tablero.casilleroOcupado(9,6));
    }


    /*
    @Test
    public void test07JugadorSoloPuedeMover1PiezaPorTurno(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldadoBlanco = new SoldadoDeInfanteria(blanco);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.jugadorComprarPieza(soldadoBlanco,2,2);
        juego.terminarTurno();
        juego.terminarTurno();
        juego.terminarTurno();
        juego.terminarTurno();
        juego.moverPieza(soldadoBlanco, Direccion.derecha());
        juego.moverPieza(soldadoBlanco, Direccion.derecha());

        assertTrue(juego.casilleroOcupado(2,3));

    }*/

}
