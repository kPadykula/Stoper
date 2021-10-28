package stoper.padykuka.homework.frame;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import stoper.padykuka.homework.functions.Counter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrontPanel extends JPanel implements ActionListener{

    private JButton jButtonStop, jButtonStart, jButtonLap, jButtonReset;
    private Counter ctr = new Counter();
    private MyTable table = new MyTable();

    public MyFrontPanel(){}

    /**
     * Tworzenie Panelu przedniego
     */
    public void createFrontPanel(){
        FormLayout form = new FormLayout(
                "10dlu, 60dlu, 10dlu, 60dlu, 10dlu, 60dlu, 10dlu, 60dlu, 10dlu",
                "5dlu, 30dlu, 5dlu, 30dlu, 5dlu, 30dlu, 5dlu, 30dlu,5dlu");
        setLayout(form);
        initComponent();
    }

    /**
     * Inicjalizowanie komponentow skladowych
     * Buttony oraz centralny panel
     */
    private void initComponent(){
        try{
            initButtons();
            initTimePanel();
        }catch (Exception e){
            System.out.println("Wystapil blad: " + e.getStackTrace());
        }


    }

    /**
     * Tworzenie panelu centralnego
     */
    private void initTimePanel(){
        MyTimePanel panel = new MyTimePanel();
        panel.createMyTimePanel();
        add(panel, CC.xywh(2,2,5,8));
    }

    /**
     * Tworzenie przyciskow
     */
    private void initButtons(){
        jButtonStop = createButton("Stop");
        jButtonStart = createButton("Start");
        jButtonLap = createButton("Lap");
        jButtonReset = createButton("Reset");

        add(jButtonStart, CC.xy(8,2, CC.FILL, CC.FILL));
        add(jButtonStop, CC.xy(8,4, CC.FILL, CC.FILL));
        add(jButtonLap, CC.xy(8,6, CC.FILL, CC.FILL));
        add(jButtonReset, CC.xy(8,8, CC.FILL, CC.FILL));

    }

    /**
     * Metoda do tworzenia Buttonow
     * @param name nazwa przycisku
     * @return JButton
     */
    private JButton createButton(String name){
        JButton jb = new JButton(name);
        jb.addActionListener(this);
        return jb;
    }

    /**
     * Opisanie funkcji Buttonow
     * @param e = Start - wywolanie funkcji start w liczniku
     * @param e = Stop - wywolanie funkcji stop -||-
     * @param e = Reset - wywolanie funkcji reset -||-
     * @param e = Lap - wywolanie funkcji lap w tabeli
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == jButtonStart) {
            ctr.start();
        }
        if(source == jButtonStop){
            ctr.stop();
        }
        if (source == jButtonReset){
            ctr.restart();
        }
        if (source == jButtonLap){
            table.addNewRow();
        }

    }
}
