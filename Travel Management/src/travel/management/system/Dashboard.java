package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton viewPersonalDetails, addPersonalDetails,updatePersonalDetails,checkpackages,bookpackages, viewpackages,viewhotels, destination, bookhotel, viewBookedbookhotel;
JButton payments, calculator, notepad, about, deletePersonalDetails;
    Dashboard(String username){
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0, 102));
        p1.setBounds(0,0,1600, 63);
        add(p1);

        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(5, 0, 70, 70);
        p1.add(image);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0, 102));
        p2.setBounds(0,65,300, 900);
        add(p2);

         addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0, 300, 50);
        addPersonalDetails.setBackground(new Color(0, 0, 102));
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);


        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50, 300, 50);
        updatePersonalDetails.setBackground(new Color(0, 0, 102));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);


        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0,100, 300, 50);
        viewPersonalDetails.setBackground(new Color(0, 0, 102));
        viewPersonalDetails.setForeground(Color.white);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,130));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);


         deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,150, 300, 50);
        deletePersonalDetails.setBackground(new Color(0, 0, 102));
        deletePersonalDetails.setForeground(Color.white);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,40));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkpackages = new JButton("Check Package");
        checkpackages.setBounds(0,200, 300, 50);
        checkpackages.setBackground(new Color(0, 0, 102));
        checkpackages.setForeground(Color.white);
        checkpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkpackages.setMargin(new Insets(0,0,0,110));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);

        bookpackages = new JButton("Book Package");
        bookpackages.setBounds(0,250, 300, 50);
        bookpackages.setBackground(new Color(0, 0, 102));
        bookpackages.setForeground(Color.white);
        bookpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookpackages.setMargin(new Insets(0,0,0,120));
        bookpackages.addActionListener(this);
        p2.add(bookpackages);


         viewpackages = new JButton("View Package");
        viewpackages.setBounds(0,300, 300, 50);
        viewpackages.setBackground(new Color(0, 0, 102));
        viewpackages.setForeground(Color.white);
        viewpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewpackages.setMargin(new Insets(0,0,0,120));
        viewpackages.addActionListener(this);
        p2.add(viewpackages);

         viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0,350, 300, 50);
        viewhotels.setBackground(new Color(0, 0, 102));
        viewhotels.setForeground(Color.white);
        viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewhotels.setMargin(new Insets(0,0,0,130));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);

         bookhotel = new JButton("Book Hotels");
        bookhotel.setBounds(0,400, 300, 50);
        bookhotel.setBackground(new Color(0, 0, 102));
        bookhotel.setForeground(Color.white);
        bookhotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookhotel.setMargin(new Insets(0,0,0,140));
        bookhotel.addActionListener(this);
        p2.add(bookhotel);

         viewBookedbookhotel = new JButton("View Booked Hotel");
        viewBookedbookhotel.setBounds(0,450, 300, 50);
        viewBookedbookhotel.setBackground(new Color(0, 0, 102));
        viewBookedbookhotel.setForeground(Color.white);
        viewBookedbookhotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewBookedbookhotel.setMargin(new Insets(0,0,0,70));
        viewBookedbookhotel.addActionListener(this);
        p2.add( viewBookedbookhotel);

         destination = new JButton("Destination");
        destination.setBounds(0,500, 300, 50);
        destination.setBackground(new Color(0, 0, 102));
        destination.setForeground(Color.white);
        destination.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destination.setMargin(new Insets(0,0,0,125));
        destination.addActionListener(this);
        p2.add(destination);

         payments = new JButton("Payment");
        payments.setBounds(0,550, 300, 50);
        payments.setBackground(new Color(0, 0, 102));
        payments.setForeground(Color.white);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
        payments.setMargin(new Insets(0,0,0,155));
        payments.addActionListener(this);
        p2.add(payments);

         calculator = new JButton("Calculator");
        calculator.setBounds(0,600, 300, 50);
        calculator.setBackground(new Color(0, 0, 102));
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculator.setMargin(new Insets(0,0,0,150));
        calculator.addActionListener(this);
        p2.add(calculator);

         notepad = new JButton("Notepad");
        notepad.setBounds(0,650, 300, 50);
        notepad.setBackground(new Color(0, 0, 102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepad.setMargin(new Insets(0,0,0,155));
        notepad.addActionListener(this);
        p2.add(notepad);

         about= new JButton("About");
        about.setBounds(0,700, 300, 50);
        about.setBackground(new Color(0, 0, 102));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        about.setMargin(new Insets(0,0,0,175));
        about.addActionListener(this);
        p2.add(about);


        ImageIcon i4 = new ImageIcon(getClass().getResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(0, 0, 1650, 1000);
        add(image1);

        JLabel text = new JLabel("Travel and Tourism Mamagement System");
        text.setBounds(400, 70, 1200, 70);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway", Font.BOLD, 55));
        image1.add(text);

        setVisible(true);

    }

    @SuppressWarnings("deprecation")
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addPersonalDetails){
            new AddCustomer(username);
        }
        else if(ae.getSource() == viewPersonalDetails){
            new ViewCustomer(username);
        }
        else if(ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(username);
        }
        else if(ae.getSource() == checkpackages){
            new checkPackage();
        }
        else if(ae.getSource()==bookpackages){
            new Bookpakage(username);
        }
        else if(ae.getSource() == viewpackages){
            new ViewPackage(username);
        }
        else if(ae.getSource() == viewhotels){
            new CheckHotels();
        }
        else if(ae.getSource() == destination){
            new Destination();
        }
        else if(ae.getSource() == bookhotel){
            new Bookhotel(username);
        }
        else if(ae.getSource() == viewBookedbookhotel){
            new ViewBookedHotel(username);
        }
        else if(ae.getSource() == payments){
            new Payments();
        }
        else if(ae.getSource() == deletePersonalDetails){
            new DeleteDetails(username);
        }
        else if(ae.getSource() == calculator){
            try{
                Runtime.getRuntime().exec("calc.exe");

            }catch(Exception e){
                e.printStackTrace();

            }
        }
        else if(ae.getSource() == notepad ){
            try{
                Runtime.getRuntime().exec("notepad.exe");


            }catch(Exception e){
                e.printStackTrace();

            }
        }
        else if(ae.getSource() == about){
            new about();
        }
    }
    public static void main(String[] args) {
        new Dashboard("");
    }
}
