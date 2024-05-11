import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import tools.*;

public class fileSave {

    static void saveFile(JMenuItem item, JTextArea textArea){

        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileFilter() {

                    @Override
                    public boolean accept(File f) {
                        if (f.isDirectory()) {
                            return true;
                        } else {
                            String fileName = f.getName().toLowerCase();
                            return fileName.endsWith(".txt");
                        }
                    }

                    @Override
                    public String getDescription() {
                        return "Text Files (*.txt)";
                    }

                });
                int choice = fileChooser.showSaveDialog(null);
                
                
                if(choice == JFileChooser.APPROVE_OPTION){

                   
                    try {
                        
                        File file = fileChooser.getSelectedFile();
                        FileWriter writer = new FileWriter(file);
                        file.createNewFile();
                        writer.write(textArea.getText());
                        System.out.println("File created with name : " + file.getName());
                        writer.close();
                    } catch (IOException e1) {
                    
                        e1.printStackTrace();
                    }
                    

                }
                
            }
        });
    }
}
        

    