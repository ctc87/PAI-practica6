package vista;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CuadroInferior extends JPanel {

    /**
     * 
     */
    boolean botonActivado = false;
    JButton botonSolucion = new JButton("Iniciar"); 
    private JLabel etiquetaSolucion = new JLabel("Pulsa para iniciar las soluciones");
    private static final long serialVersionUID = 1L;
    CuadroInferior() {
        super();
        inicializar();
    }
    public void pintar(String solucionAlgebraica) {
        etiquetaSolucion.setText(solucionAlgebraica);
        if(!botonActivado) {
            botonSolucion.setText("Siguiente Solución");
        }
    }
    
    public void inicializar() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        etiquetaSolucion.setBorder(BorderFactory.createEmptyBorder(0,50,0,50));
        add(etiquetaSolucion);
        add(botonSolucion);
    }
}
