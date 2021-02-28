package Parcial3Poe24022021;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import static java.awt.Color.green;

public class VentanaPrincipalParcial extends JFrame implements ActionListener {
    PanelCanvasParcial3 jp_numeros;
    PanelControlVentanaParcial3 jp_Panel_controles,jp_informe;
    PanelPrincipalParcial3 jp_principal;
    Temporizador tempo;
    HoraActual fech;
    Cronometro cronos;
    Timer control_hilo_ejecucion;
    java.util.Timer timer;

    Thread   cronoshilo,tempohilo,relohilo,adelante_contarhilo,atras_contarhilo;
    JButton btn_inicio, bn_sad, btn_siguente_pregunta, bn_sorprendido, Terminar, Limpiar;
    JTextField primer_num, segundo_num, resultado_num;
    JLabel Calificacion;
    boolean bandera_llegada = false;
    public VentanaPrincipalParcial(String title, int ancho, int alto, boolean bloqueo_ventana, boolean Visible_ventana,int tiempo) throws HeadlessException {
        super(title);
        setLayout(new BorderLayout(2, 2));
        setSize(ancho + 10, alto + 40);//ancho , alto
        setBackground(Color.GRAY);///color fondo
        setLocationRelativeTo(null);//centro de pantallla
        setResizable(bloqueo_ventana);//cambiar tamaño de pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jp_numeros = new PanelCanvasParcial3();
        jp_informe = new PanelControlVentanaParcial3();
        jp_Panel_controles = new PanelControlVentanaParcial3("Control");
        components();
        jp_principal = new PanelPrincipalParcial3();
        PanelBorderLAyout();
        this.setVisible(Visible_ventana);
        control_hilo_ejecucion = new Timer(10000, this);
        //control_hilo_ejecucion.setInitialDelay(velocidad_ejecucion * 7); //We pause animation twice per cycle
        //by restarting the timer
        control_hilo_ejecucion.setCoalesce(true);
        timer = new java.util.Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }
    TimerTask timerTask = new TimerTask()
    {
        /**
         * Método al que Timer llamará cada segundo. Se encarga de avisar
         * a los observadores de este modelo.
         */
        public void run()
        {
            if (bandera_llegada){
                cronos.setBandera_llegada(false);
                tempo.setBandera_llegada(false);
                fech.setBandera_llegada(false);
                System.out.println(" Entro time");
                System.out.println(" Entro time");
                System.out.println(" Entro time");
                System.out.println(" Entro time");
                System.out.println(" Entro time");
                timerTask.notify();
                try {
                    timerTask.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("No Entro time");
                System.out.println("No Entro time");
                System.out.println("No Entro time");
                System.out.println("No Entro time");
                System.out.println("No Entro time");
            }


        }
    };
    void components() {
        btn_inicio = new JButton("Iniciar");
        btn_inicio.addActionListener(this);
        jp_Panel_controles.AddComponentes(btn_inicio);

        btn_siguente_pregunta = new JButton("Siguente Pregunta");
        btn_siguente_pregunta.addActionListener(this);
        jp_Panel_controles.AddComponentes(btn_siguente_pregunta);
        btn_siguente_pregunta.setEnabled(false);
        Terminar = new JButton("Terminar");
        Terminar.addActionListener(this);
        jp_Panel_controles.AddComponentes(Terminar);
      //  jp_Panel_controles.AddComponentes(Calificacion);
        JTextFieldsComponents();
        JLabelComponents();
        Terminar.setEnabled(false);
    }

    void JTextFieldsComponents() {
        Border bt_horas;
        bt_horas = BorderFactory.createLineBorder(green, 1);
//
        bt_horas = BorderFactory.createTitledBorder(bt_horas,"Primer número");
        primer_num = new JTextField("");
        primer_num.setBorder(bt_horas);
        primer_num.setEditable(false);

        Border bt_minutos;
        bt_minutos = BorderFactory.createLineBorder(green, 1);

        bt_minutos = BorderFactory.createTitledBorder(bt_minutos,"Segundo número");
        segundo_num = new JTextField("");
        segundo_num.setBorder(bt_minutos);
        segundo_num.setEditable(false);

        Border bt_segundos;
        bt_segundos = BorderFactory.createLineBorder(green, 1);

        bt_segundos = BorderFactory.createTitledBorder(bt_segundos,"Resultado");
        resultado_num = new JTextField("");
        resultado_num.setBounds(50,50,300,100);
        resultado_num.setBorder(bt_segundos);
        resultado_num.setEditable(false);
    }
void JLabelComponents(){
    Border bt_horas_actual;
    bt_horas_actual = BorderFactory.createLineBorder(green, 1);
    bt_horas_actual = BorderFactory.createTitledBorder(bt_horas_actual,"Hora");

    fech=new HoraActual();
    fech.setBorder(bt_horas_actual);
    relohilo=new Thread(fech);

    Border bt_cronometro;
    bt_cronometro = BorderFactory.createLineBorder(green, 1);
    bt_cronometro = BorderFactory.createTitledBorder(bt_cronometro,"Cronometro");
    cronos=new Cronometro();
    cronos.setBorder(bt_cronometro);
    cronoshilo=new Thread(cronos);

    Border bt_temporizador;
    bt_temporizador = BorderFactory.createLineBorder(green, 1);
    bt_temporizador = BorderFactory.createTitledBorder(bt_temporizador,"Temporizador");
    tempo=new Temporizador(0,1,6);
    tempo.setBorder(bt_temporizador);
    tempohilo=new Thread(tempo);
    //fecha_JLabel = new JLabel(""+fech.Fecha());
   // hora_JLabel = new JLabel(" "+fech.hora());

    Calificacion = new JLabel("0.0");
    Border bt_calificacion;
    bt_calificacion = BorderFactory.createLineBorder(green, 1);
    bt_calificacion = BorderFactory.createTitledBorder(bt_calificacion,"Calificación");
    Calificacion.setBorder(bt_calificacion);
    Calificacion.setPreferredSize(new Dimension(130, 40));
    Calificacion.setHorizontalAlignment((SwingConstants.CENTER));
}

    public void PanelBorderLAyout() {

        //jp_principal.addJComponents(Calificacion);
        jp_principal.addJPanel(jp_Panel_controles.componente(), BorderLayout.PAGE_END);
        jp_principal.addJPanel(jp_numeros, BorderLayout.CENTER);
        jp_principal.add(jp_informe.componente(),
                BorderLayout.PAGE_START);
                this.add(jp_principal);




        jp_informe.AddComponentes(fech);
        jp_informe.AddComponentes(tempo);
       jp_informe.AddComponentes(Calificacion);
        jp_informe.AddComponentes(cronos);

        jp_numeros.AddComponentes(primer_num);
       jp_numeros.AddComponentes(segundo_num);
        jp_numeros.AddComponentes(resultado_num );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_inicio) {
            primer_num.setText(""+(1+(int)(Math.random() * 100)));
         segundo_num.setText(""+(1+(int)(Math.random() * 100)));
            btn_inicio.setEnabled(false);
            resultado_num.setEditable(true);
            btn_siguente_pregunta.setEnabled(true);
            relohilo.start();
            cronoshilo.start();
            tempohilo.start();
        } else  if (e.getSource() == btn_siguente_pregunta) {
            btn_siguente_pregunta.setEnabled(false);
            Terminar.setEnabled(true);
            if (resultado_num.getText()==""){
                resultado_num.setText(""+0);
            }
            try {
                if ((Integer.parseInt(primer_num.getText())+Integer.parseInt(segundo_num.getText()))==Integer.parseInt(resultado_num.getText()))
                {
                    System.out.println(Integer.parseInt(primer_num.getText())+Integer.parseInt(segundo_num.getText()));
                    System.out.println("correcto");
                    Calificacion.setText(""+2.5);
                }else {
                    System.out.println(Integer.parseInt(primer_num.getText())+Integer.parseInt(segundo_num.getText()));
                    System.out.println("Incorrecto, El valore real es: "+Integer.parseInt(primer_num.getText())+Integer.parseInt(segundo_num.getText()));
                    Calificacion.setText(""+0);
                }
            }catch (NumberFormatException e1)
            {
e1.getMessage();
            }
            primer_num.setText(""+(1+(int)(Math.random() * 100)));
            segundo_num.setText(""+(1+(int)(Math.random() * 100)));
            resultado_num.setText("");
        }else

            if (e.getSource() == Terminar) {
                primer_num.setVisible(false);
                segundo_num.setVisible(false);
                resultado_num.setVisible(false);
                jp_numeros.setBorder(null);

                jp_numeros.AddComponentes(Calificacion);
                relohilo.stop();
                cronoshilo.stop();
                tempohilo.stop();
                if (resultado_num.getText()==""){

                    relohilo.start();
                    cronoshilo.start();
                    tempohilo.start();
                }
                try {
                    if ((Integer.parseInt(primer_num.getText())+Integer.parseInt(segundo_num.getText()))==Integer.parseInt(resultado_num.getText()))
                    {
                        System.out.println(Integer.parseInt(primer_num.getText())+Integer.parseInt(segundo_num.getText()));
                        System.out.println("correcto");
                        Calificacion.setText(""+(Integer.parseInt(Calificacion.getText())+2.5));
                    }else {
                        System.out.println(Integer.parseInt(primer_num.getText())+Integer.parseInt(segundo_num.getText()));
                        System.out.println("Incorrecto, El valore real es: "+Integer.parseInt(primer_num.getText())+Integer.parseInt(segundo_num.getText()));
                        Calificacion.setText(""+0);
                    }
                }catch (NumberFormatException e2)
                {
                    e2.getMessage();
                }

            primer_num.setText(""+(1+(int)(Math.random() * 100)));
            segundo_num.setText(""+(1+(int)(Math.random() * 100)));
            resultado_num.setText("");
    }
    }
}