
package Logica;

import Tematicas.Animales;
import Tematicas.Colores;
import Tematicas.Frutas;
import Tematicas.Instrumentos;

import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author leandp
 * @author ivan
 */

public class VentanaTemas extends JFrame implements ActionListener {

    private JButton botonAnimales, botonFrutas, botonColores, botonInstrumentos;
    private JLabel etiquetaResultado;
    private JLabel labelFondo;
    private Jugador jugador;

    public VentanaTemas(Jugador j) {
        jugador = j;
        // Configuración de la ventana
        setTitle("SELECCIONA UNA TEMATICA");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Creación de los componentes
        botonAnimales = new JButton("ANIMALES");
        botonAnimales.setBounds(200,100, 150,35);
        botonAnimales.setForeground(Color.white); 
        botonAnimales.setFont(new Font("arial", Font.BOLD, 12));
        botonAnimales.setOpaque(true);
        botonAnimales.setBackground(Color.black);
        botonAnimales.setHorizontalAlignment(JTextField.CENTER);
 
        
        botonFrutas = new JButton("FRUTAS");
        botonFrutas.setBounds(200,200, 150,35);
        botonFrutas.setForeground(Color.white); 
        botonFrutas.setFont(new Font("arial", Font.BOLD, 12));
        botonFrutas.setOpaque(true);
        botonFrutas.setBackground(Color.black);
        botonFrutas.setHorizontalAlignment(JTextField.CENTER);

        
        botonColores = new JButton("COLORES");
        botonColores.setBounds(200,300, 150,35);
        botonColores.setForeground(Color.white); 
        botonColores.setFont(new Font("arial", Font.BOLD, 12));
        botonColores.setOpaque(true);
        botonColores.setBackground(Color.black);
        botonColores.setHorizontalAlignment(JTextField.CENTER);

        
        botonInstrumentos = new JButton("INSTRUMENTOS");
        botonInstrumentos.setBounds(200,400, 150,35);
        botonInstrumentos.setForeground(Color.white); 
        botonInstrumentos.setFont(new Font("arial", Font.BOLD, 12));
        botonInstrumentos.setOpaque(true);
        botonInstrumentos.setBackground(Color.black);
        botonInstrumentos.setHorizontalAlignment(JTextField.CENTER);
                
        etiquetaResultado = new JLabel("");

        // Configuración del panel
        JPanel panel = new JPanel();
       // panel.setLayout(new GridLayout(5, 1));
        this.getContentPane().add(panel);
        panel.setLayout(null);
        panel.add(botonAnimales);
        panel.add(botonFrutas);
        panel.add(botonColores);
        panel.add(botonInstrumentos);
        panel.add(etiquetaResultado);

        // Añadir el panel a la ventana
        add(panel);
        
        // Crear la imagen de fondo
        ImageIcon imagenFondo = new ImageIcon("src/Imagenes/Fondo.png");
        
        // Crear el JLabel para representar la imagen
        labelFondo = new JLabel(imagenFondo);
        labelFondo.setBounds(0, 0, 600, 500);
        panel.add(labelFondo);

        // Añadir el listener a los botones
        botonAnimales.addActionListener(this);
        botonFrutas.addActionListener(this);
        botonColores.addActionListener(this);
        botonInstrumentos.addActionListener(this);

        // Hacer visible la ventana
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Acciones a realizar cuando se pulsa alguno de los botones
        if (e.getSource() == botonAnimales) {
        // Abrir la ventana de animales
            Animales ventanaAnimales = new Animales(jugador);
            this.dispose();
        } else if (e.getSource() == botonFrutas) {
        // Abrir la ventana de frutas
            Frutas ventanaFrutas = new Frutas(jugador);
            this.dispose();
        } else if (e.getSource() == botonColores) {
        // Abrir la ventana de colores
            Colores ventanaColores = new Colores(jugador);
            this.dispose();
        } else if (e.getSource() == botonInstrumentos) {
            // Abrir la ventana de instrumentos
            Instrumentos ventanaInstrumentos = new Instrumentos(jugador);
            this.dispose();

        }
    }

}
