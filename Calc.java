import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Calc extends JFrame {

    JButton[] buttons = new JButton[11];
    char op;
    float num1, num2;
    Float ans;
    ImageIcon calcIco = new ImageIcon("photos/calculator_icon.png");
    JTextField textField = new JTextField();
    Image image = calcIco.getImage();
    Image headImage = image.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
    ImageIcon calcHead = new ImageIcon(headImage);
    Border border = BorderFactory.createLineBorder(Color.BLUE);
    JLabel heading = new JLabel("CALCULATOR");
    JLabel headingIcon = new JLabel(calcHead);
    JPanel panel = new JPanel();
    JPanel pad = new JPanel();
    JPanel enter = new JPanel();
    JPanel operations = new JPanel();
    JButton addition = new JButton("+");
    JButton multiplication = new JButton("*");
    JButton subtraction = new JButton("-");
    JButton division = new JButton("/");
    JButton equals = new JButton("=");
    Font font = new Font("Arial", Font.PLAIN, 40);


    void setOps(boolean choice){

            addition.setEnabled(choice);
            subtraction.setEnabled(choice);
            multiplication.setEnabled(choice);
            division.setEnabled(choice);

    }
    Calc() {

        addition.setFont(font);
        multiplication.setFont(font);
        subtraction.setFont(font);
        division.setFont(font);
        equals.setFont(font);

        operations.setLayout(new GridLayout(5, 1));
        operations.setBounds(1000, 350, 100, 350);
        pad.setLayout(new FlowLayout());
        for (int i = 1; i < 11; i++) {
            int j = i % 10;
            Integer in = j;
            String a = in.toString();
            buttons[i] = new JButton(a);
            buttons[i].setPreferredSize(new Dimension(100, 70));
            buttons[i].setFont(font);
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + a);
                }
            });
            pad.add(buttons[i]);
        }

        enter.setBounds(500, 150, 600, 200);
        textField.setPreferredSize(new Dimension(600, 100));
        textField.setFont(new Font("Arial", Font.BOLD, 80));
        addition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                op = '+';
                num1 = Float.parseFloat(textField.getText());
                textField.setText("");
                setOps(false);
                equals.setEnabled(true);
            }
        });
        operations.add(addition);
        subtraction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                op = '-';
                num1 = Float.parseFloat(textField.getText());
                textField.setText("");
                setOps(false);
                equals.setEnabled(true);
            }
        });
        operations.add(subtraction);
        multiplication.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                op = '*';
                num1 = Float.parseFloat(textField.getText());
                textField.setText("");
                setOps(false);
                equals.setEnabled(true);
            }
        });
        operations.add(multiplication);
        division.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                op = '/';
                num1 = Float.parseFloat(textField.getText());
                textField.setText("");
                setOps(false);
                equals.setEnabled(true);
            }

        });
        operations.add(division);
        operations.add(equals);

        equals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (op) {
                    case '+':
                        num2 = Float.parseFloat(textField.getText());
                        ans = num1 + num2;
                        textField.setText(ans.toString());
                        equals.setEnabled(false);
                        setOps(true);
                        break;
                    case '-':
                        num2 = Float.parseFloat(textField.getText());
                        ans = num1 - num2;
                        textField.setText(ans.toString());
                        equals.setEnabled(false);
                        setOps(true);
                        break;
                    case '*':
                        num2 = Float.parseFloat(textField.getText());
                        ans = num1 * num2;
                        textField.setText(ans.toString());
                        equals.setEnabled(false);
                        setOps(true);
                        break;
                    case '/':
                        num2 = Float.parseFloat(textField.getText());
                        try {
                            ans = num1 / num2;
                            textField.setText(ans.toString());
                        } catch (ArithmeticException ex) {
                            textField.setText("");
                        } finally {
                            equals.setEnabled(false);
                            setOps(true);
                        }
                        break;
                    default:
                        break;
                }
            }
        });

        enter.add(textField);
        panel.setBackground(Color.GRAY);

        pad.setBounds(600, 350, 400, 350);

        pad.setBackground(Color.WHITE);

        heading.setFont(font);
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setVerticalAlignment(JLabel.CENTER);
        heading.setBounds(0, 0, 1600, 100);

        headingIcon.setBounds(1450, 0, 100, 100);
        headingIcon.setHorizontalAlignment(JLabel.RIGHT);

        this.setIconImage(calcIco.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Calculator");
        this.setSize(1600, 900);
        this.setLayout(null);
        this.add(heading);
        this.add(headingIcon);
        this.add(pad);
        this.add(panel);
        this.add(enter);
        this.add(operations);
        this.setVisible(true);

    }

}
