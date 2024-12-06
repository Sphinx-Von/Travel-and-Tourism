package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener{
    JButton back;
    Paytm(){
        setBounds(500, 200, 800, 600);
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);

        try{
            pane.setPage("https://paytm.com/");

        }catch(Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404</html>");

        }
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);

         back = new JButton("Back");
        back.setBounds(610, 20, 80, 40);
        back.addActionListener(this);
        pane.add(back);



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Payments();
        }

    }
    public static void main(String[] args) {
        new Paytm();
    }
}
