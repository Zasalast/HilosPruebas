package EjemploHilo3;

public class Hilo12 {
    public static void main(String args[]) {
        Proceso12 t1;
        Proceso13 t2;

        t1 = new Proceso12("Thread 1");
        t2 = new Proceso13("Hilito      2");

        t1.start();
        t2.start();

    }
}
