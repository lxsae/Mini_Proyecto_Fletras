
package Tematicas;
import Logica.VentanaTemas;
import Logica.Juego;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

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
    private char letra;
    private int palabrasAdivinadas = 0;
    private int fallos = 0;
    private int intentos = 0;
    private int numPalabras = 0;
    public JLabel labelFondo;
    
    public Animales() {
        super("Animales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Obtener el tamaño de la pantalla y centrar la ventana en ella
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = pantalla.width;
        int alto = pantalla.height;
        setSize(ancho / 3, alto / 3);
        setLocation(ancho / 3, alto / 3);
        

        // Elegir una palabra aleatoria del array de animales
        int palabraIndex = (int) (Math.random() * animales.length);
        String palabra = animales[palabraIndex];
        String vocales = "AEIOUaeiou";

        int vocalFaltante = -1;
        while (vocalFaltante == -1) {
            int indice = (int) (Math.random() * palabra.length());
            letra = palabra.charAt(indice);
            if (vocales.indexOf(letra) != -1) {
                vocalFaltante = indice;

            }
        }

        String palabraSinVocal = palabra.substring(0, vocalFaltante) + "_"
                + palabra.substring(vocalFaltante + 1); 
        JLabel etiquetaAnimal = new JLabel(palabraSinVocal);
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
        
        ImageIcon imagenFondo = new ImageIcon("src/Imagenes/Animales.png");
        
        // Crear el JLabel para representar la imagen
        labelFondo = new JLabel(imagenFondo);
        labelFondo.setBounds(0, 0, 600, 500);
        panel.add(labelFondo);
        add(panel);


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

    private void comprobarVocalFaltante(String letraButton) {
        // Obtener la palabra actual del JLabel
        JLabel etiquetaAnimal = (JLabel) getContentPane().getComponent(0);
        // Obtener la vocal faltante de la palabra
        if (letra == letraButton.charAt(0)) {
            JOptionPane.showMessageDialog(null, "¡Correcto!");
            // Incrementar el contador de palabras adivinadas
            palabrasAdivinadas++;
            intentos++;
            // Verificar si se han adivinado todas las palabras
            if (palabrasAdivinadas == animales.length) {
                JOptionPane.showMessageDialog(null, "¡Felicidades! Has adivinado todas las palabras.");
                mostrarResultados();
                new VentanaTemas();
                dispose();
            } else {
                // Elegir una nueva palabra aleatoria del array de animales
                int palabraIndex = (int) (Math.random() * animales.length);
                String nuevaPalabra = animales[palabraIndex];
                // Encontrar la nueva vocal faltante
                int vocalFaltante = -1;
                while (vocalFaltante == -1) {
                    int indice = (int) (Math.random() * nuevaPalabra.length());
                    letra = nuevaPalabra.charAt(indice);
                    if (vocales.indexOf(letra) != -1) {
                        vocalFaltante = indice;
                    }
                }
                // Mostrar la nueva palabra con la vocal faltante
                String nuevaPalabraSinVocal = nuevaPalabra.substring(0, vocalFaltante) + "_"
                        + nuevaPalabra.substring(vocalFaltante + 1);
                etiquetaAnimal.setText(nuevaPalabraSinVocal);
            }
        } else {
            fallos++;
            intentos++;
            JOptionPane.showMessageDialog(null, "Incorrecto. Sigue intentando.");
            // Elegir una nueva palabra aleatoria del array de animales
            int palabraIndex = (int) (Math.random() * animales.length);
            String nuevaPalabra = animales[palabraIndex];
            // Encontrar la nueva vocal faltante
            int vocalFaltante = -1;
            while (vocalFaltante == -1) {
                int indice = (int) (Math.random() * nuevaPalabra.length());
                letra = nuevaPalabra.charAt(indice);
                if (vocales.indexOf(letra) != -1) {
                    vocalFaltante = indice;
                }
            }
            // Mostrar la nueva palabra con la vocal faltante
            String nuevaPalabraSinVocal = nuevaPalabra.substring(0, vocalFaltante) + "_"
                    + nuevaPalabra.substring(vocalFaltante + 1);
            etiquetaAnimal.setText(nuevaPalabraSinVocal);
        }
    }

    private void mostrarResultados() {
        JOptionPane.showMessageDialog(this, "Resultados:\n"
                + "Jugador: "  + "\n"
                + "Numero de palabras: " + intentos + "\n"
                + "Intentos: " + intentos + "\n"
                + "Aciertos: " + palabrasAdivinadas + "\n"
                + "Fallos: " + fallos);
        dispose();
    }
}
