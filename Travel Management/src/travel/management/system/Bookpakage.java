package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class Bookpakage extends JFrame implements ActionListener{
    Choice cpackage;
    JTextField tfpersons;
    JLabel labeluser, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookpakage, back;
    String username;
    Bookpakage( String username){
        this.username = username;
        setBounds(350, 200, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);

        labeluser = new JLabel();
        labeluser.setBounds(250, 70, 100, 20);
        labeluser.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labeluser);

        JLabel lbpackage  = new JLabel("Select Package");
        lbpackage.setBounds(40, 110, 200, 20);
        lbpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbpackage);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250, 110, 200, 20);
        add(cpackage);

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40, 150, 150, 25);
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40, 190, 150, 20);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);

         labelid = new JLabel();
        labelid.setBounds(250, 190, 200, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40, 230, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnumber);

         labelnumber = new JLabel();
        labelnumber.setBounds(250, 230, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40, 270, 150, 20);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);

         labelphone = new JLabel();
        labelphone.setBounds(250, 270, 200, 25);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40, 310, 150, 25);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);

         labelprice = new JLabel();
        labelprice.setBounds(250, 310, 150, 25);
        add(labelprice);

        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labeluser.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }


        }catch(Exception e){
            e.printStackTrace();

        }
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.black);
        checkprice.setForeground(Color.white);
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpakage = new JButton("Book Package");
        bookpakage.setBackground(Color.black);
        bookpakage.setForeground(Color.white);
        bookpakage.setBounds(200, 380, 120, 25);
        bookpakage.addActionListener(this);
        add(bookpakage);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
       back.setBounds(340, 380, 120, 25);
       back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 500, 300);
        add(image);

        


        






        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == bookpakage){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labeluser.getText()+"','"+cpackage.getSelectedItem()+"', '"+tfpersons.getText()+"','"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Package Booked Successfully" );
                setVisible(false);

            }catch(Exception e){
               e.printStackTrace();
            }

        }
        else if(ae.getSource()==checkprice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){
                cost += 12000;

            }
            else if(pack.equals("Bronze Package")){
                cost += 25000;
            

            }
            else{
                cost += 32000;

            }

            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labelprice.setText("Rs" + cost);

        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Bookpakage("Rubina");

    }
}
