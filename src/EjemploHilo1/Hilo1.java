package EjemploHilo1;

public class Hilo1 {
    public static void main(String[] args) {
        Proceso hilo1 = new Proceso("Hilo 1");
        Proceso hilo2 = new Proceso("Hilo 2");
        Thread h1=new Thread(hilo1);
        Thread h2=new Thread(hilo2);
        hilo1.setMensaje("Este es el mensaje del hilo 1");
        hilo2.setMensaje("Mensaje hilo 2");

        h1.start();
        h2.start();
    }

}