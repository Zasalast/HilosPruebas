package RelojModeloUtil;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class AppletRelojUtil extends JFrame
{
   // RelojModeloUtil modelo= new RelojModeloUtil();
    RelojVisual visual;
    JApplet a;
    Thread hiloReloi;
    public AppletRelojUtil() throws HeadlessException {
        setLayout(new BorderLayout(10, 10));
        setSize(200 + 10, 100 + 40);//ancho , alto
        setBackground(Color.GRAY);///color fondo
        setLocationRelativeTo(null);//centro de pantallla
        setResizable(false);//cambiar tamaño de pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        a=new JApplet();
        this.add(a);
        visual = new RelojVisual();
        hiloReloi=new Thread(visual);
        a.add(visual);
        hiloReloi.start();
        this.setVisible(true);
    }
}
