package modelo;

import java.util.ArrayList;


import controlador.Par;

public class Solucion implements Cloneable {

    public static int NUMERO_REINAS = 8;
    static int NUMERO_CASILLAS = NUMERO_REINAS;
    static boolean REINA = true;
    static boolean NO_REINA = false;
    private ArrayList<ArrayList<Boolean>> tablero = new ArrayList<ArrayList<Boolean>>();
    private ArrayList<Par> CordenadasSolucion = new ArrayList<Par>();
    private NotacionAlgebraica solucionNotacionAlgebraica = new NotacionAlgebraica();

    public Solucion() {
        for (int i = 0; i < NUMERO_CASILLAS; i++) {
            ArrayList<Boolean> fila = new ArrayList<Boolean>();
            for (int j = 0; j < NUMERO_CASILLAS; j++) {
                fila.add(NO_REINA);
            }
            tablero.add(fila);
        }
    }

    public Solucion(Solucion solucion) {
        for (int i = 0; i < NUMERO_CASILLAS; i++) {
            ArrayList<Boolean> fila = new ArrayList<Boolean>();
            for (int j = 0; j < NUMERO_CASILLAS; j++) {
                fila.add(solucion.getTablero().get(i).get(j));
                if (solucion.getTablero().get(j).get(i)) {
                    getSolucionNotacionAlgebraica().nuevoValor(i, j);
                    getCordenadasSolucion().add(new Par(i, j));
                }
            }
            tablero.add(fila);
        }
    }

    private Boolean esFilaLibre(int posJ, int posI) {
        boolean libre = NO_REINA;
        for (int j = 0; (j < NUMERO_CASILLAS) && !libre; j++) {
            libre |= getTablero().get(posI).get(j);
        }
        return !libre;
    }

    private Boolean esColumnaLibre(int posJ, int posI) {
        boolean libre = NO_REINA;
        for (int j = 0; (j < NUMERO_CASILLAS) && !libre; j++) {
            libre |= getTablero().get(j).get(posJ);
        }
        return !libre;
    }

    private Boolean esDiagonalDrechaLibre(int posJ, int posI) {
        boolean libre = NO_REINA;
        int tamanyoDiagonal = NUMERO_CASILLAS - Math.abs((posI + 1) - (posJ + 1));
        int i, j;
        if (posI < posJ) {
            i = 0;
            j = posJ - posI;
        } else {
            i = posI - posJ;
            j = 0;
        }
        for (; ((i < tamanyoDiagonal) || (j < tamanyoDiagonal)) && !libre; j++, i++) {
            libre |= getTablero().get(i).get(j);
        }

        return !libre;
    }

    private Boolean esDiagonalIzquierdaLibre(int posI, int posJ) {
        boolean libre = NO_REINA;

        int i = posI;
        int j = posJ;
        for (; ((j < NUMERO_CASILLAS - 1) && (i > 0)) && !libre; i--, j++) {
        }
        for (; ((j >= 0) && (i < NUMERO_CASILLAS)) && !libre; i++, j--) {
            libre |= getTablero().get(i).get(j);
        }
        return !libre;
    }
    
