package stoper.padykuka.homework.frame;

import stoper.padykuka.homework.functions.Counter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MyTable extends JTable {
    private String[] colName = {"Lp.","Time","Margin"};
    private static DefaultTableModel defTable;
    private Counter ctr = new Counter();
    private long[] rav = new long[2];
    private Map<String,String > map;

    public MyTable(){

    }

    /**
     * Rysowanie Tablicy
     */
    public void writeTable(){
        defTable = new DefaultTableModel(colName,0);
        setOpaque(true);
        setModel(defTable);
    }

    /**
     * Dodawanie nowego wiersza
     */
    public void addNewRow(){
        String time = ctr.getTime(); String margin; int lp = defTable.getRowCount() + 1;
        double marginTime;

        if (lp == 1){
            margin = "0";
            rav[0] = ctr.getElapsedTime()/1000;
        }
        else{
            rav[1] = ctr.getElapsedTime()/1000;
            marginTime = rav[0] - rav[1];
            rav[0] = rav[1];
            margin = String.valueOf(marginTime);
        }
        Object[] data = {lp, time, margin};
        defTable.addRow(data);
    }

    /**
     * Metoda czyszczaca tablice
     */
    public static void clearTable(){
        if (defTable != null)
            defTable.setRowCount(0);
    }

    /**
     * RETURN TABLE MAP
     * @return - table map <STRING, STRING>
     */
    public Map<String, String> returnMap(){
        map = new HashMap<String, String>();
        for (int row = 0; row < defTable.getRowCount(); row++){
            for (int col = 0; col < defTable.getColumnCount(); col++){
                map.put(defTable.getValueAt(row,1).toString(), defTable.getValueAt(row,col).toString());
            }
        }
        return map;
    }

    /**
     * RETURN TABLE MODEL
     * @return - default table model
     */
    public static DefaultTableModel getTable(){
        return defTable;
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
