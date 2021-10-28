package stoper.padykuka.homework.functions;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Export extends JFileChooser{

    private String filename, dir, selcfile;
    private String[] rec;



    public Export(){
        setFileSelectionMode(JFileChooser.FILES_ONLY);
        addChoosableFileFilter(new FileNameExtensionFilter("Text file", ".txt"));
        addChoosableFileFilter(new FileNameExtensionFilter("CSV file", ".csv"));
        setAcceptAllFileFilterUsed(true);


        int rVal = showSaveDialog(this);
        if (rVal == JFileChooser.APPROVE_OPTION){
            filename = getSelectedFile().getName();
            dir = getCurrentDirectory().toString()+String.valueOf(Character.toChars(92));
            if (getFileFilter().getDescription() == "Text file")
                selcfile = ".txt";
            else if (getFileFilter().getDescription() == "CSV file")
                selcfile = ".csv";
            else
                selcfile = "";

            rec = new String[]{filename, dir, selcfile};
        }else
            rec = null;
    }

    public String[] getRec() {
        return rec;
    }

    public boolean saveToFile(String name, String dir, String filetype, float[][] tab) {

        try {
            FileWriter fstream;
            if (name == null) {
                fstream = new FileWriter(dir + "plik" + filetype);
            }else {
                fstream = new FileWriter(dir + name + filetype);
            }
            BufferedWriter out = new BufferedWriter(fstream);
            if (tab.length <= 0) {
                out.close();
                return false;
            } else {
                out.write(" ;1;2;3;4;5");
                out.newLine();
                for (int i = 0; i < tab.length; i++) {
                    out.write(i + 1 + ";");
                    for (int j = 0; j < tab.length; j++) {
                        if (j < 4)
                            out.write(tab[i][j] + ";");
                        else
                            out.write(String.valueOf(tab[i][j]));
                    }
                    out.newLine();
                }
            }
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
