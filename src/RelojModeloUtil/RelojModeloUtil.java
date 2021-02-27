package RelojModeloUtil;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
public class RelojModeloUtil implements Runnable/*extends Observable*/
{
    /**
     * Lanza un timer cada segundo.
     */
    public RelojModeloUtil()
    {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    /**
     * main de prueba de esta clase.
     * No necesita una ventana para funcionar.
     */
    public static void main (String [] args)
    {
        RelojModeloUtil modelo = new RelojModeloUtil();
        System.out.println("hola");modelo.timerTask.run();



    }

    /**
     * Clase que se mete en Timer, para que se le avise cada segundo.
     */
    TimerTask timerTask = new TimerTask()
    {
        /**
         * Método al que Timer llamará cada segundo. Se encarga de avisar
         * a los observadores de este modelo.
         */
        public void run()
        {
            System.out.println (new Date());
        }
    };

    @Override
    public void run() {
       // System.out.println (new Date());
    }
}
