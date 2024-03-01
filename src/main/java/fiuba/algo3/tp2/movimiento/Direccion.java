package fiuba.algo3.tp2.movimiento;

public class Direccion {

    private static Direccion arriba;
    private static Direccion abajo;
    private static Direccion derecha;
    private static Direccion izquierda;

    static {

        arriba = new Direccion(-1, 0);
        abajo = new Direccion(1, 0);
        derecha = new Direccion(0, 1);
        izquierda = new Direccion(0, -1);
    }

    private int direccionFila;
    private int direccionColumna;

    public Direccion(int direccionFila, int direccionColumna) {

        this.direccionFila = direccionFila;
        this.direccionColumna = direccionColumna;
    }

    public Posicion calcularSiguientePosicion(Posicion posicion ) {

        int nuevaFila = posicion.getPosicionFila() + this.direccionFila;
        int nuevaColumna = posicion.getPosicionColumna() + this.direccionColumna;

        Posicion nuevaPosicion = new Posicion(nuevaFila,nuevaColumna);
        return nuevaPosicion;
    }

    public static Direccion derecha() {
        return derecha;
    }

    public static Direccion izquierda() {
        return izquierda;
    }

    public static Direccion abajo() {
        return abajo;
    }

    public static Direccion arriba() {
        return arriba;
    }


}
