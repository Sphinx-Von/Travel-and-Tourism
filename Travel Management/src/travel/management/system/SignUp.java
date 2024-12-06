package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;


public class SignUp extends JFrame implements ActionListener {
    JButton create, back;
    JTextField tf, ff, tfu;
    JPasswordField tff;  // Updated for password field
    Choice security1;

    SignUp() {
        getContentPane().setBackground(Color.white);
        setBounds(350, 200, 900, 360);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

        JLabel username = new JLabel("Username");
        username.setBounds(50, 20, 120, 25);
        username.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        p1.add(username);

        tf = new JTextField();
        tf.setBounds(190, 20, 180, 25);
        tf.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tf);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 60, 125, 25);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        p1.add(name);

        ff = new JTextField();
        ff.setBounds(190, 60, 180, 25);
        ff.setBorder(BorderFactory.createEmptyBorder());
        p1.add(ff);

        JLabel pw = new JLabel("Password");
        pw.setBounds(50, 100, 120, 25);
        pw.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        p1.add(pw);

        tff = new JPasswordField();  // Updated to JPasswordField
        tff.setBounds(190, 100, 180, 25);
        tff.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tff);

        JLabel security = new JLabel("Security Question");
        security.setBounds(50, 140, 125, 25);
        security.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        p1.add(security);

        security1 = new Choice();
        security1.add("What is your favorite movie?");
        security1.add("What is your favorite Icecream?");
        security1.add("What is your childhood Superhero?");
        security1.add("Who is your favorite Teacher?");
        security1.setBounds(190, 140, 180, 25);
        p1.add(security1);

        JLabel ans = new JLabel("Answer");
        ans.setBounds(50, 180, 125, 25);
        ans.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        p1.add(ans);

        tfu = new JTextField();
        tfu.setBounds(190, 180, 180, 25);
        tfu.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfu);

        create = new JButton("Create");
        create.setBounds(80, 250, 100, 30);
        create.setForeground(new Color(131, 193, 233));
        create.setBackground(Color.white);
        create.setBorder(new LineBorder(new Color(131, 193, 233)));
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBounds(250, 250, 100, 30);
        back.setForeground(new Color(131, 193, 233));
        back.setBackground(Color.white);
        back.setBorder(new LineBorder(new Color(131, 193, 233)));
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String username = tf.getText();
            String name = ff.getText();
            String password = new String(tff.getPassword());  // Securely retrieve password
            String security = security1.getSelectedItem();
            String answer = tfu.getText();

            String query = "insert into account values('"+username+"','"+name+"', '"+password+"', '"+security+"', '"+answer+"')";
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "Account successfully Created");
                setVisible(false);
                new Login();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
