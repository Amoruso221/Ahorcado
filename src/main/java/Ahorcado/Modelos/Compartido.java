package Ahorcado.Modelos;

import Ahorcado.BD.Consultas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Compartido {
    private String palabra;
    private Integer intentos;
    private char[] palabraX;
    private String abc = "abcdefghijklmnñopqrstuvwxyz";

    public Compartido(Integer intentos) {
        this.intentos = intentos;

        Consultas consulta = new Consultas();
        this.palabra = consulta.obtenerPalabra();
    }

    //inicializa el array donde se iran descubriendo las letras
    public void iniciaPalabraX(){
        palabraX = new char[palabra.length()];

        for (int x=0; x<palabra.length(); x++){
            palabraX[x] = '?';
        }
    }

    public char[] getPalabraX() {
        return palabraX;
    }

    public String getPalabra() {
        return palabra;
    }

    //recurso compartido
    public synchronized void get(String nombre){

        if (intentos > 0){
            char letra = getLetra();
            System.out.println(nombre + " elige la letra " + letra);
            verificaExistencia(letra);
            System.out.print(Arrays.toString(palabraX) + "\n\n");
            intentos--;
            determinaGanador(nombre);
            notify();
        } else {
            Thread.currentThread().interrupt();
        }
    }

    //Obtenemos una letra random del string ABC. Una vez seleccionada se elimina para que no se pueda volver a elegir
    private char getLetra(){
        //sellecionamos la letra random
        Random random = new Random();
        int index = random.nextInt(abc.length());
        char letra = abc.charAt(index);

        //eliminamos la letra seleccionada del string
        abc = abc.substring(0, index) + abc.substring(index + 1);

        return letra;
    }

    //chequea si existe la letra en la palabra, si existe la guarda en la/s posicion/es correspondiente/s en la variable palabraX
    private void verificaExistencia(char letra){

        int index = palabra.indexOf(letra);
        int cont = 0;

        if (index != -1){
            System.out.println("La letra existe !");
            while(index != -1){
                //guardamos la letra en el array en la posicion correspondiente
                palabraX[index] = letra;
                //volvemos a buscar la letra pero ahora la busqueda se inicia a partir de la siguiente posicion
                index = palabra.indexOf(letra,index+1);
                cont++;
            }
            System.out.printf("La letra se encontraba en %d posicion/es\n", cont);
        } else{
            System.out.println("La letra no existe en la palabra ..");
        }
    }

    //Si en el array palabraX quedan "?" significa que quedan caracteres por descubrir
    private void determinaGanador(String nombre){

        boolean valor = false;

        for (char c: palabraX){
            if ('?' == c){
                valor = true;
            }
        }

        if (!valor){
            System.out.printf("%s es el ganador !!\n", nombre);
            intentos = 0;

            Consultas consulta = new Consultas();
            consulta.guardarGanador(nombre,palabra);
            System.out.println("Datos guardados en la base de datos ..");

            Thread.currentThread().interrupt();
        }

    }
}