    static boolean posicionValida(int x, int y)
    {
      if ( (x < 0) || (x > NUMERO_CASILLAS - 1))
        return false;
      if ( (y < 0) || (y > NUMERO_CASILLAS - 1))
        return false;
      return true;
    }
  
    
    private Boolean esMovimientoCaballoLibre(int posI, int posJ) {
        if (posicionValida(posI + 2, posJ + 1)) {
            if(getTablero().get(posI + 2).get( posJ + 1)) {
                if (posicionValida(posI + 4, posJ + 2)) {
                    if(getTablero().get(posI + 4).get( posJ + 2)) {
                        return false;
                    }
                }
            }
        }
        if (posicionValida(posI + 2, posJ - 1)) {
            if(getTablero().get(posI + 2).get( posJ - 1)) {
                if (posicionValida(posI + 4, posJ - 2)) {
                    if(getTablero().get(posI + 4).get( posJ - 2)) {
                        return false;
                    }
                }
            }
        }
        
        if (posicionValida(posI - 2, posJ + 1)) {
            if(getTablero().get(posI - 2).get( posJ + 1)) {
                if (posicionValida(posI - 4, posJ + 2)) {
                    if(getTablero().get(posI - 4).get( posJ + 2)) {
                        return false;
                    }
                }
                return false;
            }
        }
        if (posicionValida(posI - 2, posJ - 1)) {
            if(getTablero().get(posI - 2).get( posJ - 1)) {
                if (posicionValida(posI - 4, posJ - 2)) {
                    if(getTablero().get(posI - 4).get( posJ - 2)) {
                        return false;
                    }
                }
            }
        }
        if (posicionValida(posI + 1, posJ + 2)) {
            if(getTablero().get(posI + 1).get( posJ + 2)) {
                if (posicionValida(posI + 2, posJ + 4)) {
                    if(getTablero().get(posI + 2).get( posJ + 4)) {
                        return false;
                    }
                }
            }
        }
        if (posicionValida(posI + 1, posJ - 2)) {
            if(getTablero().get(posI + 1).get( posJ - 2)) {
                if (posicionValida(posI + 2, posJ - 4)) {
                    if(getTablero().get(posI + 2).get( posJ - 4)) {
                        return false;
                    }
                }
            }
        }
        if (posicionValida(posI - 1, posJ + 2)) {
            if(getTablero().get(posI - 1).get( posJ + 2)) {
                if (posicionValida(posI - 2, posJ + 4)) {
                    if(getTablero().get(posI - 2).get( posJ + 4)) {
                        return false;
                    }
                }
            }
        }
        if (posicionValida(posI - 1, posJ - 2)) {
            if(getTablero().get(posI - 1).get( posJ - 2)) {
                if (posicionValida(posI - 2, posJ - 4)) {
                    if(getTablero().get(posI - 2).get( posJ - 4)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean esPosicionNoAmenazada(int posI, int posJ) {
        boolean a = esColumnaLibre(posJ, posI) && esFilaLibre(posJ, posI) && esDiagonalIzquierdaLibre(posI, posJ)
                && esDiagonalDrechaLibre(posJ, posI)  && esMovimientoCaballoLibre(posI, posJ) ;
        return a;
    }

    public String toString() {
        String aux = "";
        for (int i = 0; i < getTablero().size(); i++) {
            ArrayList<Boolean> fila = getTablero().get(i);
            aux += "| ";
            for (int j = 0; j < fila.size(); j++) {
                if (fila.get(j)) {
                    aux += "R | ";
                } else {
                    aux += "  | ";
                }
            }
            aux += "\n";
        }
        return aux;
    }

    @Override
    public Solucion clone() {
        return new Solucion(this);
    }

    public boolean equals(Solucion obj) {
        boolean aux = true;
        if (obj.getCordenadasSolucion().size() != getCordenadasSolucion().size())
            return false;
        for (int i = 0; i < obj.getCordenadasSolucion().size(); i++) {
            aux &= obj.getCordenadasSolucion().get(i).equal(getCordenadasSolucion().get(i));
        }
        return aux;
    }

    /**
     * Getter. {@link Solucion#tablero}
     * 
     * @return Retorna tablero
     */
    ArrayList<ArrayList<Boolean>> getTablero() {
        return tablero;
    }

    /**
     * Getter. {@link Solucion#cordenadasSolucion}
     * 
     * @return Retorna cordenadasSolucion
     */
    public ArrayList<Par> getCordenadasSolucion() {
        return CordenadasSolucion;
    }

    /**
     * Getter. {@link solucion#solucionNotacionAlgebraica}
     * 
     * @return Retorna solucionNotacionAlgebraica
     */
    public NotacionAlgebraica getSolucionNotacionAlgebraica() {
        return solucionNotacionAlgebraica;
    }

}
