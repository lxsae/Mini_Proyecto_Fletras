
package Tematicas;
import Logica.Jugador;
import Logica.VentanaTemas;
import Logica.Juego;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


/**
 * @author leandp
 * @author ivan
 */

public class Animales extends JFrame {

    private String[] animales = {"Leon", "Elefante", "Jirafa", "Cebra", "Hipopotamo"};
    private List<Character> vocales = Arrays.asList('a', 'e', 'i', 'o', 'u');
    private JButton[] vowelButtons = new JButton[5];
    public JLabel labelFondo;
    private JLabel etiquetaAnimal;
    private Jugador j;
    private FuncionesJuego fj = new FuncionesJuego();
    private char letra;
    private int palabrasAdivinadas = 0;


    public Animales(Jugador j) {
        super("Jugador: " + j.getNombre().substring(0,1).toUpperCase() + j.getNombre().substring(1).toLowerCase() + " - Animales");
        this.j = j;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Obtener el tamaño de la pantalla y centrar la ventana en ella
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = pantalla.width;
        int alto = pantalla.height;
        setSize(ancho / 3, alto / 3);
        setLocation(ancho / 3, alto / 3);

        etiquetaAnimal = new JLabel(fj.getPalabraSinVocal(animales));
        etiquetaAnimal.setForeground(Color.black); 
        etiquetaAnimal.setFont(new Font("arial", Font.BOLD, 50));
        etiquetaAnimal.setHorizontalAlignment(JTextField.CENTER);

        add(etiquetaAnimal);

        addVowelButtons();
        setVisible(true);
        

        // Configuración del panel
        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setLayout(null);

        //Check path
        ImageIcon imagenFondo = new ImageIcon("Mini_Proyecto_Fletras-master/src/Imagenes/Animales.png");
        
        // Crear el JLabel para representar la imagen
        labelFondo = new JLabel(imagenFondo);
        labelFondo.setBounds(0, 0, 600, 500);
        panel.add(labelFondo);
        add(panel);


    }

    private class VowelButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String letraButton = button.getText().toLowerCase();
            // Obtener la palabra actual del JLabel
            JLabel etiquetaAnimal = (JLabel) getContentPane().getComponent(0);
            String palabra = etiquetaAnimal.getText().replace("_", letraButton);
            // Actualizar el JLabel con la nueva palabra
            etiquetaAnimal.setText(palabra);
            // Comprobar si la letra es la vocal faltante
            comprobarVocalFaltante(letraButton);

        }
    }

    private void addVowelButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 5));

        for (int i = 0; i < vowelButtons.length; i++) {
            vowelButtons[i] = new JButton(String.valueOf(vocales.get(i)));
            vowelButtons[i].addActionListener(new VowelButtonListener());
            panel.add(vowelButtons[i]);
        }
        add(panel, BorderLayout.SOUTH);
    }


    private void comprobarVocalFaltante(String letraButton) {
        // Obtener la palabra actual del JLabel
        JLabel etiquetaAnimal = (JLabel) getContentPane().getComponent(0);
        switch (fj.comprobarMensaje(animales, letraButton, palabrasAdivinadas)){
            case 1 -> {
                JOptionPane.showMessageDialog( null, "¡Correcto!");
                palabrasAdivinadas++;
                etiquetaAnimal.setText(fj.getPalabraSinVocal(animales));
            }
            case 2 -> {
                JOptionPane.showMessageDialog( null, "¡Felicidades! Has adivinado todas las palabras.");
                mostrarResultados();
                new VentanaTemas(j);
                dispose();
            }
            case 3 -> {
                JOptionPane.showMessageDialog( null, "¡Has fallado!");
                etiquetaAnimal.setText(fj.getPalabraSinVocal(animales));
            }
        }
    }

    private void mostrarResultados() {
        JOptionPane.showMessageDialog(this, fj.mostrarResultados(j.getNombre(), palabrasAdivinadas));
        dispose();
    }
}
