package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Jinete;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.SoldadoDeInfanteria;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RangoJineteTest {

    @Test
    public void test01JineteConAliadoCercaAtacaDistanciaMedia(){
        Jugador jugadorBlanco = new Jugador(new Blanco());
        Jugador jugadorNegro = new Jugador(new Negro());
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete(new Blanco());
        SoldadoDeInfanteria soldadoBlanco = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldadoNegro = new SoldadoDeInfanteria(new Negro());
        jugadorBlanco.insertarPiezaEnPosicion(jinete,9,8,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldadoBlanco,9,7,tablero);
        jugadorNegro.insertarPiezaEnPosicion(soldadoNegro,13,8,tablero);

        jugadorBlanco.atacarCon(jinete,13,8,tablero);

        assertEquals(85,soldadoNegro.getPuntosDeVida());
    }

    @Test
    public void test02JineteAisladoAtacaDistanciaMedia(){
        Jugador jugadorBlanco = new Jugador(new Blanco());
        Jugador jugadorNegro = new Jugador(new Negro());
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete(new Blanco());
        SoldadoDeInfanteria soldadoNegro = new SoldadoDeInfanteria(new Negro());
        jugadorBlanco.insertarPiezaEnPosicion(jinete,9,8,tablero);
        jugadorNegro.insertarPiezaEnPosicion(soldadoNegro,13,8,tablero);

        jugadorBlanco.atacarCon(jinete,13,8,tablero);

        assertEquals(85,soldadoNegro.getPuntosDeVida());
    }

    @Test
    public void test03JineteConRivalCercaAtacaDistanciaCercana() {
        Jugador jugadorBlanco = new Jugador(new Blanco());
        Jugador jugadorNegro = new Jugador(new Negro());
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete(new Blanco());
        SoldadoDeInfanteria soldadoNegro = new SoldadoDeInfanteria(new Negro());
        jugadorBlanco.insertarPiezaEnPosicion(jinete, 9, 8, tablero);
        jugadorNegro.insertarPiezaEnPosicion(soldadoNegro, 10, 8, tablero);

        jugadorBlanco.atacarCon(jinete, 10, 8, tablero);

        assertEquals(95, soldadoNegro.getPuntosDeVida());

    }

    @Test
    public void test04JineteConRivalCercaNoPuedeAtacarRivalADistanciaMedia() {

        Jugador jugadorBlanco = new Jugador(new Blanco());
        Jugador jugadorNegro = new Jugador(new Negro());
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete(new Blanco());
        SoldadoDeInfanteria soldadoNegro1 = new SoldadoDeInfanteria(new Negro());
        SoldadoDeInfanteria soldadoNegro2 = new SoldadoDeInfanteria(new Negro());
        jugadorBlanco.insertarPiezaEnPosicion(jinete, 9, 8, tablero);
        jugadorNegro.insertarPiezaEnPosicion(soldadoNegro1, 10, 8, tablero);
        jugadorNegro.insertarPiezaEnPosicion(soldadoNegro2, 14, 8, tablero);

        jugadorBlanco.atacarCon(jinete, 14, 8, tablero);

        assertEquals(100, soldadoNegro2.getPuntosDeVida());

    }


}
