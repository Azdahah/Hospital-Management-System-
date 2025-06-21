package h.m.s;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class Add_Appointment extends JFrame implements ActionListener {
    private JTextField AppointmentDate,AppointmentTime;
    private JButton btn1,btn2;
    private Choice patientidchoice,doctoridchoice; 
    
    Add_Appointment(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(10,10, 450, 530);
        panel1.setBackground(new Color(240, 240, 240));
        
        
        
        
        JLabel title = new JLabel("Add Appointments");
        title.setBounds(20,31,600, 50);
        title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        panel1.add(title);
        
        JLabel P_IDlabel = new JLabel("Patient's ID");
        P_IDlabel.setBounds(35,120, 200, 16);
        P_IDlabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(P_IDlabel);
        
        patientidchoice = new Choice();
        patientidchoice.setBounds(250, 120, 150, 20);
	patientidchoice.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	patientidchoice.setBackground(new Color(255, 255, 255));
        panel1.add(patientidchoice);
        
        try{
            conn c = new conn();
            String q = "SELECT * FROM Patient;";
            PreparedStatement pst = c.connection.prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                patientidchoice.add(rs.getString("P_ID"));
            
            
            }
        }catch(Exception e){
        
        
        }                
        JLabel P_Namelabel = new JLabel("Patient's Name");
        P_Namelabel.setBounds(35,170, 200, 16);
        P_Namelabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(P_Namelabel);
        
        JTextField P_Name = new JTextField();
        P_Name.setBounds(250,170, 150, 20);
	P_Name.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	P_Name.setBackground(new Color(240, 240, 240));
	panel1.add(P_Name);
    patientidchoice.addItemListener(e -> {    
        try{
            String IDText = patientidchoice.getSelectedItem();
            int ID = Integer.parseInt(IDText);;
            conn c = new conn();
            String query = "SELECT * FROM Patient Where P_ID = ?;";
            PreparedStatement pst = c.connection.prepareStatement(query);
            pst.setInt(1,ID);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                P_Name.setText(rs.getString("P_Name"));
            }
            
            
        
        }catch(Exception ex){
                ex.printStackTrace();
        }
        
    });
        
        
        
        JLabel D_IDlabel = new JLabel("Doctor's ID");
        D_IDlabel.setBounds(35,220, 200, 16);
        D_IDlabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(D_IDlabel);
        
        
        doctoridchoice = new Choice();
        doctoridchoice.setBounds(250,220, 150, 20);
	doctoridchoice.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	doctoridchoice.setBackground(new Color(255, 255, 255));
        panel1.add(doctoridchoice);
        
        try{
            conn c = new conn();
            String q = "SELECT * FROM Doctor;";
            PreparedStatement pst = c.connection.prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                doctoridchoice.add(rs.getString("D_ID"));
            
            
            }
        }catch(Exception e){
        
            e.printStackTrace();
        }                
        JLabel D_Namelabel = new JLabel("Doctor's Name");
        D_Namelabel.setBounds(35,270, 200, 16);
        D_Namelabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(D_Namelabel);
        
        JTextField D_Name = new JTextField();
        D_Name.setBounds(250,270, 150, 20);
	D_Name.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	D_Name.setBackground(new Color(240, 240, 240));
	panel1.add(D_Name);
            doctoridchoice.addItemListener(e -> {    
        try{
            String IDText = doctoridchoice.getSelectedItem();
            int ID = Integer.parseInt(IDText);;
            conn c = new conn();
            String query = "SELECT * FROM Doctor Where D_ID = ?;";
            PreparedStatement pst = c.connection.prepareStatement(query);
            pst.setInt(1,ID);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                D_Name.setText(rs.getString("D_Name"));
            }
            
            
        
        }catch(Exception ex){
                ex.printStackTrace();
        }
        
    });
        
        
        JLabel Datelabel = new JLabel("Appointment Date");
        Datelabel.setBounds(35,320, 200, 16);
        Datelabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(Datelabel);
        
        AppointmentDate = new JTextField();
        AppointmentDate.setBounds(250, 320, 150, 20);
	AppointmentDate.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	AppointmentDate.setBackground(new Color(240, 240, 240));
	panel1.add(AppointmentDate);
        
        
        JLabel Timelabel = new JLabel("Appointment Time");
        Timelabel.setBounds(35,370, 200, 16);
        Timelabel.setFont(new Font("Segoe UI", Font.BOLD,14));
        panel1.add(Timelabel);
        
        AppointmentTime = new JTextField();
        AppointmentTime.setBounds(250, 370, 150, 20);
	AppointmentTime.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	AppointmentTime.setBackground(new Color(240, 240, 240));
	panel1.add(AppointmentTime);
        
        
        
        btn1 = new JButton("Add");
        btn1.setBounds(33,470,120,30);
        btn1.setBackground(new Color(143, 188, 143));
        btn1.addActionListener(this);
        panel1.add(btn1);
        
        btn2 = new JButton("Back");
        btn2.setBounds(279,470,120,30);
        btn2.setBackground(new Color(143, 188, 143));
        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                   dispose();
            }
        });
        panel1.add(btn2);
        
        
        
        ImageIcon imageicon = new ImageIcon(getClass().getResource("/icon/icon6.png"));
	Image i1 = imageicon.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
	ImageIcon imageicon1 = new ImageIcon(i1);
	JLabel Imagelabel = new JLabel(imageicon1);
	Imagelabel.setBounds(470, 80, 400, 400);
	add(Imagelabel);
        
        
        
        add(panel1);
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
		new Add_Appointment();
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            
            String P_IDText = patientidchoice.getSelectedItem();
            int P_ID = Integer.parseInt(P_IDText);
                        
            String D_IDText = doctoridchoice.getSelectedItem();
            int D_ID = Integer.parseInt(D_IDText);
            String dateText = AppointmentDate.getText();
            String TimeText = AppointmentTime.getText();
            
            String q = "INSERT INTO Appointments(APP_Date,APP_Time,P_ID,D_ID)VALUES(?,?,?,?)";
      try {
            conn c = new conn();

            
            PreparedStatement pst = c.connection.prepareStatement(q);
            
            pst.setString(1,dateText);
            pst.setString(2,TimeText);
            pst.setInt(3,P_ID);
            pst.setInt(4,D_ID);
            

                int rs = pst.executeUpdate();
            if (rs>0){
                dispose();
                new Add_Appointment();
                JOptionPane.showMessageDialog(this, "Added Successfully");
            } else {
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
