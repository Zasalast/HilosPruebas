package Parcial3Poe24022021;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipalParcial3 extends JPanel {
    public PanelPrincipalParcial3() {
        this.setLayout(new BorderLayout(2, 2));
        this.setBackground(Color.lightGray);
        this.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
    }

    public void addJPanel(JPanel panel, String borderLayouts){
        this.add(panel,borderLayouts);
    }

    public void addJComponents(Component components){
        this.add(components);
    }
}