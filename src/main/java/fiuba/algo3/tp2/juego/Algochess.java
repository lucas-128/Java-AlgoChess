package fiuba.algo3.tp2.juego;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;

import java.util.LinkedList;

public class Algochess{

    private Tablero tablero;
    private LinkedList<Jugador> jugadores;


    public Algochess() {

        tablero = new Tablero();
        jugadores = new LinkedList();
    }

    public void cargarNombreNegro(String nombreNegro) {

        Jugador jugadorNegro = new Jugador(new Negro(), nombreNegro);
        jugadores.add(jugadorNegro);
    }

    public void cargarNombreBlanco(String nombreBlanco) {

        Jugador jugadorBlanco = new Jugador(new Blanco(), nombreBlanco);
        jugadores.add(jugadorBlanco);
    }

    public void jugadorComprarPieza(Pieza pieza, int fila, int columna){

        Jugador actual = jugadores.getFirst();
        actual.insertarPiezaEnPosicion(pieza,fila,columna,tablero);
    }

    public void moverPieza(Pieza pieza, Direccion direccion){

        Jugador actual = jugadores.getFirst();
        actual.moverPieza(pieza,direccion,tablero);
        System.out.println("Pieza se movió");

    }

    public void terminarTurno(){

        Jugador temp = jugadores.getFirst();
        temp.terminarTurno();

        jugadores.removeFirst();
        jugadores.addLast(temp);

        System.out.println("Se cambió de turno ahora es turno del jugador: " + jugadores.getFirst().getNombre());

    }

    public Jugador obtenerJugadorConTurno() {

        return jugadores.getFirst();
    }

    public void atacarCon(Danina pieza, int fila, int columna) {

        Jugador actual = jugadores.getFirst();
        actual.atacarCon(pieza,fila,columna,tablero);
    }

    public void curarCon(Saludable pieza, int fila, int columna){

        Jugador actual = jugadores.getFirst();
        actual.curarCon(pieza,fila,columna,tablero);
    }

    /**metodos para testing solamente*/
    public boolean casilleroOcupado(int fila, int columna) {

        return tablero.casilleroOcupado(fila,columna);
    }

    public Tablero getTablero() {

        return tablero;
    }

    public Jugador obtenerJugadorDelTurnoSiguiente() {

        return jugadores.getLast();
    }

    public Boolean juegoTerminado(){
        return (!this.obtenerJugadorDelTurnoSiguiente().sigueEnJuego());
    }
}
