package fiuba.algo3.tp2.entidadesPrincipales.piezas.administrador;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Jinete;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.administrador.AdministradorDePiezas;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.excepciones.CasilleroEstaVacioException;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministradorDeJugadas {

    private static final int MAX_JUGADA_POR_TURNO = 1;

    private int ataquesRealizados;
    private int movimientosRealizados;

    public AdministradorDeJugadas() {

        ataquesRealizados = 0;
        movimientosRealizados = 0;
    }


    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero, AdministradorDePiezas admin) {

        if(movimientosRealizados < MAX_JUGADA_POR_TURNO) {
            admin.moverPieza(pieza, direccion, tablero);
            movimientosRealizados++;
        }
    }

    public void atacarCon(Danina pieza, Pieza receptor, int distanciaEntrePiezas, ArrayList<Pieza> contiguas) {

        if(ataquesRealizados < MAX_JUGADA_POR_TURNO) {
            pieza.atacar(receptor, distanciaEntrePiezas, contiguas);
            ataquesRealizados++;
        }

    }

    public void atacarCon(Jinete jinete, Pieza receptor, int distanciaEntrePiezas, ArrayList<Pieza> contiguas) {

        if(ataquesRealizados < MAX_JUGADA_POR_TURNO) {
            jinete.atacar(receptor, distanciaEntrePiezas, contiguas);
            ataquesRealizados++;
        }
    }


    public void curarCon(Saludable pieza, Pieza receptor, int distanciaEntrePiezas) {

        if(ataquesRealizados < 1) {
            pieza.curar(receptor, distanciaEntrePiezas);
            ataquesRealizados++;
        }
    }

    public void terminarTurno() {

        ataquesRealizados = 0;
        movimientosRealizados = 0;
    }

    public boolean quedanAtaques(){
        return ataquesRealizados<1;
    }

    public boolean quedanMovimientos(){
        return movimientosRealizados<1;
    }




}
