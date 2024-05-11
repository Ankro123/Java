import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;


public class fileOpen {

   public static void loadFile(JMenuItem item, JTextArea textArea){
        
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(".");
                
                fileChooser.setAcceptAllFileFilterUsed(false);
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
                int choice = fileChooser.showOpenDialog(null);

                if (choice == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                        Scanner scanner = new Scanner(file);
                        textArea.setText(scanner.nextLine());
                        while (scanner.hasNextLine()) {

                            textArea.append(scanner.nextLine());
                            textArea.append("\n");

                        }
                        scanner.close();
                    } catch (Exception ex) {

                      }

                }
            }
        });

    }

    }
        
