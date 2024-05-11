import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ankro {
    static void audioPlayer(File song){

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(song);
            
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ImageIcon img = new ImageIcon("A:/gae.gif");
        ImageIcon img2 = new ImageIcon("A:/gaaae.png");
        ImageIcon img3 = new ImageIcon("A:/lyin.gif");
        ImageIcon img4 = new ImageIcon("A:/good.jpg");
        ImageIcon img5 = new ImageIcon("A:/grief.jpg");
        Object[] options = { "Who says I'm Gay?" };
        Object[] options1 = { "This Is my Name", "I Am a LIAR" };
        Object[] options3 = { "Ok you caught me", "I'm not GAY" };
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter Your Name"));
        JTextField text = new JTextField(15);
        panel.add(text);

        // JPanel nPanel = new JPanel();
        
        // nPanel.add(new JLabel("Enter your Username\n"));
        // nPanel.add(new JTextField(20));
        // nPanel.add(new JLabel("Enter Your Password", SwingConstants.CENTER));
        // nPanel.add(new JPasswordField(20));
        // nPanel.add(new JButton("Click Me"));
        
        // JOptionPane.showMessageDialog(null, nPanel, "ID PASSWORD", JOptionPane.INFORMATION_MESSAGE);
        File file = new File("wtfyl.wav");
        String name = "";
        int result = JOptionPane.showOptionDialog(null, panel, "NAME", JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options1, null);
        if (result == JOptionPane.YES_OPTION) {

            name = text.getText();
        } else if(result == JOptionPane.NO_OPTION){
            audioPlayer(file);
            JOptionPane.showMessageDialog(null, null, null, JOptionPane.PLAIN_MESSAGE, img3);
            System.exit(0);
        }
        else{
            System.exit(0);
        }
        int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Hello, " + name + "\nPlease Enter your age",
                "Age", JOptionPane.PLAIN_MESSAGE));

        if (age < 18) {
            JOptionPane.showMessageDialog(null, "Bitch you ain't legal get outta here", "ILLEGAL",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
        int Choice = JOptionPane.showConfirmDialog(null, "Are you Gay?", "You can NOT say No.",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (Choice == JOptionPane.YES_OPTION) {
            JOptionPane.showOptionDialog(null, "", "WHY ARE YOU GAE", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE,
                    img, options, null);

            int gae = JOptionPane.showOptionDialog(null, "", "YOU ARE GAY", JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    img2, options3, null);
            if (gae == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, null, "Good", JOptionPane.PLAIN_MESSAGE, img4);
            } else {
                JOptionPane.showMessageDialog(null, null, "Good", JOptionPane.PLAIN_MESSAGE, img5);
            }

        } else {

            JOptionPane.showMessageDialog(null, null, "LYING ASS", JOptionPane.PLAIN_MESSAGE, img3);
        }

        System.exit(0);
    }
}
