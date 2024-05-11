import tools.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.Border;

public class ToDo extends JFrame {

    Color color = Color.decode("#96aef0");
    ImageIcon logo = new ImageIcon("photos\\todo.png");
    createFrame frame = new createFrame("TO DO LIST", logo);
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    Border border = BorderFactory.createLineBorder(Color.RED);
    JTextField textField = new JTextField();
    Font font = new Font("Arial", Font.PLAIN, 40);
    JButton submit = new JButton("Submit");
    String listItem = new String();
    JLabel doLabel = new JLabel("TO DO");
    JLabel doingLabel = new JLabel("DONE");

    ToDo() {

        panel1.setLayout(new GridLayout(10, 1, 0, 10));
        panel1.setBounds(50, 225, 700, 600);
        panel1.setBackground(Color.CYAN);
        panel1.setBorder(border);

        panel2.setLayout(new GridLayout(10, 1, 0, 10));
        panel2.setBounds(800, 225, 700, 600);
        panel2.setBackground(Color.CYAN);
        panel2.setBorder(border);

        submit.setFont(font);
        submit.setBounds(1150, 100, 200, 60);
        submit.setMnemonic(KeyEvent.VK_ENTER);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listItem = textField.getText();
                textField.setText("");
                JButton button = new JButton(listItem);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ex) {
                        JButton button2 = new JButton(button.getText());
                        button2.setFont(font);
                        panel1.remove(button);
                        panel2.add(button2);
                        button2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent exc) {
                                panel2.remove(button2);
                                panel2.revalidate();
                                panel2.repaint();
                            }
                        });
                        panel1.revalidate();
                        panel1.repaint();
                        panel2.revalidate();
                        panel2.repaint();
                    }
                });
                button.setFont(font);
                panel1.add(button);
                panel1.revalidate();
                panel1.repaint();

            }
        });

        textField.setFont(font);
        textField.setBounds(100, 100, 1000, 60);

        doLabel.setBounds(300, 145, 200, 100);
        doLabel.setFont(new Font("Arial", Font.BOLD, 60));

        doingLabel.setBounds(1070, 145, 200, 100);
        doingLabel.setFont(new Font("Arial", Font.BOLD, 60));
        frame.setLayout(null);
        frame.add(doLabel);
        frame.add(doingLabel);
        frame.add(textField);
        frame.add(submit);
        frame.add(panel1);
        frame.add(panel2);
        frame.getContentPane().setBackground(color);
        frame.setVisible(true);

    }

}
