package Parcial3Poe24022021;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import static java.awt.Color.green;

public class VentanaPrincipalParcial extends JFrame implements ActionListener {
    PanelCanvasParcial3 jp_numeros,jp_Informe;
    PanelControlVentanaParcial3 jp_Panel_controles;
    PanelPrincipalParcial3 jp_principal;
    JButton btn_inicio, bn_sad, btn_siguente_pregunta, bn_sorprendido, Terminar, Limpiar;
    JTextField primer_num, segundo_num, resultado_num;
    TimerTask timerTask ;
    public VentanaPrincipalParcial(String title, int ancho, int alto, boolean bloqueo_ventana, boolean Visible_ventana,int tiempo) throws HeadlessException {
        super(title);
        setLayout(new BorderLayout(2, 2));
        setSize(ancho + 10, alto + 40);//ancho , alto
        setBackground(Color.GRAY);///color fondo
        setLocationRelativeTo(null);//centro de pantallla
        setResizable(bloqueo_ventana);//cambiar tamaño de pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jp_numeros = new PanelCanvasParcial3();
        jp_Informe = new PanelCanvasParcial3();
        jp_Panel_controles = new PanelControlVentanaParcial3("Control");
        components();

        jp_principal = new PanelPrincipalParcial3();
        PanelBorderLAyout();
        this.setVisible(Visible_ventana);
    }

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
        Terminar.setEnabled(false);
    }

    void JTextFieldsComponents() {
        Border bt_horas;
        bt_horas = BorderFactory.createLineBorder(green, 1);
//
        bt_horas = BorderFactory.createTitledBorder("Primer número");
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

    JLabel Calificacion;
    public void PanelBorderLAyout() {
         Calificacion = new JLabel("");
        //jp_principal.addJComponents(Calificacion);
        jp_principal.addJPanel(jp_Panel_controles.componente(), BorderLayout.PAGE_END);
        jp_principal.addJPanel(jp_numeros, BorderLayout.CENTER);
        //jp_principal.addJPanel(jp_Informe, BorderLayout.EAST);
                this.add(jp_principal);
      //  jp_Informe.AddComponentes(Calificacion);
        jp_Panel_controles.AddComponentes(Calificacion);
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
                if (resultado_num.getText()==""){
                    resultado_num.setText(""+0);
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