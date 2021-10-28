package stoper.padykuka.homework.frame;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import stoper.padykuka.homework.functions.ActualTime;
import stoper.padykuka.homework.functions.Counter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
                "1dlu, 20dlu, 1dlu, 20dlu, 1dlu, 90dlu, 1dlu");
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
            createTable();

        }catch (Exception e){
            System.out.println("Wystapil blad: " + e.getMessage());
        }
    }

    /**
     * Tworzenie tabeli
     */
    private void createTable(){
        MyTable table = new MyTable();
        table.writeTable();
        JScrollPane sp = new JScrollPane(table);
        sp.setBorder(BorderFactory.createLineBorder(Color.black));
        add(sp, CC.xywh(2,6,2,2));
    }

    /**
     * Tworzenie wyswietlacza aktualnej daty oraz czasu
     */
    private void createActualTimeLabel(){
        actualTime = new ActualTime();
        actualTime.createDateTimeComponentComponent();
        add(actualTime, CC.xywh(2,2,2,1));
    }

    /**
     * Tworzenie wyswietlacza Stopera
     */
    private void createTimeLabel(){
        ctr = new Counter();
        ctr.createJlabel();
        add(ctr.getJb(), CC.xywh(2,3,2,2));
    }

    /**
     * Metoda aktualizujaca aktualna date
     */
    private void updateData(){
        actualTime.createActualTimeDateUpdate();
        actualTime.setDataFormat(3);
        actualTime.setText("Actual Date: " + actualTime.getDate());
    }

    /**
     * Serialize Counter and ActualTime Components
     */
    public static void SerializationToFile(){
        try{
            ObjectOutputStream objectOutputStreamActualTime = new ObjectOutputStream(new FileOutputStream("ActualTime.bin"));
            objectOutputStreamActualTime.writeObject(actualTime);

            ObjectOutputStream objectOutputStreamCounter = new ObjectOutputStream(new FileOutputStream("Counter.bin"));
            objectOutputStreamCounter.writeObject(ctr);

        }catch (IOException ioException){
            System.out.println("Cannot write to bin: " + ioException.getMessage());
        }
    }
}
