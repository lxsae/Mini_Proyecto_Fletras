package Logica;

import javax.swing.*;
import java.awt.*;
import static java.awt.BorderLayout.CENTER;
import java.awt.event.*;

/**
 * @author leandp
 * @author ivan
 */


public class Juego {
    public static JTextField nombreJugador;
    public static JLabel labelFondo;
    private static JButton botonJugar, botonInstrucciones;
    private static final JFrame frame = new JFrame();
    private static VentanaInicial ventanaInicial = new VentanaInicial();


    public static void main(String[] args) {
        ventanaInicial.setupJuego();
    }


}
