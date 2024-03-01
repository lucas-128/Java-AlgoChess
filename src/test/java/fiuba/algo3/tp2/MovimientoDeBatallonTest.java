package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Jinete;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.SoldadoDeInfanteria;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovimientoDeBatallonTest {

    @Test
    public void test01TresSoldadosFormanBatallonYSeMuevenJuntosHaciaArriba() {

        Jugador jugadorBlanco = new Jugador(new Blanco());
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(new Blanco());

        jugadorBlanco.insertarPiezaEnPosicion(soldado1,3,3,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado2,3,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado3,3,5,tablero);

        jugadorBlanco.moverPieza(soldado1, Direccion.arriba(), tablero);

        assertEquals(true,tablero.casilleroOcupado(2,3));
        assertEquals(true,tablero.casilleroOcupado(2,4));
        assertEquals(true,tablero.casilleroOcupado(2,5));

    }

    @Test
    public void test02TresSoldadosFormanBatallonYSeMuevenJuntosHaciaAbajo() {

        Jugador jugadorBlanco = new Jugador(new Blanco());
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(new Blanco());

        jugadorBlanco.insertarPiezaEnPosicion(soldado1,3,3,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado2,3,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado3,3,5,tablero);

        jugadorBlanco.moverPieza(soldado1, Direccion.abajo(), tablero);

        assertEquals(true,tablero.casilleroOcupado(4,3));
        assertEquals(true,tablero.casilleroOcupado(4,4));
        assertEquals(true,tablero.casilleroOcupado(4,5));

    }

    @Test
    public void test03TresSoldadosFormanBatallonYSeMuevenParaLaIzquierda() {

        Jugador jugadorBlanco = new Jugador(new Blanco());
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(new Blanco());

        jugadorBlanco.insertarPiezaEnPosicion(soldado1,3,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado2,4,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado3,5,4,tablero);

        jugadorBlanco.moverPieza(soldado1, Direccion.izquierda(), tablero);

        assertEquals(true,tablero.casilleroOcupado(3,3));
        assertEquals(true,tablero.casilleroOcupado(4,3));
        assertEquals(true,tablero.casilleroOcupado(5,3));

    }

    @Test
    public void test04TresSoldadosFormanBatallonYSeMuevenParaLaDerecha() {

        Jugador jugadorBlanco = new Jugador(new Blanco());
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(new Blanco());

        jugadorBlanco.insertarPiezaEnPosicion(soldado1,3,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado2,4,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado3,5,4,tablero);

        jugadorBlanco.moverPieza(soldado1, Direccion.derecha(), tablero);

        assertEquals(true,tablero.casilleroOcupado(3,5));
        assertEquals(true,tablero.casilleroOcupado(4,5));
        assertEquals(true,tablero.casilleroOcupado(5,5));

    }

    @Test
    public void test05DosSoldadosNoFormanBatallonSoloSeMueveUno() {

        Jugador jugadorBlanco = new Jugador(new Blanco());
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(new Blanco());

        jugadorBlanco.insertarPiezaEnPosicion(soldado1,3,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado2,4,4,tablero);

        jugadorBlanco.moverPieza(soldado1, Direccion.derecha(), tablero);

        assertEquals(true,tablero.casilleroOcupado(3,5));
        assertEquals(true,tablero.casilleroOcupado(4,4));
    }

    @Test
    public void test06BatallonSeMueveExceptoElQueTieneLaPosicionBloqueada() {

        Jugador jugadorBlanco = new Jugador(new Blanco());
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(new Blanco());
        Jinete jinete = new Jinete(new Blanco());

        jugadorBlanco.insertarPiezaEnPosicion(soldado1,3,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado2,4,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado3,5,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(jinete,4,5,tablero);

        jugadorBlanco.moverPieza(soldado1, Direccion.derecha(), tablero);

        assertEquals(true,tablero.casilleroOcupado(3,5));
        assertEquals(true,tablero.casilleroOcupado(4,4));
        assertEquals(true,tablero.casilleroOcupado(5,5));
    }

    @Test
    public void test07BatallonSeDisuelveLuegoDeMovimientoObstruidoYSoloSeMueveUno() {

        Jugador jugadorBlanco = new Jugador(new Blanco());
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(new Blanco());
        Jinete jinete = new Jinete(new Blanco());

        jugadorBlanco.insertarPiezaEnPosicion(soldado1,3,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado2,4,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado3,5,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(jinete,4,5,tablero);

        jugadorBlanco.moverPieza(soldado1, Direccion.derecha(), tablero);
        jugadorBlanco.terminarTurno();
        jugadorBlanco.moverPieza(soldado1, Direccion.derecha(), tablero);


        assertEquals(true,tablero.casilleroOcupado(3,6));
        assertEquals(true,tablero.casilleroOcupado(4,4));
        assertEquals(true,tablero.casilleroOcupado(5,5));
    }

    @Test
    public void test08CuatroSoldadosContiguosSoloSeMueven3() {

        Jugador jugadorBlanco = new Jugador(new Blanco());
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado4 = new SoldadoDeInfanteria(new Blanco());

        jugadorBlanco.insertarPiezaEnPosicion(soldado1,3,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado2,4,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado3,5,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado4,6,4,tablero);

        jugadorBlanco.moverPieza(soldado1, Direccion.derecha(), tablero);

        assertEquals(true,tablero.casilleroOcupado(3,5));
        assertEquals(true,tablero.casilleroOcupado(4,5));
        assertEquals(true,tablero.casilleroOcupado(5,5));
        assertEquals(true,tablero.casilleroOcupado(6,4));
    }

    @Test
    public void test09BatallonNoAlineadoNoSeMueve() {

        Jugador jugadorBlanco = new Jugador(new Blanco());
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(new Blanco());

        jugadorBlanco.insertarPiezaEnPosicion(soldado1,3,3,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado2,3,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado3,4,4,tablero);

        jugadorBlanco.moverPieza(soldado1, Direccion.arriba(), tablero);

        assertEquals(true,tablero.casilleroOcupado(2,3));
        assertEquals(true,tablero.casilleroOcupado(3,4));
        assertEquals(true,tablero.casilleroOcupado(4,4));
    }
    @Test
    public void test10SoloSoldadosAlineadosFormanBatallonYSeMueven() {

        Jugador jugadorBlanco = new Jugador(new Blanco());
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado4 = new SoldadoDeInfanteria(new Blanco());

        jugadorBlanco.insertarPiezaEnPosicion(soldado1,3,3,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado2,3,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado3,2,3,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado4,1,3,tablero);

        jugadorBlanco.moverPieza(soldado1, Direccion.izquierda(), tablero);

        assertEquals(true,tablero.casilleroOcupado(3,2));
        assertEquals(true,tablero.casilleroOcupado(2,2));
        assertEquals(true,tablero.casilleroOcupado(1,2));
    }
}
