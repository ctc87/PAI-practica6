package controlador;

public class Par {
    int first, second;

    public boolean equal(Par second) {
        return ((this.first == second.first) && (this.second == second.second));
    }

    public Par(int first, int second) {
        this.first = first;
        this.second = second;
    }
    
    public String toString() {
        return "(" + getFirst() + ", " + getSecond() + ")";
    }

    /**
     * Getter.  {@link Par#first}
     * @return Retorna first 
     */
    public int getFirst() {
        return first;
    }

    /**
     * Getter.  {@link Par#second}
     * @return Retorna second 
     */
    public int getSecond() {
        return second;
    }
}
