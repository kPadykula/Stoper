package stoper.padykula.homework.test1.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends JFrame {
    /**
     * Tworzenie okna
     */
    public MyFrame(){
        setTitle("Stoper TEST");
        setSize(new Dimension(530,300));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindowDialog();
            }
        });
        setLayout(new BorderLayout());
        MyFrontPanel fPanel = new MyFrontPanel();
        fPanel.createFrontPanel();
        add(fPanel, BorderLayout.CENTER);

    }

    /**
     * Okno dialogowe po nacisnieciu przycisku zamkniecia okna
     */
    private void closeWindowDialog(){
        String[] option = {"Yes",
                "No"};
        int n = JOptionPane.showOptionDialog
                (
                        this,
                        "Would you like to close app?",
                        "Close App",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        option,
                        option[1]);

        if(n == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }
}
