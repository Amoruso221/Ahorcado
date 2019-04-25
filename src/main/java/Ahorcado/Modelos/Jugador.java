package Ahorcado.Modelos;

public class Jugador extends Thread{
    private String nombre;
    private final Compartido compartido;

    public Jugador(String nombre, Compartido compartido) {
        this.nombre = nombre;
        this.compartido = compartido;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            compartido.get(nombre);
        }
    }
}
