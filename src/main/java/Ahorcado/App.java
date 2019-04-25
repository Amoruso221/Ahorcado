package Ahorcado;

import Ahorcado.BD.Consultas;
import Ahorcado.Modelos.Compartido;
import Ahorcado.Modelos.Jugador;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //damos la posibilidad de setear la cantidad de intentos totales
        System.out.println("Ingrese la cantida de intentos:");
        Scanner scanner = new Scanner(System. in);
        int intentos = scanner. nextInt();

        //creamos el recurso compartido
        Compartido rcompartido = new Compartido(intentos);
        rcompartido.iniciaPalabraX(); //lo usamos para mostrar la misma cantidad de ? que de letras a adivinar

        System.out.println("La palabra tiene " + rcompartido.getPalabra().length() + " letras");
        System.out.print(Arrays.toString(rcompartido.getPalabraX()) + "\n\n");

        Jugador jugador1 = new Jugador("Jugador1",rcompartido);
        Jugador jugador2 = new Jugador("Jugador2",rcompartido);

        jugador1.start();
        jugador2.start();
    }
}
