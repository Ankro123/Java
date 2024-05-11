package tools;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class createFrame extends JFrame {

    public createFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1600, 900);

    }

    public createFrame(String heading) {
        JLabel head = new JLabel(heading);
        head.setFont(new Font("Arial", Font.BOLD, 40));
        head.setHorizontalAlignment(JLabel.CENTER);
        head.setVerticalAlignment(JLabel.CENTER);
        head.setBounds(0, 0, 1600, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle(heading);
        this.add(head);
        this.setSize(1600, 900);
    }

    public createFrame(String heading, ImageIcon icon) {
        Image image = icon.getImage();
        Image headImage = image.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
        ImageIcon calcHead = new ImageIcon(headImage);
        JLabel imgLabel = new JLabel(calcHead);
        imgLabel.setBounds(1450, 0, 100, 100);
        imgLabel.setHorizontalAlignment(JLabel.RIGHT);
        imgLabel.setVerticalAlignment(JLabel.TOP);
        JLabel head = new JLabel(heading);
        head.setFont(new Font("Arial", Font.BOLD, 40));
        head.setHorizontalAlignment(JLabel.CENTER);
        head.setVerticalAlignment(JLabel.CENTER);
        head.setBounds(0, 0, 1600, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle(heading);
        this.add(head);
        this.setSize(1600, 900);
        this.setIconImage(icon.getImage());
        this.add(imgLabel);
    }

}
