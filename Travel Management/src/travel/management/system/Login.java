package travel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;


public class Login extends JFrame implements ActionListener{
    JButton login, signup, pw;
    JTextField tf, tm;

    Login (){

        getContentPane().setBackground(Color.WHITE);
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        

        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setBounds(400, 30, 450, 300);
        p2.setLayout(null);
        add(p2);

        JLabel username = new JLabel("Username");
        username.setBounds(60, 20, 100, 25);
        username.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(username);

        tf = new JTextField();
        tf.setBounds(60, 60, 300, 30);
        tf.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tf);

        JLabel password = new JLabel("Password");
        password.setBounds(60, 110, 100, 25);
        password.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(password);

        tm = new JTextField();
        tm.setBounds(60, 150, 300, 30);
         tm.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tm);

         login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setForeground(Color.WHITE);
        login.setBackground(new Color(131, 193, 233));
        login.setBorder(new LineBorder(new Color(131, 193, 233)));
        login.addActionListener(this);
        p2.add(login);

         signup = new JButton("Signup");
        signup.setBounds(230, 200, 130, 30);
        signup .setForeground(Color.WHITE);
        signup .setBackground(new Color(131, 193, 233));
        signup .setBorder(new LineBorder(new Color(131, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup );

         pw = new JButton("Forgot Password");
        pw.setBounds(130, 250, 130, 30);
        pw .setForeground(Color.WHITE);
        pw .setBackground(new Color(131, 193, 233));
        pw .setBorder(new LineBorder(new Color(131, 193, 233)));
        pw.addActionListener(this);
        
        p2.add(pw);

       JLabel text = new JLabel("Trouble in Sign-in?");
       text.setBounds(300,250,150,20);
       text.setForeground(Color.red);
       p2.add(text);



        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
                String username = tf.getText();
                String password = tm.getText();

                String query = "select * from account where username = '"+username+"'AND password = '"+password+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect username Or Password");
                }


            }catch(Exception e){
                e.printStackTrace();

            }

        }else if(ae.getSource() == signup){
            setVisible(false);
            new SignUp();

        }
        else{
            setVisible(false);
            new ForgetPassword();

        }
    }

   
    public static void main(String[] args) {
        new Login();
    }
}
