package stoper.padykuka.homework.functions;

import stoper.padykuka.homework.frame.MyTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;


public class Counter extends JLabel implements Serializable{
    /**
     * Klasa licznika
     */
    private static final long serialVersionUID = 955317654415872436L;

    private static long elapsedTime = 0, hours = 0, minutes = 0, seconds = 0;
    private static Timer timer;
    private static String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
    private static JLabel jb;

    public Counter() {}

    /**
     * Create Compontn
     * oraz inicjalizujemy timer setTimer();
     */
    public void createJlabel(){
        jb = new JLabel();
        jb.setOpaque(true);
        setMyFont(new Font("Serif", Font.BOLD, 18));
        setBorderColor(Color.BLACK);
        setAligment(0);
        jb.setText(time);
        setTimer();
    }

    /**
     * Ustawianie zegara
     */
    private void setTimer(){
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime = (elapsedTime+1000);
                hours = (elapsedTime/3600000);
                minutes = (elapsedTime/60000) % 60;
                seconds = (elapsedTime/1000) % 60;
                time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                jb.setText(time);
            }
        });
    }

    /**
     * Uruchomienie licznika
     */
    public void start(){
        if (timer.isRunning()){
            JOptionPane.showMessageDialog(null,"Stoper juz pracuje","Start",JOptionPane.INFORMATION_MESSAGE);
        }else{
            timer.start();
        }


    }

    /**
     * Zatrzymanie Licznika
     */
    public void stop(){
        if (timer.isRunning()){
            timer.stop();
        }else
            JOptionPane.showMessageDialog(null,"Stoper jest juz zatrzymany","Stop",JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * Zresetowanie licznika oraz wyzerowanie tablicy
     */
    public void restart(){
        if(timer.isRunning()){
            JOptionPane.showMessageDialog(null,"Musisz zatrzymac zegar przed jego zresetowaniem","Reset",JOptionPane.WARNING_MESSAGE);
        }else
        {
            if (timer.isRunning())
                timer.stop();

            elapsedTime = 0; hours = 0; minutes = 0; seconds = 0;
            time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
            jb.setText(time);
            MyTable.clearTable();
        }

    }

    /**
     * Zwraca licznik
     * @return JLabel
     */
    public JLabel getJb(){
        return jb;
    }

    /**
     * Zwraca czy licznik pracuje
     * @return boolean licznikRunning
     */
    public boolean isTimerRunning(){ return timer.isRunning();}

    /**
     * Zwraca aktualny czas licznika
     * @return String Time
     */
    public String getTime(){
        return time;
    }

    /**
     * Zwraca aktualny czas licznika w milisekundach
     * @return ElapsedTime
     */
    public long getElapsedTime(){
        return elapsedTime;
    }

    /**
     * Set Horizontal Alignment
     * @param a 1 - LEFT
     *          2 - Center
     *          3 - Right
     *          default - Center
     */
    public void setAligment(int a){
        switch (a){
            case 1: {
                jb.setHorizontalAlignment(SwingConstants.LEFT);
                break;
            }
            case 2: {
                jb.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            }
            case 3: {
                jb.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            }
            default:{
                jb.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            }
        }
    }

    /**
     * SET BACKGROUND COLOR
     * @param color - color
     */
    public void setBackGroundColor(Color color){
        jb.setBackground(color);
    }

    /**
     * SET BORDER COLOR
     * @param color
     */
    public void setBorderColor(Color color){
        jb.setBorder(BorderFactory.createLineBorder(color));
    }

    /**
     * SET FONT
     * @param font - font
     */
    public void setMyFont(Font font){
        jb.setFont(font);
    }
}
