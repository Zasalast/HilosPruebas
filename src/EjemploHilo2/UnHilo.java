package EjemploHilo2;

public class UnHilo extends Thread {

    public synchronized void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Hilo: " + i);
        }

    }
}