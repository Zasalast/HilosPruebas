package Parcial3Poe24022021;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PanelControlVentanaParcial3 extends JPanel {
    String nombre_panel="";

    public PanelControlVentanaParcial3(String nombre_panel) {
        this.nombre_panel = nombre_panel;
    }

    public PanelControlVentanaParcial3() {
    }

    public  JPanel componente(){
        Border jp_b_Controles;
        jp_b_Controles = BorderFactory.createTitledBorder(nombre_panel);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
        this.setBackground(Color.GRAY);
        this.setBorder(jp_b_Controles);
        return  this;
    }
    public  void AddComponentes(Component gr){
        this.add(gr);
    }
}