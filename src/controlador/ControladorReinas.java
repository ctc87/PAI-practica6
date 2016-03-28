package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.Solucion;
import modelo.SolucionesBackTraking;
import vista.Interfaz;

public class ControladorReinas {
    SolucionesBackTraking modelo;
    Interfaz vista;
    boolean terminado = false;
    Clock temporizador = new Clock();
    public ControladorReinas(String all) {
        if(gestionParametros(all)) {
            modelo = new SolucionesBackTraking(false);
            vista = new Interfaz("El problema de las " + Solucion.NUMERO_REINAS + " reinas", Solucion.NUMERO_REINAS);
            vista.disparadorDeAccionNuevaSolucion(new SiguienteSolucion());
        } else {
            temporizador.Start();
            modelo = new SolucionesBackTraking(true);
            temporizador.Stop();
            String tiempo = "Ha tardado en calcularse " + (float)Math.round(temporizador.getTimeTotal() * 100) / 100 + " segundos.";
            vista = new Interfaz("El problema de las " + Solucion.NUMERO_REINAS + " reinas", Solucion.NUMERO_REINAS);
            vista.pintar(modelo.getArraySoluciones().get(0).getCordenadasSolucion(), 1,  Solucion.NUMERO_REINAS, tiempo);
        }
    }
    
    public boolean gestionParametros(String param) {
       return param.equals("--all");
    }

    class SiguienteSolucion implements ActionListener {
        int iteracion = 0;
        
        @Override
        public void actionPerformed(ActionEvent evento) {
            if(!terminado) {
                String solucionAlgebraica = modelo.getArraySoluciones().get(iteracion).getSolucionNotacionAlgebraica().toString();
                ArrayList<Par> cordenadasSolucion = modelo.getArraySoluciones().get(iteracion).getCordenadasSolucion();
                if(iteracion < modelo.getArraySoluciones().size() - 1) {
                    vista.pintar(cordenadasSolucion, iteracion + 1,  Solucion.NUMERO_REINAS, solucionAlgebraica);
                } else {
                    vista.pintar(cordenadasSolucion, iteracion + 1,  Solucion.NUMERO_REINAS, "No hay más soluciones");
                    terminado = true;
                }
                iteracion++;
            }
        }

    }
    
    public static void main(String[] args) {
        if (args.length == 1) {
            new ControladorReinas(args[0]);
        } else {
            new ControladorReinas("one");
        }
    }
}
