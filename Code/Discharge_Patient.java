
package h.m.s;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class Discharge_Patient extends JFrame implements ActionListener {
    private JTextField Namefield,Agefield,DOBfield,phonefield,genderfield;
    private JButton btn1,btn2,btn3;
    private Choice idchoice; 
    
    Discharge_Patient(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(10,10, 450, 530);
        panel1.setBackground(new Color(240, 240, 240));
        
        
        
        
        JLabel title = new JLabel("Discharge Patient");
        title.setBounds(60,31,600, 50);
        title.setFont(new Font("Segoe UI", Font.BOLD, 36));
        panel1.add(title);
        
        JLabel IDlabel = new JLabel("Patient's ID");
        IDlabel.setBounds(35,120, 200, 16);
        IDlabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(IDlabel);
        
        idchoice = new Choice();
        idchoice.setBounds(250, 120, 150, 20);
	idchoice.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	idchoice.setBackground(new Color(255, 255, 255));
        panel1.add(idchoice);
        
        try{
            conn c = new conn();
            String q = "SELECT * FROM Patient;";
            PreparedStatement pst = c.connection.prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                idchoice.add(rs.getString("P_ID"));
            
            
            }
        }catch(Exception e){
        
        
        }                
        
        
        
        
        JLabel Namelabel = new JLabel("Patient's Name");
        Namelabel.setBounds(35,170, 200, 16);
        Namelabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(Namelabel);
        
        Namefield = new JTextField();
        Namefield.setBounds(250, 170, 150, 20);
	Namefield.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	Namefield.setBackground(new Color(240, 240, 240));
	panel1.add(Namefield);
        
        
        
        JLabel Agelabel = new JLabel("Patient's Age");
        Agelabel.setBounds(35,220, 200, 16);
        Agelabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(Agelabel);
        
        Agefield = new JTextField();
        Agefield.setBounds(250, 220, 150, 20);
	Agefield.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	Agefield.setBackground(new Color(240, 240, 240));
	panel1.add(Agefield);
        
        
        JLabel DOBlabel = new JLabel("Patient's DOB");
        DOBlabel.setBounds(35,270, 200, 16);
        DOBlabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(DOBlabel);
        
        DOBfield = new JTextField();
        DOBfield.setBounds(250, 270, 150, 20);
	DOBfield.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	DOBfield.setBackground(new Color(240, 240, 240));
	panel1.add(DOBfield);
        
                
        JLabel genderlabel = new JLabel("Patient's Gender");
        genderlabel.setBounds(35,320, 200, 16);
        genderlabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(genderlabel);
        
        genderfield = new JTextField();
        genderfield.setBounds(250, 320, 150, 20);
	genderfield.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	genderfield.setBackground(new Color(240, 240, 240));
	panel1.add(genderfield);
        
        JLabel phonelabel = new JLabel("Patient's Phone Number");
        phonelabel.setBounds(35,370, 200, 16);
        phonelabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(phonelabel);
        
        phonefield = new JTextField();
        phonefield.setBounds(250, 370, 150, 20);
	phonefield.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	phonefield.setBackground(new Color(240, 240, 240));
	panel1.add(phonefield);
        add(panel1);
        
        
        btn1 = new JButton("Discharge");
        btn1.setBounds(33,420,120,30);
        btn1.setBackground(new Color(143, 188, 143));
        btn1.addActionListener(this);
        panel1.add(btn1);
        
        btn2 = new JButton("Back");
        btn2.setBounds(279,420,120,30);
        btn2.setBackground(new Color(143, 188, 143));
        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                   dispose();
            }
        });
        panel1.add(btn2);
        
        btn3 = new JButton("Check");
        btn3.setBounds(156,420,120,30);
        btn3.setBackground(new Color(143, 188, 143));
        btn3.addActionListener(this);
        panel1.add(btn3);
        
        
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
		new Discharge_Patient();
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            
            String IDText = idchoice.getSelectedItem();
            int ID = Integer.parseInt(IDText);
            
            String q = "DELETE FROM Patient WHERE P_ID = ?;";
            String q1 = "DELETE FROM Appointments WHERE P_ID = ?;";
      try {
            conn c = new conn();

            
            PreparedStatement pst = c.connection.prepareStatement(q);
            PreparedStatement pst1 = c.connection.prepareStatement(q1);
            pst.setInt(1, ID);
            pst1.setInt(1, ID);
            
                int rs1 = pst1.executeUpdate();
                int rs = pst.executeUpdate();
               
            if (rs>0){
                JOptionPane.showMessageDialog(this, "Patient has been Discharged Successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Sorry");
            }
            if (rs1>0){
                JOptionPane.showMessageDialog(this, "Appointments Related to this Patient have been removed");
            } else {
                JOptionPane.showMessageDialog(this, "Sorry");
            }

            pst.close();
            pst1.close();
            c.connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }
           if(e.getSource()==btn3){
            
            String IDText = idchoice.getSelectedItem();
            int ID = Integer.parseInt(IDText);
  
            String q = "SELECT * FROM Patient WHERE P_ID = ?;";
      try {
            conn c = new conn();

            
            PreparedStatement pst = c.connection.prepareStatement(q);
            pst.setInt(1,ID);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
            Namefield.setText(rs.getString("P_Name"));
            Agefield.setText(rs.getString("Age"));
            DOBfield.setText(rs.getString("DOB"));
            phonefield.setText(rs.getString("Phone"));
            genderfield.setText(rs.getString("Gender"));
            } else {
                JOptionPane.showMessageDialog(this, "No patient found with ID: " + ID);
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
