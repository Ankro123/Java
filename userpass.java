import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class userpass {

    static void createUser(String User, String Pass) {

        try {
            FileWriter Writer = new FileWriter("userPass.txt", true);

            BufferedWriter Detailer = new BufferedWriter(Writer);
            Detailer.append(User + "||" + Pass);
            Detailer.newLine();
            Detailer.close();
            JOptionPane.showMessageDialog(null, "User Created.", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Unknown Error", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    static void loginUser(String User, String Pass) {
        int flag = 1;
        try {
            File user = new File("userPass.txt");
            Scanner scanner = new Scanner(user);

            while (scanner.hasNextLine()) {
                if (scanner.nextLine().equals(User + "||" + Pass)) {
                    flag = 0;
                    JOptionPane.showMessageDialog(null, "You are Logged in", "LOGGED IN SUCCESSFULY",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
            if (flag == 1) {
                JOptionPane.showMessageDialog(null, "Wrong Username Or Password", "LOGIN FAILED",
                        JOptionPane.ERROR_MESSAGE);
            }

            scanner.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Unknown Error", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    void audioPlayer(File song){

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(song);
            
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
            
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
        
        Object[] options = { "CREATE", "LOGIN" };
        int result = JOptionPane.showOptionDialog(null, "Log In Or Create Account?", "SELECT ONE",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

        String Username = JOptionPane.showInputDialog(null, "Please Enter your username", "USERNAME",
                JOptionPane.INFORMATION_MESSAGE);
        String Password = JOptionPane.showInputDialog(null, "Please enter your password", "PASSWORD",
                JOptionPane.INFORMATION_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            String conPassword = JOptionPane.showInputDialog(null, "Please re-enter your password", "PASSWORD",
                    JOptionPane.INFORMATION_MESSAGE);

            if (Password.equals(conPassword)) {
                createUser(Username, Password);
            } else {
                JOptionPane.showMessageDialog(null, "Passwords Don't Match", "FAILED", JOptionPane.ERROR_MESSAGE);
            }
        } else if (result == JOptionPane.NO_OPTION) {
            loginUser(Username, Password);
        }

        System.exit(0);
    }
}
