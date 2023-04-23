/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicial extends JFrame implements ActionListener {

    private JTextField nombreJugador;
    private JLabel labelFondo;
    private JButton botonJugar, botonInstrucciones;
    private JFrame frame;
    private Jugador jugador = new Jugador();

    public VentanaInicial() {
        nombreJugador = new JTextField();
        labelFondo = new JLabel();
        botonJugar = new JButton();
        botonInstrucciones = new JButton();
        frame = new JFrame();
    }

    public void setupJuego() {
        // Configuración de la ventana
        frame.setTitle("JUEGO_LETRAS");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);



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
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        panel.add(etiquetaNombre);
        panel.add(nombreJugador);
        panel.add(botonJugar);
        panel.add(botonInstrucciones);


        // Crear la imagen de fondo
        ImageIcon imagenFondo = new ImageIcon("Mini_Proyecto_Fletras-master/src/Imagenes/Fondo.png");

        // Crear el JLabel para representar la imagen
        labelFondo = new JLabel(imagenFondo);
        labelFondo.setBounds(0, 0, 600, 500);
        panel.add(labelFondo);

        // Añadir el panel a la ventana
        frame.add(panel);

        // Añadir el listener a los botones
        botonJugar.addActionListener(this);
        botonInstrucciones.addActionListener(this);

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Acciones a realizar cuando se pulsa alguno de los botones
        if (e.getSource() == botonJugar) {
            jugador.setNombre(nombreJugador.getText());
            // Mostrar ventana con las temáticas
            this.dispose();
            new VentanaTemas(jugador);
        } else if (e.getSource() == botonInstrucciones) {
            // Código para mostrar las instrucciones
            JOptionPane.showMessageDialog(null, "Debes adivinar la vocal falante de una palabra aleatoria"
                    + "\n que saldra dependiendo de la tematica que escogiste. "
                    + "\n Nota: El juago solo termina cuando aciertes \n todas las palabras de la tematica"
                    + "\n BUENA SUERTE (.-.) ");
        }

    }


}

