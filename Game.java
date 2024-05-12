import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import tools.createFrame;

public class Game {

        ImageIcon mole = new ImageIcon("photos/mole.png");
        Image image = mole.getImage();
        Image headImage = image.getScaledInstance(60, 50, java.awt.Image.SCALE_SMOOTH);
        ImageIcon mole1 = new ImageIcon(headImage);
        JLabel moleLabel = new JLabel(mole1);

        createFrame f = new createFrame();
        Game (){
           
            moleLabel.setBounds(300,300,80,70);
            moleLabel.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                        
                     
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    Random random = new Random();
                        int w = random.nextInt(100, 1400);
                        int h = random.nextInt(150,700);
                        moleLabel.setBounds(w,h, moleLabel.getWidth(), moleLabel.getHeight());
                       
                        f.revalidate();
                        f.repaint();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
                
            });

            
            f.setIconImage(mole.getImage());
            f.add(moleLabel);
            f.getContentPane().setBackground(Color.black);
            f.setLayout(null);
            f.setVisible(true); 
            

        }
}
