package modelo;

import java.util.ArrayList;

public class SolucionesBackTraking {
    Solucion solucionActual = new Solucion();
    private int reinas = 0;
    ArrayList<Solucion> arraySoluciones = new ArrayList<Solucion>();

    public SolucionesBackTraking(boolean una) {
        if(una) {
            buscarUnaSolucion(0);
        } else {
            buscarSolucion(0);
        }
    }

    public void buscarSolucion(int i) {
        if (reinas == Solucion.NUMERO_REINAS) {
            getArraySoluciones().add((Solucion) solucionActual.clone());
        } else {
            int j;
            for (j = 0; j < Solucion.NUMERO_REINAS; j++) {
                if (solucionActual.esPosicionNoAmenazada(i, j)) {
                    solucionActual.getTablero().get(i).set(j, Solucion.REINA);
                    reinas++;

                    buscarSolucion(i + 1);

                    solucionActual.getTablero().get(i).set(j, Solucion.NO_REINA);
                    reinas--;

                }
            }
        }
    }
    void buscarUnaSolucion(int i) {
        if (reinas == Solucion.NUMERO_REINAS) {
            getArraySoluciones().add((Solucion) solucionActual.clone());
        }
        int j;
        for (j = 0; j < Solucion.NUMERO_REINAS; j++) {
                if(solucionActual.esPosicionNoAmenazada(i, j)){
                    solucionActual.getTablero().get(i).set(j, Solucion.REINA);
                    reinas++;
                    if(i < Solucion.NUMERO_REINAS){
                        buscarUnaSolucion(i + 1);
                        if(reinas < Solucion.NUMERO_REINAS){
                            solucionActual.getTablero().get(i).set(j, Solucion.NO_REINA);
                            reinas--;
                        }
                    }
                }
        }

    }

    /**
     * Getter.  {@link SolucionesBackTraking#arraySoluciones}
     * @return Retorna arraySoluciones 
     */
    public ArrayList<Solucion> getArraySoluciones() {
        return arraySoluciones;
    }
} 
