package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class about extends JFrame implements ActionListener{

    about(){
        setBounds(600, 200, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("About");
        l1.setBounds(200, 10, 100, 40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);

        String s = "About Travel Management System\r\n" + //
                        "\r\n" + //
                        "Welcome to the Travel Management System, a comprehensive solution built to streamline your travel booking experience. This application is developed using Java, AWT, and Swing for an intuitive graphical interface and utilizes JDBC for seamless interaction with the underlying database.\r\n" + //
                        "\r\n" + //
                        "With this system, users can:\r\n" + //
                        "\r\n" + //
                        "    Add and Update Customer Information: Effortlessly manage customer profiles, including adding new customers and updating existing records.\r\n" + //
                        "    Book Hotel Packages: Browse available hotel packages, customize options like room type, duration of stay, and additional services, and calculate total booking costs with ease.\r\n" + //
                        "    View and Check Travel Packages: Access details on various travel packages with images and descriptions to make informed decisions.\r\n" + //
                        "    Database Integration: All data is securely stored and retrieved using JDBC, ensuring efficient management of travel-related information.\r\n" + //
                        "\r\n" + //
                        "Thank you for using the Travel Management System. Enjoy a smooth, user-friendly experience for all your travel needs!";

        TextArea area = new TextArea(s,10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        add( area);


        JButton back = new JButton("Back");
        back.setBounds(200, 420, 100, 25);
        back.addActionListener(this);
        add(back);

        setVisible(true);



    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args) {
        new about();
    }
}
