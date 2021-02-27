package EjemploHilo2;

public class Ejemplo1 {
    public static void main(String a[]) {
        UnHilo t = new UnHilo();
        t.start();
        for (int i = 1; i <= 10; i++) {
            System.out.println("Proceso de siempre Principal:" + i);
        }

    }
}