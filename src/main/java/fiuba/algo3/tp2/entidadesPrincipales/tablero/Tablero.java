package fiuba.algo3.tp2.entidadesPrincipales.tablero;

import fiuba.algo3.tp2.Observable;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.relacionados.Casillero;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.PiezasContiguas;
import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;

public class Tablero extends Observable {

    private static final int LIMITE_SUPERIOR = 20;
    private static final int LIMITE_INFERIOR = 0;

    private Casillero[][] casilleros;

    public Tablero() {

        casilleros = new Casillero[LIMITE_SUPERIOR][LIMITE_SUPERIOR];
        Color blanco = new Blanco();
        Color negro = new Negro();

        /* Primeras 10 filas color blanco */
        for(int fila = LIMITE_INFERIOR; fila<LIMITE_SUPERIOR/2; fila++) {
            for(int columna = LIMITE_INFERIOR; columna<LIMITE_SUPERIOR; columna++) {
                casilleros[fila][columna] = new Casillero(blanco);
            }
        }

        /* Siguientes 10 filas color negro */
        for(int fila = LIMITE_SUPERIOR/2; fila<LIMITE_SUPERIOR; fila++) {
            for(int columna = LIMITE_INFERIOR; columna<LIMITE_SUPERIOR; columna++) {
                casilleros[fila][columna] = new Casillero(negro);
            }
        }
    }

    public void agregarPieza(Pieza pieza, int posicionFila, int posicionColumna) {

        casilleros[posicionFila][posicionColumna].agregarPieza(pieza);
    }

    public void borrarPieza(Posicion posicion) {

        int posicionFila = posicion.getPosicionFila();
        int posicionColumna = posicion.getPosicionColumna();

        casilleros[posicionFila][posicionColumna].borrarPieza();
    }

    public boolean casilleroOcupado(int posicionFila, int posicionColumna) {

        return casilleros[posicionFila][posicionColumna].estaOcupado();
    }

    public void obtenerContiguos(Posicion posicion, PiezasContiguas contiguos) {

        int posFila = posicion.getPosicionFila();
        int posColumna = posicion.getPosicionColumna();

        if(this.estaDentroDelMapa(posFila,posColumna))
            casilleros[posFila][posColumna].agregarPiezaAContiguos(contiguos);

        if(this.estaDentroDelMapa(posFila+1,posColumna))
            casilleros[posFila+1][posColumna].agregarPiezaAContiguos(contiguos);

        if(this.estaDentroDelMapa(posFila-1,posColumna))
            casilleros[posFila-1][posColumna].agregarPiezaAContiguos(contiguos);

        if(this.estaDentroDelMapa(posFila, posColumna+1))
            casilleros[posFila][posColumna+1].agregarPiezaAContiguos(contiguos);

        if(this.estaDentroDelMapa(posFila,posColumna-1))
            casilleros[posFila][posColumna-1].agregarPiezaAContiguos(contiguos);
    }

    public boolean estaDentroDelMapa(int posFila, int posColumna) {

        Posicion posicion = new Posicion(posFila,posColumna);
        return posicion.esValida();
    }

    public void moverPieza(Pieza pieza, Direccion direccion) {

        Posicion posicionActual = pieza.getPosicion();
        Posicion posicionNueva = direccion.calcularSiguientePosicion(pieza.getPosicion());

        if(this.estaDentroDelMapa(posicionNueva.getPosicionFila(),posicionNueva.getPosicionColumna())) {

            if(!this.casilleroOcupado(posicionNueva.getPosicionFila(),posicionNueva.getPosicionColumna())) {

                pieza.moverA(posicionNueva);
                casilleros[posicionActual.getPosicionFila()][posicionActual.getPosicionColumna()].borrarPieza();
                posicionNueva = pieza.getPosicion();
                casilleros[posicionNueva.getPosicionFila()][posicionNueva.getPosicionColumna()].setPieza(pieza);
            }
        }
    }

    public Pieza obtenerPieza(int posicionFila, int posicionColumna) {

        return casilleros[posicionFila][posicionColumna].getPieza();
    }

    public Color getColor(int posicionFila, int posicionColumna) {

        return casilleros[posicionFila][posicionColumna].getColor();
    }

    public int obtenerTamanioTablero(){
        return this.LIMITE_SUPERIOR;
    }

    public void acomodarPieza(Pieza pieza, int fila, int columna, Tablero tablero) {
        this.borrarPieza(pieza.getPosicion());
        this.agregarPieza(pieza, fila, columna);
    }


}
