package fiuba.algo3.tp2.movimiento;

import fiuba.algo3.tp2.colores.Color;

public class Posicion {

    private int posicionFila;
    private int posicionColumna;

    public Posicion (int posFila, int posColumna){

        posicionColumna = posColumna;
        posicionFila = posFila;
    }

    public int calcularDistancia(Posicion posicion) {

        int distanciaColumna = Math.abs(posicionColumna - posicion.getPosicionColumna());
        int distanciaFila = Math.abs(posicionFila - posicion.getPosicionFila());

        return distanciaColumna + distanciaFila;
    }

    public boolean estoyDelLadoEnemigo(Color color) {

        return  color.estoyDelLadoEnemigo(this);
    }

    public boolean esContigua(Posicion posicion) {

        int distancia = this.calcularDistancia(posicion);
        return (distancia <= 1);
    }

    public boolean esValida() {

        return ((posicionFila >= 0 && posicionFila < 20) && (posicionColumna >= 0 && posicionColumna < 20));
    }

    public boolean alineadoVerticalmente(Posicion posicion) {

        boolean mismaColumna = (posicionColumna == posicion.getPosicionColumna());
        boolean filaContigua = (Math.abs(posicionFila - posicion.getPosicionFila()) <= 1);

        return (mismaColumna && filaContigua);
    }


    public boolean alineadoHorizontalmente(Posicion posicion) {

        boolean mismaFila = (posicionFila == posicion.getPosicionFila());
        boolean columnaContigua = (Math.abs(posicionColumna - posicion.getPosicionColumna()) <= 1);

        return (mismaFila && columnaContigua);
    }

    public int getPosicionColumna() {

        return posicionColumna;
    }

    public int getPosicionFila() {

        return posicionFila;
    }

    public boolean ladoNegro() {

        return (posicionFila >= 10);
    }

    public boolean ladoBlanco() {

        return  (posicionFila < 10);
    }
}
