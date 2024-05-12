import tools.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu {
    public static void main(String[] args) { 
        createFrame Menu = new createFrame("Menu");
        
        JButton calculator = new JButton("CALCULATOR");
        JButton toDoList = new JButton("To Do List");
        JButton textEditor = new JButton("Text Editor");
        JButton game = new JButton("Game");

        JPanel button = new JPanel();
        button.setLayout(new GridLayout(3, 1,0, 30));
        button.setBounds(600, 200, 400, 400);
        calculator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
                Calc calc = new Calc();
                Menu.dispose();
            }
        });
        toDoList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ToDo todo = new ToDo();
                Menu.dispose();
            }
        });
        textEditor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
                TextEditor editor  = new TextEditor();
                Menu.dispose();
            }
        });
        game.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
                Game playGame  = new Game();
                Menu.dispose();
            }
        });

       
        button.add(calculator);
        button.add(toDoList);
        button.add(textEditor);
        button.add(game);
        Menu.add(button);
        Menu.setLayout(null);
        Menu.setVisible(true);
    }


}
