package Parcial3Poe24022021;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaSeleccionarNivel extends JFrame implements ActionListener {

    PanelControlVentanaParcial3 jp_Panel_controles;
    PanelPrincipalParcial3 jp_principal;
    JButton nivel1, bn_sad, nivel2, bn_sorprendido, nivel3, Limpiar;

    public VentanaSeleccionarNivel(String title, int ancho, int alto, boolean bloqueo_ventana, boolean Visible_ventana) throws HeadlessException {
        super(title);
        setLayout(new BorderLayout(2, 2));
        setSize(ancho + 10, alto + 40);//ancho , alto
        setBackground(Color.GRAY);///color fondo
        setLocationRelativeTo(null);//centro de pantallla
        setResizable(bloqueo_ventana);//cambiar tamaño de pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       jp_Panel_controles = new PanelControlVentanaParcial3("Seleccione el nivel");
        components();
        jp_principal = new PanelPrincipalParcial3();
        PanelBorderLAyout();
        this.setVisible(Visible_ventana);
    }

    void components() {
        nivel1 = new JButton("Nivel1");
        nivel1.addActionListener(this);
        jp_Panel_controles.AddComponentes(nivel1);

        nivel2 = new JButton("Nivel 2");
        nivel2.addActionListener(this);
        jp_Panel_controles.AddComponentes(nivel2);

        nivel3 = new JButton("Nivel 3");
        nivel3.addActionListener(this);
        jp_Panel_controles.AddComponentes(nivel3);
    }
    public void PanelBorderLAyout() {
        jp_principal.addJPanel(jp_Panel_controles.componente(), BorderLayout.PAGE_START);
               this.add(jp_principal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nivel1) {
            VentanaPrincipalParcial v1 = new VentanaPrincipalParcial("Parcial 3", 600, 200, false, true,120000);
               }else
        if (e.getSource() == nivel1) {
            VentanaPrincipalParcial v1 = new VentanaPrincipalParcial("Parcial 3", 600, 200, false, true,60000);
                  }else
        if (e.getSource() == nivel1) {
            VentanaPrincipalParcial v1 = new VentanaPrincipalParcial("Parcial 3", 600, 200, false, true,30000);

        }this.setVisible(false);
    }
}