    package vista;

    import java.awt.FlowLayout;
    import javax.swing.BorderFactory;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
public class CuadroSuperior extends JPanel{
    private JLabel etiquetaSolucion = new JLabel("Problema de las reinas");
    private static final long serialVersionUID = 1L;

    CuadroSuperior() {
        super();
        inicializar();
    }

    public void pintar(String numeroSolucion) {
        etiquetaSolucion.setText("Solución número: " + numeroSolucion);
    }

    public void inicializar() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        etiquetaSolucion.setBorder(BorderFactory.createEmptyBorder(0,50,0,50));
        add(etiquetaSolucion);
    }
}
