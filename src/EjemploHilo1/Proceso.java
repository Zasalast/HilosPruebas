package EjemploHilo1;

public class Proceso  implements Runnable {

    String mensaje;

    public Proceso(String msg) {
     //   super(msg);
    }

    public Proceso() {
    }

    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println(mensaje);
        }
        //System.out.println("Este proceso ha terminado:" + this.getName());
    }

    public void setMensaje(String msj) {
        this.mensaje = msj;
    }
}