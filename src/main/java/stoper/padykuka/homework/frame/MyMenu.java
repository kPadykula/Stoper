package stoper.padykuka.homework.frame;

import stoper.padykuka.homework.functions.Counter;
import stoper.padykuka.homework.functions.Export;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Map;

public class MyMenu extends JMenuBar implements ActionListener {
    private JMenu menuFile, menuEdit;
    private JMenuItem itemNew, itemImport, itemExport;
    private DefaultTableModel tab = MyTable.getTable();
    private MyTable table = new MyTable();


    public MyMenu(){
        initComponentOfMenu();
    }

    private void initComponentOfMenu(){
        try{
            createMenu();
            createMenuItem();
        }catch (Exception e){
            System.out.println("Wystapil blad: " + e.getMessage());
        }
    }

    private void createMenu(){
        menuFile = new JMenu("File");
        menuEdit = new JMenu("Edit");

        add(menuFile);
        add(menuEdit);
    }

    private void createMenuItem(){
        itemNew = createOneItem("New", "This create new table");
        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));

        itemImport = createOneItem("Import", "This item import table from json file");
        itemImport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.ALT_MASK));

        itemExport = createOneItem("Export", "This item export actual table to json file");
        itemExport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));

        menuFile.add(itemNew);
        menuEdit.add(itemImport);
        menuEdit.add(itemExport);
    }

    private JMenuItem createOneItem(String name, String description){
        JMenuItem jMI = new JMenuItem(name);
        jMI.getAccessibleContext().setAccessibleDescription(description);
        jMI.addActionListener(this);
        return jMI;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == itemNew){
            new Counter().restart();
        }
        if (source == itemImport){

        }
        if (source == itemExport){
            if (new Counter().isTimerRunning())
                JOptionPane.showMessageDialog(this,"Zatrzymaj stoper aby exportowac!","Export",JOptionPane.WARNING_MESSAGE);
            else{
                Export exp = new Export();
                if (exp != null){
                    Map<String,String> map = table.returnMap();
                    for (Map.Entry<String,String> entry : map.entrySet()){
                        System.out.println(entry.getKey() + ":" + entry.getValue());
                    }
                }
            }

        }


    }
}
