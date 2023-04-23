/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tematicas;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class FuncionesJuego {

    private String vocales = "AEIOUaeiou";
    private ArrayList<String> palabrasAdivinadas = new ArrayList<>();
    private DecimalFormat df = new DecimalFormat("#.#");
    private int fallos = 0;
    private int intentos = 0;
    private char letra;


    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getIntentos() {
        return intentos;
    }

    public int getFallos() {
        return fallos;
    }

    public int comprobarMensaje(String[] palabras, String letraButton, int palabrasAdivinadas){
        int message = 0;

        if (letra == letraButton.charAt(0)) {
            if (palabrasAdivinadas == palabras.length) {
                message = 2;

            } else {
                message = 1;
                intentos++;
            }
        } else {
            message = 3;
            fallos++;
            intentos++;
        }

        return message;
    }

    public String getPalabraSinVocal(String[] palabras){
        int palabraIndex = (int) (Math.random() * palabras.length);
        String nuevaPalabra = palabras[palabraIndex];
        int vocalFaltante = -1;
        while (vocalFaltante == -1) {
            int indice = (int) (Math.random() * nuevaPalabra.length());
            letra = nuevaPalabra.toLowerCase().charAt(indice);
            if (vocales.indexOf(letra) != -1) {
                vocalFaltante = indice;
            }
        }
        return getPalabraSinVocal(nuevaPalabra, vocalFaltante);
    }

    public boolean comprobarPalabra(String palabra){
        return palabrasAdivinadas.contains(palabra);
    }


    public String getPalabraSinVocal(String nuevaPalabra, int vocalFaltante){
        return nuevaPalabra.substring(0, vocalFaltante) + "_"
                + nuevaPalabra.substring(vocalFaltante + 1);
    }

    public String mostrarResultados(String nombre, int palabrasAdivinadas){
        StringBuilder sb = new StringBuilder();
        return mostrarResultados(nombre, palabrasAdivinadas, sb).toString();
    }

    private StringBuilder mostrarResultados(String nombre, int palabrasAdivinadas, StringBuilder sb){
        return sb.append("Resultados:\n")
                .append("Nombre: ").append(nombre).append("\n")
                .append("Intentos: ").append(intentos).append("\n")
                .append("Palabras adivinadas: ").append(palabrasAdivinadas).append(" - ").append((palabrasAdivinadas * 100) / 5).append("%").append("\n")
                .append("Fallos: ").append(fallos).append(" - ").append(df.format((double) (fallos * 100) / intentos)).append("%").append("\n");
    }

}

