package vista;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import controlador.Par;

public class Interfaz  extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contenedor = new JPanel();
    private CuadroInferior cuadroInferior;
    private CuadroSuperior cuadroSuperior;
    private Tablero tablero;
    private boolean unaSolucion;

    public Interfaz(String tituloVentana, int tInicial){
        super(tituloVentana);
        cuadroInferior = new CuadroInferior();
        cuadroSuperior = new CuadroSuperior();
        tablero = new Tablero(tInicial);
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));
        contenedor.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));   
        contenedor.add(cuadroSuperior);     
        contenedor.add(tablero);
        contenedor.add(cuadroInferior);
        inicializar();
     }
    
    public void pintar(ArrayList<Par> solucionARepresentar, int numeroSolucion,  int numeroReinas, String solucionAlgebraica) {
        cuadroSuperior.pintar("" + numeroSolucion);
        tablero.pintarSolucionTablero(solucionARepresentar);
        cuadroInferior.pintar(solucionAlgebraica);
        repaint();
    }
    
    public void inicializar() {
        hacerVisible();
    }
    
    void hacerVisible() {
         this.add(contenedor);
         this.setPreferredSize(new Dimension(700, 700));
         this.pack();
         this.setVisible(true);
         this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     }
    
    public void disparadorDeAccionNuevaSolucion(ActionListener evento) {
        getCuadroInferior().botonSolucion.addActionListener(evento);
    }
     
    /**
     * Getter.  {@link Interfaz#cuadroInferior}
     * @return Retorna cuadroInferior 
     */
    public CuadroInferior getCuadroInferior() {
        return cuadroInferior;
    }
    
}
