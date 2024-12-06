package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class Bookhotel extends JFrame implements ActionListener{
    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    JLabel labeluser, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookpakage, back;
    String username;
    Bookhotel( String username){
        this.username = username;
        setBounds(350, 200, 1100, 600);
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

        chotel = new Choice();
        chotel.setBounds(250, 110, 200, 20);
        add(chotel);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
            


        }catch(Exception e){
e.printStackTrace();
        }


        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40, 150, 150, 25);
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);

        JLabel lbldays = new JLabel("No of Days");
        lbldays.setBounds(40, 190, 150, 25);
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);

        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(40, 230, 150, 25);
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 200, 20);
        add(cac);

        JLabel lblfood = new JLabel("Food Incuded");
        lblfood.setBounds(40, 270, 150, 25);
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfood);

        cfood = new Choice();
        cfood.add("YES");
        cfood.add("NO");
        cfood.setBounds(250, 270, 200, 20);
        add(cfood);






        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40, 310, 150, 20);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);

         labelid = new JLabel();
        labelid.setBounds(250, 310, 200, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40, 350, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnumber);

         labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40, 390, 150, 20);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);

         labelphone = new JLabel();
        labelphone.setBounds(250, 390, 200, 25);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40, 430, 150, 25);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);

         labelprice = new JLabel();
        labelprice.setBounds(250, 430, 150, 25);
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
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpakage = new JButton("Book Hotel");
        bookpakage.setBackground(Color.black);
        bookpakage.setForeground(Color.white);
        bookpakage.setBounds(200, 490, 120, 25);
        bookpakage.addActionListener(this);
        add(bookpakage);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
       back.setBounds(340, 490, 120, 25);
       back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 500, 300);
        add(image);

        


        






        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
       
         if(ae.getSource()==checkprice){
            try{
                Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"'");
            while(rs.next()){
                int cost = rs.getInt("costperperson");
                int ac = rs.getInt("acroom");
                int food = rs.getInt("foodincluded");
                

                int persons = Integer.parseInt(tfpersons.getText());
                int days = Integer.parseInt(tfdays.getText());

                String acselected = cac.getSelectedItem();
                String foodselected = cfood.getSelectedItem();

                if(persons* days > 0){
                    int total = 0;
                    total += acselected.equals("AC") ? ac : 0;
                    total += foodselected.equals("YES") ? food : 0;
                    total += cost;
                    total = total *persons*days;
                    labelprice.setText("Rs " +total);
                    }
                else{
                    JOptionPane.showMessageDialog(null,"Please Enter a valid Number");

                } }
           }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == bookpakage) {
            try {
                Conn c = new Conn();
                String query = "INSERT INTO bookhotel (username, name, persons, days, ac, food, id, number, phone, price) " +
                               "VALUES ('" + labeluser.getText() + "', '" + chotel.getSelectedItem() + "', '" +
                               tfpersons.getText() + "', '" + tfdays.getText() + "', '" + cac.getSelectedItem() + "', '" +
                               cfood.getSelectedItem() + "', '" + labelid.getText() + "', '" +
                               labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labelprice.getText() + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        else{
        setVisible(false);
        }
       
    }
    public static void main(String[] args){
        new Bookhotel("Rubina");

    }
}
