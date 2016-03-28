package modelo;

import java.util.ArrayList;

public class NotacionAlgebraica {
    public static final String DAMA = "D";
    private ArrayList<Integer> numeros;
    private ArrayList<String> letras;
    
    public NotacionAlgebraica() {
        numeros = new ArrayList<Integer>();
        letras = new ArrayList<String>();
    }
    
    public  void nuevoValor(int numeroALetra, int numero) {
        numeros.add(++numero);
        String letra = numeroALetra(numeroALetra);
        letras.add(letra);
    }
    
    public  void quitarUltimoValor(int numeroALetra, int numero) {
        numeros.remove(numero);
        letras.remove(numeroALetra);
    }
    
    public void limpiar() {
        numeros.clear();
        letras.clear();
    }
    
    public String toString() {
        String aux = "";
        
        for (int i = 0; i < getLetras().size(); i++) {
            aux += DAMA + getLetras().get(i) + getNumeros().get(i);
            aux += i < (getLetras().size() - 1) ? ", "  : ".";
        }
        return aux;
    }
    
    private String numeroALetra(int numero) {
        String aux = "";
        switch (numero) {
        case 0:
            aux = "a";
        break;
        case 1:
            aux = "b";
        break;
        case 2:
            aux = "c";
        break;
        case 3:
            aux = "d";
        break;
        case 4:
            aux = "e";
        break;
        case 5:
            aux = "f";
        break;
        case 6:
            aux = "g";
        break;
        case 7:
            aux = "h";
        break;
        }
        return aux;
    }
    
    /**
     * Getter.  {@link NotacionAlgebraica#numeros}
     * @return Retorna numeros 
     */
    public ArrayList<Integer> getNumeros() {
        return numeros;
    }

    /**
     * Getter.  {@link NotacionAlgebraica#letras}
     * @return Retorna letras 
     */
    public ArrayList<String> getLetras() {
        return letras;
    }
}
