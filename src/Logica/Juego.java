package Logica;

import javax.swing.*;
import java.awt.*;
import static java.awt.BorderLayout.CENTER;
import java.awt.event.*;

/**
 * @author leandp
 * @author ivan
 */


public class Juego extends JFrame implements ActionListener {
    public JTextField nombreJugador;
    public JLabel labelFondo;
    private JButton botonJugar, botonInstrucciones;
    
    
    public  Juego() {
        // Configuración de la ventana
        setTitle("JUEGO_LETRAS");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        

        // Creación de los componentes
        JLabel etiquetaNombre = new JLabel("INGRESA TU NOMBRE");
        etiquetaNombre.setBounds(200,100, 150,35);
        etiquetaNombre.setForeground(Color.white); 
        etiquetaNombre.setFont(new Font("arial", Font.BOLD, 12));
        etiquetaNombre.setOpaque(true);
        etiquetaNombre.setBackground(Color.black);
        etiquetaNombre.setHorizontalAlignment(JTextField.CENTER);
        
        
        nombreJugador = new JTextField(20);
        nombreJugador.setBounds(200,200,150, 35);
        nombreJugador.setHorizontalAlignment(JTextField.CENTER);
        nombreJugador.setForeground(Color.black); 
        nombreJugador.setFont(new Font("arial", Font.BOLD, 12));
        nombreJugador.setOpaque(true);
        nombreJugador.setBackground(Color.white);
        nombreJugador.setHorizontalAlignment(JTextField.CENTER);
        
        
        botonJugar = new JButton("PLAY");
        botonJugar.setBounds(200,300,150, 35);
        botonJugar.setForeground(Color.black); 
        botonJugar.setFont(new Font("arial", Font.BOLD, 12));
        botonJugar.setOpaque(true);
        botonJugar.setBackground(Color.green);
        botonJugar.setHorizontalAlignment(JTextField.CENTER);
        
        
        botonInstrucciones = new JButton("INSTRUCCIONES");
        botonInstrucciones.setBounds(200,400, 150,35);
        botonInstrucciones.setForeground(Color.black); 
        botonInstrucciones.setFont(new Font("arial", Font.BOLD, 12));
        botonInstrucciones.setOpaque(true);
        botonInstrucciones.setBackground(Color.yellow);
        botonInstrucciones.setHorizontalAlignment(JTextField.CENTER);
        
        
        // Configuración del panel
        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setLayout(null);
        panel.add(etiquetaNombre);
        panel.add(nombreJugador);
        panel.add(botonJugar);
        panel.add(botonInstrucciones);

        
        // Crear la imagen de fondo
        ImageIcon imagenFondo = new ImageIcon("src/Imagenes/Fondo.png");
        
        // Crear el JLabel para representar la imagen
        labelFondo = new JLabel(imagenFondo);
        labelFondo.setBounds(0, 0, 600, 500);
        panel.add(labelFondo);
        
        // Añadir el panel a la ventana
        add(panel);

        // Añadir el listener a los botones
        botonJugar.addActionListener(this);
        botonInstrucciones.addActionListener(this);

        // Hacer visible la ventana
        setVisible(true);
    }
    


    public void actionPerformed(ActionEvent e) {
        // Acciones a realizar cuando se pulsa alguno de los botones
        if (e.getSource() == botonJugar) {
            String nombre = nombreJugador.getText();
            // Mostrar ventana con las temáticas
            this.dispose();
            new VentanaTemas();
        } else if (e.getSource() == botonInstrucciones) {
            // Código para mostrar las instrucciones
            JOptionPane.showMessageDialog(null, "Debes adivinar la vocal falante de una palabra aleatoria"
                    + "\n que saldra dependiendo de la tematica que escogiste. "
                    + "\n Nota: El juago solo termina cuando aceirtes \n todas las palabras de la tematica"
                    + "\n BUENA SUERTE (.-.) ");
        }
 
    }

    public static void main(String[] args) {
        // Crear una instancia de la clase Juego
        new Juego();
    }
}
