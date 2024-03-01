package fiuba.algo3.tp2.flujoDelJuego;

public class LimitacionesDeJugadorPorTurno {

    boolean ataqueRealizado;
    boolean movimientoRealizado;

    public LimitacionesDeJugadorPorTurno(){
        reiniciarLimitaciones();
    }

    public void reiniciarLimitaciones() {

        this.ataqueRealizado = false;
        this.movimientoRealizado = false;
    }

    public void limitarMovimiento() {

        this.movimientoRealizado = true;
    }

    public void limitarCuracion() {

        this.ataqueRealizado = true;
    }

    public void limitarAtaque() {

        this.ataqueRealizado = true;
    }

    public boolean puedoRealizarMovimiento() {

        return !(this.movimientoRealizado);
    }

    public boolean puedoRealizarAtaque() {

        return !(this.ataqueRealizado);
    }

    public boolean puedoRealizarCuracion() {

        return !(this.ataqueRealizado);
    }
}
