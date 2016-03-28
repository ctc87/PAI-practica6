package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controlador.Par;

public class Tablero extends JPanel {
    /**
     * 
     */
    private static final int CARACTER_INICIAL = 97;
    private static final long serialVersionUID = 1L;
    private int numeroReinas;
    private ImageIcon queen = new ImageIcon("./queen.png");
    int iteracionSoluciones = 0;
    JPanel panel[][];
//    JLabel
    public Tablero(int tInicia) {
        super();
        inicializar(tInicia);
    }

    public void inicializar(int tamanyo) {
        panel = new JPanel[tamanyo + 1][tamanyo + 1];
        numeroReinas = tamanyo;
        this.setLayout(new GridLayout(numeroReinas + 1, numeroReinas + 1, 0, 0));
        this.setPreferredSize(new Dimension(1000, 1000));
        int letraInt = CARACTER_INICIAL;
        JLabel letra;
        for (int i = 0; i <= numeroReinas; i++) {
            for (int j = 0; j <= numeroReinas; j++) {
                panel[i][j] = new JPanel(true);
                if (i != 0 && j != 0) {
                    if ((j + i) % 2 == 0) {
                        panel[i][j].setBackground(Color.BLACK);
                    } else {
                        panel[i][j].setBackground(Color.WHITE);
                    }
                } else {
                    if (i > 0) {
                        letra = new JLabel(Character.toString((char) letraInt));
                        panel[i][j].add(letra);
                        letraInt++;
                    } else if (j > 0) {
                        letra = new JLabel("" + j);
                        panel[i][j].add(letra);
                    }
                }
                panel[i][j].setPreferredSize(new Dimension(50, 50));
                this.add(panel[i][j]);
            }
        }
    }

    public void pintarSolucionTablero(ArrayList<Par> solucion) {
        iteracionSoluciones = 0;
        for (int i = 1; i < panel.length; i++) {
            for (int j = 1; j < panel[i].length; j++) {
                panel[i][j].removeAll();
            }
        }
        
        for (int i = 0; i < panel.length; i++) {
            for (int j = 0; j < panel[i].length; j++) {
                int posISol = solucion.get(iteracionSoluciones).getFirst();
                int posJSol = solucion.get(iteracionSoluciones).getSecond();
                if((i == posISol + 1) && (j == posJSol + 1 )) {
                    JLabel labelQueen = new JLabel(queen);
                    labelQueen.setPreferredSize(new Dimension(50,50));
                    panel[i][j].add(labelQueen);
                    if(iteracionSoluciones < numeroReinas - 1) {
                        iteracionSoluciones++;
                    }
                }
            }
        }
    }
}
