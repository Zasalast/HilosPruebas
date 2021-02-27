package RelojModeloUtil;

import javax.swing.JLabel;
import java.util.Observer;
import java.util.Observable;
import java.util.Date;
import java.awt.Dimension;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;
import java.text.SimpleDateFormat;
public class RelojVisual extends JLabel implements Runnable
{
    public RelojVisual()
    {
        // La fecha/hora se pinta en el centro de este JLabel
        this.setHorizontalAlignment((SwingConstants.CENTER));

        // Se da una dimension al JLabel.
        this.setPreferredSize(new Dimension (200, 140));
    }

    SimpleDateFormat format = new SimpleDateFormat ("hh:mm:ss");//dd/MM/yyyy

    @Override
    public void run() {
            while (true){
            this.setText("" + format.format(new Date()));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}