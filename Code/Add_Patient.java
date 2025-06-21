
package h.m.s;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class Add_Patient extends JFrame implements ActionListener {
    private JTextField Namefield,Agefield,DOBfield,phonefield,genderfield;
    private JButton btn1,btn2;
    
    Add_Patient(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(10,10, 450, 530);
        panel1.setBackground(new Color(240, 240, 240));
        
        
        
        
        JLabel title = new JLabel("Patient Form");
        title.setBounds(118,31, 260, 50);
        title.setFont(new Font("Segoe UI", Font.BOLD, 36));
        panel1.add(title);
        
        
        JLabel Namelabel = new JLabel("Patient's Name");
        Namelabel.setBounds(35,120, 200, 16);
        Namelabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(Namelabel);
        
        Namefield = new JTextField();
        Namefield.setBounds(250, 120, 150, 20);
	Namefield.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	Namefield.setBackground(new Color(240, 240, 240));
	panel1.add(Namefield);
        
        
        
        JLabel Agelabel = new JLabel("Patient's Age");
        Agelabel.setBounds(35,170, 200, 16);
        Agelabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(Agelabel);
        
        Agefield = new JTextField();
        Agefield.setBounds(250, 170, 150, 20);
	Agefield.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	Agefield.setBackground(new Color(240, 240, 240));
	panel1.add(Agefield);
        
        
        JLabel DOBlabel = new JLabel("Patient's DOB");
        DOBlabel.setBounds(35,220, 200, 16);
        DOBlabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(DOBlabel);
        
        DOBfield = new JTextField();
        DOBfield.setBounds(250, 220, 150, 20);
	DOBfield.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	DOBfield.setBackground(new Color(240, 240, 240));
	panel1.add(DOBfield);
        
                
        JLabel genderlabel = new JLabel("Patient's Gender");
        genderlabel.setBounds(35,270, 200, 16);
        genderlabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(genderlabel);
        
        genderfield = new JTextField();
        genderfield.setBounds(250, 270, 150, 20);
	genderfield.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	genderfield.setBackground(new Color(240, 240, 240));
	panel1.add(genderfield);
        
        JLabel phonelabel = new JLabel("Patient's Phone Number");
        phonelabel.setBounds(35,320, 200, 16);
        phonelabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(phonelabel);
        
        phonefield = new JTextField();
        phonefield.setBounds(250, 320, 150, 20);
	phonefield.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	phonefield.setBackground(new Color(240, 240, 240));
	panel1.add(phonefield);
        add(panel1);
        
        
        btn1 = new JButton("Add");
        btn1.setBounds(35,420,120,30);
        btn1.setBackground(new Color(143, 188, 143));
        btn1.addActionListener(this);
        panel1.add(btn1);
        
        btn2 = new JButton("Back");
        btn2.setBounds(270,420,120,30);
        btn2.setBackground(new Color(143, 188, 143));
        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                   dispose();
            }
        });
        panel1.add(btn2);
        
        
        
        ImageIcon imageicon = new ImageIcon(getClass().getResource("/icon/icon2.png"));
	Image i1 = imageicon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
	ImageIcon imageicon1 = new ImageIcon(i1);
	JLabel Imagelabel = new JLabel(imageicon1);
	Imagelabel.setBounds(550, 150, 200, 200);
	add(Imagelabel);
        
        
        
        
        
        
    
        getContentPane().setBackground(new Color(140, 180, 140));
	setTitle("Medix");
	setSize(850, 550);
        setUndecorated(true);
	setLayout(null);
        setResizable(false);
        setVisible(true);
	setLocation(320,220);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
		new Add_Patient();
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            
            
            String AgeText = Agefield.getText();
            int Age = Integer.parseInt(AgeText);
            String Name = Namefield.getText();
            String DOB = DOBfield.getText();
            String phone = phonefield.getText();
            String gender = genderfield.getText();
            
            String q = "INSERT INTO  Patient(P_Name, Age,DOB, Gender, Phone)VALUES(?,?,?,?,?)                                                           ";
      try {
            conn c = new conn();

            
            PreparedStatement pst = c.connection.prepareStatement(q);
            
            pst.setString(1,Name);
            pst.setInt(2,Age);
            pst.setString(3,DOB);
            pst.setString(4,gender);
            pst.setString(5, phone);

                int rs = pst.executeUpdate();
            if (rs>0){
                dispose();
                new Add_Patient();
                JOptionPane.showMessageDialog(this, "Added Successfully");
            } else {
                dispose();
                new Add_Patient();
                JOptionPane.showMessageDialog(this, "Sorry");
            }

            pst.close();
            c.connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }
            
           
        
        
        
        
        
        
        }
    }

