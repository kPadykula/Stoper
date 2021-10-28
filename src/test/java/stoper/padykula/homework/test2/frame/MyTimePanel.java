package stoper.padykula.homework.test2.frame;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import stoper.padykuka.homework.functions.ActualTime;
import stoper.padykuka.homework.functions.Counter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTimePanel extends JPanel{
    private static Counter ctr;
    private static ActualTime actualTime;

    /**
     * Konstruktor Panelu centralnego
     */
    public MyTimePanel(){}

    /**
     * Metoda tworzaca komponent z aktualnym czasem
     */
    public void createMyTimePanel(){
        FormLayout form = new FormLayout(
                "5dlu, 90dlu, 100dlu, 5dlu",
                "1dlu, 20dlu, 5dlu, 20dlu, 1dlu, 25dlu, 1dlu");
        setLayout(form);
        initComponents();
    }


    /**
     * Inicjalizacja komponentow
     */
    private void initComponents() {
        try{
            createTimeLabel();

        }catch (Exception e){
            System.out.println("Wystapil blad: " + e.getMessage());
        }
    }

    /**
     * Tworzenie wyswietlacza Stopera
     */
    private void createTimeLabel(){
        ctr = new Counter();
        ctr.createJlabel();
        ctr.setAligment(3);
        ctr.setBackGroundColor(Color.blue);
        ctr.setMyFont(new Font("SansSerif",Font.BOLD, 24));

        add(ctr.getJb(), CC.xywh(2,2,2,6));
    }
}
