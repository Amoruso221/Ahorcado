# Ahorcado
TP de Hilos

# Reglas del juego
Ambos jugadores empiezan a elegir letras (no se pueden repetir). El jugador que elige la ultima letra es el ganador de la misma forma que una persona podria no adivinar ninguna letra pero al final adivina la palabra.

# Teoria

## Diferencia entre Runnable y Thread
La primer diferencia es que para utilizar el primero debemos implementar la interfaz Runnable y para el segundo debemos extender de Thread.
Lae segunda diferencia es que para iniciar el hilo, con la interfaz runnable, debemos primero crear una instancia de Thread  luego pasarle una instancia de la clase que implementa runnable, mientras que la clase que extiende de Thread puede llamar directamente al metodo .start sin necesidad de crear una instancia de Thread.

## Ciclo de vida de un Thread
Un Thread puede presentar cuatro estados:

- Nuevo: El Thread ha sido creado pero no inicializado con el metodo .start. Se producira un mensaje de error si se intenta ejecutar cualquier metodo de la clase Thread distinto a .start.
- Ejecutable: El Thread puede estar ejecutandose, siempre y cuando se le haya asignado tiempo de cpu. En la practica puede no estar siendo ejecutado en un instante en beneficio de otro Thread
- Bloqueado: El thread podria estar ejecutandose, pero hay alguna actividad interna suya que lo impide, como por ejemplo, una espera producida por una operacion de escritura o lectura  de datos por teclado. Si un thread esta en este estado no se le asigna tiempo de cpu
- Muerto: La forma habitual de que un thread muera es finalizando el metodo run(). Tambien puede llamarse al metodo stop() de la clase Thread, aunque dicho metodo es considerado peligoroso y no se debe utilizar.

## Metodos

- start(): usado para iniciar el cuerpo de la thread definido por el método run().
- sleep(): pone a dormir una thread por un  tiempo mínimo especificado.
- join(): usado para esperar por el término de la thread sobre la cual el método es invoacado, por ejemplo por término de método run().
- yield(): Mueve a la thread desde el estado de corriendo al final de la cola de procesos en espera por la CPU.


