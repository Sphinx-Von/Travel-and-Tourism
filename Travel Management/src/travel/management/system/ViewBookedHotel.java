package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener{
    JButton back;
ViewBookedHotel(String username){
    setBounds(400, 200, 1000, 600);
    getContentPane().setBackground(Color.white);
    setLayout(null);
    JLabel text = new JLabel("VIEW BOOKED HOTEL DETAIL");
    text.setFont(new Font("Tahoma", Font.BOLD, 20));
    text.setBounds(60, 0, 400, 30);
    add(text);

    JLabel lblusername = new JLabel("Username");
    lblusername.setBounds(30, 50, 150, 25);
    add(lblusername);

    JLabel labelusername = new JLabel();
    labelusername.setBounds(220, 50, 150, 25);
    add(labelusername);

    JLabel labelpackage = new JLabel("Hotel Name");
    labelpackage.setBounds(30, 90, 150, 25);
    add(labelpackage);

    JLabel labelidp = new JLabel();
    labelidp.setBounds(220, 90, 150, 25);
    add(labelidp);

    JLabel labelpersons = new JLabel("Total Persons");
    labelpersons.setBounds(30, 130, 150, 25);
    add(labelpersons);

    JLabel labelnumbers = new JLabel();
    labelnumbers.setBounds(220, 130, 150, 25);
    add(labelnumbers);


    JLabel lbldays = new JLabel("Total Days");
    lbldays.setBounds(30, 170, 150, 25);
    add(lbldays);

    JLabel labeldays = new JLabel();
    labeldays.setBounds(220, 170, 150, 25);
    add(labeldays);

    JLabel lblac = new JLabel("AC/Non-AC");
    lblac.setBounds(30, 210, 150, 25);
    add(lblac);

    JLabel labelac = new JLabel();
    labelac.setBounds(220, 210, 150, 25);
    add(labelac);

    JLabel lblfood = new JLabel("Food Included ?");
    lblfood.setBounds(30, 250, 150, 25);
    add(lblfood);

    JLabel labelfood = new JLabel();
    labelfood.setBounds(220, 250, 150, 25);
    add(labelfood);

    JLabel labelid = new JLabel("Id");
    labelid.setBounds(30, 290, 150, 25);
    add(labelid);

    JLabel labelname = new JLabel();
    labelname.setBounds(220, 290, 150, 25);
    add(labelname);

    JLabel labelnumber = new JLabel("Number");
    labelnumber.setBounds(30,330 , 150, 25);
    add(labelnumber);

    JLabel labelgender = new JLabel();
    labelgender.setBounds(220, 330, 150, 25);
    add(labelgender);

    JLabel labelphone = new JLabel("Phone");
    labelphone.setBounds(30, 370, 150, 25);
    add(labelphone);

    JLabel labelcountry = new JLabel();
    labelcountry.setBounds(220, 370, 150, 25);
    add(labelcountry);


    JLabel labelprice = new JLabel("Total Cost");
    labelprice.setBounds(30, 410, 150, 25);
    add(labelprice);

    JLabel labeladdress = new JLabel();
    labeladdress.setBounds(220, 410, 150, 25);
    add(labeladdress);

   

    back = new JButton("Back");
    back.setBackground(Color.black);
    back.setForeground(Color.white);
    back.setBounds(130, 460, 100, 25);
    back.addActionListener(this);
    add(back);

    ImageIcon i1 = new ImageIcon(getClass().getResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 500, 400);
        add(image);

        

        try{
            Conn c = new Conn();
            String query = "select * from bookhotel where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("id"));
                labelgender.setText(rs.getString("number"));
                labelidp.setText(rs.getString("name"));
                labeladdress.setText(rs.getString("price"));
                labelcountry.setText(rs.getString("phone"));
                labelnumbers.setText(rs.getString("persons"));
                labelfood.setText(rs.getString("food"));
                labelac.setText(rs.getString("ac"));
                labeldays.setText(rs.getString("days"));
               
            }


        }catch(Exception e){
            e.printStackTrace();

        }





    setVisible(true);


}

public void actionPerformed(ActionEvent ae){
    setVisible(false);

}

public static void main(String[] args) {
    new ViewBookedHotel("Rubina");
}
    
}
