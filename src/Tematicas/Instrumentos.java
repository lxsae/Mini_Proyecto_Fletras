
package Tematicas;
import Logica.Juego;
import Logica.Jugador;
import Logica.VentanaTemas;

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

public class Instrumentos extends JFrame {

    private String[] instrumentos = {"Guitarra", "Bajo", "Bateria", "Violin", "Piano"};
    private List<Character> vocales = Arrays.asList('a', 'e', 'i', 'o', 'u');
    private JButton[] vowelButtons = new JButton[5];
    private FuncionesJuego fj = new FuncionesJuego();
    private JLabel labelFondo;
    private Jugador j;
    private char letra;
    private int palabrasAdivinadas = 0;

    public Instrumentos(Jugador j) {
        super("Jugador: " + j.getNombre().substring(0,1).toUpperCase() + j.getNombre().substring(1).toLowerCase() + " - Instrumentos");
        this.j = j;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Obtener el tamaño de la pantalla y centrar la ventana en ella
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = pantalla.width;
        int alto = pantalla.height;
        setSize(ancho / 3, alto / 3);
        setLocation(ancho / 3, alto / 3);


        JLabel etiquetaInstrumentos = new JLabel(fj.getPalabraSinVocal(instrumentos));
        etiquetaInstrumentos.setForeground(Color.red);
        etiquetaInstrumentos.setFont(new Font("arial", Font.BOLD, 50));
        etiquetaInstrumentos.setHorizontalAlignment(JTextField.CENTER);
        add(etiquetaInstrumentos);
        addVowelButtons();
        setVisible(true);
        
        // Configuración del panel
        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setLayout(null);
        
        ImageIcon imagenFondo = new ImageIcon("src/Imagenes/Instrumentos.png");
        
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
        JLabel etiquetaInstrumentos = (JLabel) getContentPane().getComponent(0);
        switch (fj.comprobarMensaje(instrumentos, letraButton, palabrasAdivinadas)){
            case 1 -> {
                JOptionPane.showMessageDialog( null, "¡Correcto!");
                palabrasAdivinadas++;
                etiquetaInstrumentos.setText(fj.getPalabraSinVocal(instrumentos));
            }
            case 2 -> {
                JOptionPane.showMessageDialog( null, "¡Felicidades! Has adivinado todas las palabras.");
                mostrarResultados();
                new VentanaTemas(j);
                dispose();
            }
            case 3 -> {
                JOptionPane.showMessageDialog( null, "¡Has fallado!");
                etiquetaInstrumentos.setText(fj.getPalabraSinVocal(instrumentos));
            }
        }
    }

    private void mostrarResultados() {
        JOptionPane.showMessageDialog(this, fj.mostrarResultados(j.getNombre(), palabrasAdivinadas));
        dispose();
    }
}
