package fiuba.algo3.tp2.flujoDelJuego.fasesDeJuego;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.excepciones.NoSePuedeRealizarEstaAccionEnLaFaseDeDistribucionException;
import fiuba.algo3.tp2.flujoDelJuego.AdministradorEventosGenerales;
import fiuba.algo3.tp2.flujoDelJuego.AdministradorEventosPorTurno;
import fiuba.algo3.tp2.movimiento.Direccion;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public class FaseDeDistribucion extends FaseDeJuego {
    private StreamHandler streamHandler = new StreamHandler();
    private static final Logger logger = Logger.getLogger( FaseDeDistribucion.class.getName() );

    public FaseDeDistribucion(AdministradorEventosPorTurno administradorEventosPorTurno){
        logger.addHandler(streamHandler);
        this.administradorEventosPorTurno = administradorEventosPorTurno;
    }

    @Override
    public FaseDeJuego cambiarDeFaseSiEsNecesario() {
        if(this.administradorEventosPorTurno.terminoLaFase(this))
            return this.pasarASiguiente();
        return this;
    }

    private FaseDeJuego pasarASiguiente() {
        return new FaseDeBatalla(this.administradorEventosPorTurno);
    }

    @Override
    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero) {
        try{
            throw new NoSePuedeRealizarEstaAccionEnLaFaseDeDistribucionException("No podes mover piezas en la fase de distribucion, proba acomodando la pieza");
        }catch (NoSePuedeRealizarEstaAccionEnLaFaseDeDistribucionException e){
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void atacarCon(Danina pieza, int fila, int columna, Tablero tablero) {
        try{
            throw new NoSePuedeRealizarEstaAccionEnLaFaseDeDistribucionException("No podes atacar en la fase de distribucion");
        }catch (NoSePuedeRealizarEstaAccionEnLaFaseDeDistribucionException e){
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void curarCon(Saludable pieza, int fila, int columna, Tablero tablero) {
        try{
            throw new NoSePuedeRealizarEstaAccionEnLaFaseDeDistribucionException("No podes curar piezas en la fase de distribucion");
        }catch (NoSePuedeRealizarEstaAccionEnLaFaseDeDistribucionException e){
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void acomodarPieza(Pieza pieza, int fila, int columna, Tablero tablero) {
        this.administradorEventosPorTurno.acomodarPieza(pieza, fila, columna, tablero);
    }

    @Override
    public void jugadorComprarPieza(Pieza pieza, int fila, int columna, Tablero tablero) {
        try{
            throw new NoSePuedeRealizarEstaAccionEnLaFaseDeDistribucionException("No podes comprar piezas en la fase de distribucion");
        }catch (NoSePuedeRealizarEstaAccionEnLaFaseDeDistribucionException e){
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
