package travel.management.system;
import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar bar;
    String username1;

    public void run(){
        try{

            for(int i = 1; i<= 101; i++){
                int max = bar.getMaximum(); //100
                int value = bar.getValue(); 

                if(value < max){
                    bar.setValue(bar.getValue() + 1);
                }
                else{
                    setVisible(false);
                    try {
                        new Dashboard(username1);
                    } catch (Exception e) {
                        e.printStackTrace(); // Log any issues with the Dashboard class
                    }
                   break;
                    // new class object
                }
               Thread.sleep(50);
            }

        }catch(Exception e){
            e.printStackTrace();

        }
    }

    Loading(String username1){
        this.username1 = username1;
        t = new Thread(this);
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50, 20, 600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

         bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading Please Wait...");
        loading.setBounds(230, 130, 150,30);
        loading.setForeground(Color.red);
        loading.setFont(new Font("Raleway", Font.BOLD, 16));
        add(loading);

        JLabel username = new JLabel("Welcome " + username1);
        username.setBounds(20, 310, 400,40);
        username.setForeground(Color.red);
        username.setFont(new Font("Raleway", Font.BOLD, 16));
        add(username);

        t.start();


        setVisible(true);

    }
     public static void main(String[] args) {
        new Loading("");
    }
}
