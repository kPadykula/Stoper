package stoper.padykula.homework.test1.frame;

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

        Timer SimpleTimer = new Timer(1, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                updateData();
            }
        });

        SimpleTimer.start();
    }


    /**
     * Inicjalizacja komponentow
     */
    private void initComponents() {
        try{
            createActualTimeLabel();
            createTimeLabel();

        }catch (Exception e){
            System.out.println("Wystapil blad: " + e.getMessage());
        }
    }

    /**
     * Tworzenie wyswietlacza aktualnej daty oraz czasu
     */
    private void createActualTimeLabel(){
        actualTime = new ActualTime();
        actualTime.createDateTimeComponentComponent();
        actualTime.setBackGroundColor(Color.MAGENTA);
        add(actualTime, CC.xywh(2,2,2,1));
    }

    /**
     * Tworzenie wyswietlacza Stopera
     */
    private void createTimeLabel(){
        ctr = new Counter();
        ctr.createJlabel();
        ctr.setAligment(1);
        ctr.setBackGroundColor(Color.red);
        ctr.setMyFont(new Font("SansSerif",Font.BOLD, 24));

        add(ctr.getJb(), CC.xywh(2,4,2,3));
    }

    /**
     * Metoda aktualizujaca aktualna date
     */
    private void updateData(){
        actualTime.createActualTimeDateUpdate();
        actualTime.setDataFormat(3);
        actualTime.setText("Actual Date: " + actualTime.getDate());
    }
}
