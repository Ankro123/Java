import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import tools.createFrame;

/**
 * TextEditor
 */
public class TextEditor {
    createFrame frame = new createFrame();
    JMenuBar menu = new JMenuBar();
    JMenu File = new JMenu("File");
    JMenuItem save = new JMenuItem("Save File");
    JMenuItem load = new JMenuItem("Load File");
    JTextArea textField = new JTextArea(12, 30);
    JPanel panel = new JPanel();
    JPanel topPanel = new JPanel();
    JScrollPane scroll = new JScrollPane(textField);
    JButton bold = new JButton("Bold");
    JButton italic = new JButton("Italic");

    int boldText = 0;
    int italicText = 0;

    TextEditor() {
        panel.setBorder(new TitledBorder(new EtchedBorder(), "TEXT AREA"));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

        topPanel.add(bold);
        topPanel.add(italic);

        textField.setFont(new Font("Arial", Font.PLAIN, 50));
        bold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (boldText == 0 && italicText == 0) {
                    textField.setFont(new Font("Arial", Font.BOLD, 50));
                    boldText = 1;
                } else if (boldText == 1 && italicText == 0) {

                    textField.setFont(new Font("Arial", Font.PLAIN, 50));
                    boldText = 0;
                    textField.repaint();
                } else if (boldText == 0 && italicText == 1) {

                    textField.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));
                    boldText = 1;

                } else if (boldText == 1 && italicText == 1) {

                    textField.setFont(new Font("Arial", Font.PLAIN | Font.ITALIC, 50));
                    boldText = 0;
                    textField.repaint();
                }

            }
        });

        italic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (italicText == 0) {
                    if (boldText == 0) {
                        textField.setFont(new Font("Arial", Font.ITALIC, 50));
                    } else if (boldText == 1) {
                        textField.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 50));
                    }
                    italicText = 1;
                } else if (italicText == 1) {
                    if (boldText == 0) {
                        textField.setFont(new Font("Arial", Font.PLAIN, 50));
                    } else if (boldText == 1) {
                        textField.setFont(new Font("Arial", Font.BOLD, 50));

                    }
                    italicText = 0;
                }
            }
        });

        fileSave.saveFile(save, textField);
        fileOpen.loadFile(load, textField);
        topPanel.setBounds(100, 20, 1200, 80);

        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        textField.setLineWrap(true);
        
        panel.add(scroll);
        panel.setBounds(100, 100, 1250, 800);

        File.add(save);
        File.add(load);

        menu.add(File);

        save.addActionListener(null);

        frame.setJMenuBar(menu);

        frame.setLayout(null);
        frame.add(topPanel);
        frame.add(panel);
        frame.setVisible(true);

    }
}