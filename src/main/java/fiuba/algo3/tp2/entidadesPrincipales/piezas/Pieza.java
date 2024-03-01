package fiuba.algo3.tp2.entidadesPrincipales.piezas;

import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.administrador.AdministradorDePiezas;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.atributos.*;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.batallon.TipoDeBatallon;
import fiuba.algo3.tp2.entidadesPrincipales.tienda.relacionados.Billetera;
import fiuba.algo3.tp2.movimiento.Posicion;

public abstract class Pieza {

   protected final static int LIMITE_DISTANCIA_CERCA = 2;
   protected final static int LIMITE_DISTANCIA_MEDIA = 5;

    protected PuntosDeVida puntosDeVida;
    protected Color color;
    protected RangoDeAlcance rangoDeAlcance;
    protected int precio;
    protected Posicion posicion;
    protected String nombre;

    public void setRangoDeAlcance(int distanciaConPieza) {
        if(distanciaConPieza <= LIMITE_DISTANCIA_CERCA) {
            rangoDeAlcance = new RangoDeAlcanceCercano();

        } else if(distanciaConPieza <= LIMITE_DISTANCIA_MEDIA) {
            rangoDeAlcance = new RangoDeAlcanceMediaDistancia();

        } else {
            rangoDeAlcance = new RangoDeAlcanceLejano();
        }
    }

    public abstract void setRangoJineteCercano(Jinete jinete);


    public void perderVida(int danioRecibido) {
        danioRecibido = this.aplicarBonificacionesAlDanioRecibido(danioRecibido);
        puntosDeVida.quitarVida(danioRecibido);
    }

    protected int aplicarBonificacionesAlDanioRecibido(int danioRecibido) {
        if (this.estoyDelLadoEnemigo())
            danioRecibido += danioRecibido * 0.05;

        return danioRecibido;
    }

    protected boolean estoyDelLadoEnemigo(){
        return this.posicion.estoyDelLadoEnemigo(this.color);
    }

    public void recibirVida(int vidaRecibida) {
        puntosDeVida.aumentarVida(vidaRecibida);
    }

    public int calcularDistancia(Posicion posPieza) {
        return posicion.calcularDistancia(posPieza);
    }

    public boolean esDeMiEquipo(Pieza otraPieza) {
        return color.esDelMismoColor(otraPieza.getColor());
    }

    public Pieza serComprada(Billetera billetera) {
        billetera.retirarDinero(this.precio);
        return this;
    }

    public boolean estaMuerta() {
        return puntosDeVida.estoyMuerta();
    }

    public abstract void unirseABatallonVertical(TipoDeBatallon batallon, Pieza pieza);

    public abstract void unirseABatallonHorizontal(TipoDeBatallon batallon, Pieza pieza);


    public boolean esContiguoVerticalmente(Pieza pieza) {
        return  posicion.alineadoVerticalmente(pieza.getPosicion());
    }

    public boolean esContiguoHorizontalmente(Pieza pieza) {
        return  posicion.alineadoHorizontalmente(pieza.getPosicion());
    }

    public Color getColor() {
        return color;
    }

    public int getPuntosDeVida() {
        return puntosDeVida.getVidaRestante();
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void moverA(Posicion posicionNueva) {
        posicion = posicionNueva;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getCosto() {
        return precio;
    }
}
