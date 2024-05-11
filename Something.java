import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Something {
    
    public static void main(String[] args) {
    
        int flag = 1;
        JPanel panel = new JPanel();
        JTextField username = new JTextField(20);
        JPasswordField password = new JPasswordField(20);
        panel.add(new JLabel("Enter your Username"));
        panel.add(username);

        JOptionPane.showMessageDialog(null, panel, "USERNAME", JOptionPane.INFORMATION_MESSAGE);
        String user = username.getText();
        
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Enter your Password"));
        panel2.add(password);

        JOptionPane.showMessageDialog(null, panel2, "PASSWORD", JOptionPane.INFORMATION_MESSAGE);
        char[] pass = password.getPassword();
        
        JPanel panel3 = new JPanel();
        password.setText("");
        panel3.add(new JLabel("Re-Enter your Password"));
        panel3.add(password);
        JOptionPane.showMessageDialog(null, panel3, "CONFIRM_PASSWORD", JOptionPane.INFORMATION_MESSAGE);
        char[] pass2 = password.getPassword();

        if(Arrays.equals(pass, pass2)){

            try{
                    FileWriter Writer = new FileWriter("details.txt", true);
                    BufferedWriter Detailer = new BufferedWriter(Writer);
                    Detailer.append(user+"||"+pass.toString());
                    Detailer.newLine();
                    Detailer.close();
                
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);

            }
            JOptionPane.showMessageDialog(null, "Congratulations, account Created", "WOOHOO", JOptionPane.PLAIN_MESSAGE);
        }
        
        try{
            
        File Reading = new File("details.txt");
        Scanner Reader = new Scanner(Reading);
            while(Reader.hasNextLine()){
                if((user+"||"+pass.toString()).equals(Reader.nextLine())){
                    flag = 0;
                    JOptionPane.showMessageDialog(null, "CONGRATULATIONS, LOGGED IN", "LOGIN", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    continue;
                }
            }
            Reader.close();
            if (flag == 1) {
                JOptionPane.showMessageDialog(null, "Wrong username or password");
                System.exit(1);

            }
           
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
}
