package Parcial3Poe24022021;

import javax.swing.*;
import java.awt.*;

public class Cronometro extends JLabel implements Runnable{
    int hora=0, minutos=0,segundos=0;
    boolean bandera_llegada = true;

    public Cronometro() {
        this.setPreferredSize(new Dimension(100, 40));
        this.setHorizontalAlignment((SwingConstants.CENTER));
    }

    @Override
    public void run() {
        try {
            while(bandera_llegada){
                this.setText(Tiempo());
                System.out.println("hilo   cron ");

                Thread.sleep(1000);

            } } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
    }

    String Tiempo(){
        setSegundos(getSegundos()+1);
        if (getSegundos()>59) {
            System.out.println("9");
            setSegundos(0);
            setMinutos(getMinutos()+1);
            if (getMinutos()>59) {
                setMinutos(0);
                setHora(getHora()+1);
            }
        }
        return  ""+hora+":"+minutos+":"+segundos;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public boolean isBandera_llegada() {
        return bandera_llegada;
    }

    public void setBandera_llegada(boolean bandera_llegada) {
        this.bandera_llegada = bandera_llegada;
    }
}
