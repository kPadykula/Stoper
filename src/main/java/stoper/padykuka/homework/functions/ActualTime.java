package stoper.padykuka.homework.functions;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActualTime extends JLabel implements Serializable {
    private static final long serialVersionUID = 690136957394739283L;

    private Date date;
    private SimpleDateFormat format;

    public ActualTime(){}

    /**
     * Create Component
     */
    public void createDateTimeComponentComponent(){
        setText("Actual Date: ");
        setBorderColor(Color.BLACK);
        setAligment(0);
        setOpaque(true);
    }

    /**
     * Create Date time
     * format and new date
     */
    public void createActualTimeDateUpdate(){
        createDateTime();
    }
    /**
     * Tworzenie aktualnej daty
     */
    private void createDateTime(){
        format = new SimpleDateFormat();
        setDataFormat(0);
        date = new Date();
    }
    /**
     * Zwracanie aktualnej daty
     * @return String Data
     */
    public String getDate() {
        return format.format(date);
    }

    /**
     * SET DATA FORMAT
     * @param a = 1 - yyyy-MM-dd HH:mm:ss
     *            2 - dd-MM-yyy HH:mm:ss
     *            3 - EEE, d MMM yyyy HH:mm:ss
     *            4 - yyyy MMMMM dd HH:mm:ss
     *            default - dd-MM-yyyy HH:mm:ss
     */
    public void setDataFormat(int a){
        switch(a) {
            case 1: {
                format.applyPattern("yyyy-MM-dd HH:mm:ss");
                break;
            }
            case 2: {
                format.applyPattern("dd-MM-yyy HH:mm:ss");
                break;
            }
            case 3:{
                format.applyPattern("EEE, d MMM yyyy HH:mm:ss");
                break;
            }
            case 4:{
                format.applyPattern("yyyy MMMMM dd HH:mm:ss");
                break;
            }
            default:{
                format.applyPattern("dd-MM-yyyy HH:mm:ss");
                break;
            }
        }
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
                setHorizontalAlignment(SwingConstants.LEFT);
                break;
            }
            case 2: {
                setHorizontalAlignment(SwingConstants.CENTER);
                break;
            }
            case 3: {
                setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            }
            default:{
                setHorizontalAlignment(SwingConstants.CENTER);
                break;
            }
        }
    }

    /**
     * SET BACKGROUND COLOR
     * @param color - color
     */
    public void setBackGroundColor(Color color){
        setBackground(color);
    }

    /**
     * SET BORDER COLOR
     * @param color
     */
    public void setBorderColor(Color color){
        setBorder(BorderFactory.createLineBorder(color));
    }

    /**
     * SET FONT
     * @param font - font
     */
    public void setMyFont(Font font){
        setFont(font);
    }
}
