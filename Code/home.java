
package h.m.s;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class home extends JFrame implements ActionListener {
    home(){
        JPanel nav = new JPanel();
        nav.setLayout(null);
        nav.setBounds(0,0,250,1080);
        nav.setBackground(new Color(100, 140, 100));
        add(nav);
        
        
        JLabel title = new JLabel("Medix");
        title.setBounds(20,140, 200, 150);
        title.setFont(new Font("Segoe UI", Font.BOLD, 60));
        title.setForeground(new Color(44, 44, 44));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
	nav.add(title);
        
        ImageIcon imageicon = new ImageIcon(getClass().getResource("/icon/icon1.png"));
	Image i1 = imageicon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
	ImageIcon imageicon1 = new ImageIcon(i1);
	JLabel Imagelabel = new JLabel(imageicon1);
	Imagelabel.setBounds(25,-10, 200, 200);
	nav.add(Imagelabel);
 

        JPanel patients = new JPanel();
        patients.setLayout(null);
        patients.setBounds(260,50,300,200);
        patients.setBackground(new Color(100, 140, 100));
        add(patients);
        
        ImageIcon imageicon2 = new ImageIcon(getClass().getResource("/icon/icon7.png"));
	Image i2 = imageicon2.getImage().getScaledInstance(64,64,Image.SCALE_DEFAULT);
	ImageIcon imageicon3 = new ImageIcon(i2);
	JLabel Imagelabel1 = new JLabel(imageicon3);
	Imagelabel1.setBounds(25,20,64,64);
	patients.add(Imagelabel1);
        
        JLabel patientstext = new JLabel("Total Patient");
        patientstext.setBounds(25,60,200,100);
        patientstext.setFont(new Font("Segoe UI", Font.BOLD, 20));
        patientstext.setForeground(new Color(0,0,0));
        patients.add(patientstext);
        
        
        JLabel patientsinfo = new JLabel("Loading......");
        patientsinfo.setBounds(25,110,400,100);
        patientsinfo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        patientsinfo.setForeground(new Color(0,0,0));
        patients.add(patientsinfo);
        
        
        
        try{
            conn c = new conn();
            
            String q = "SELECT COUNT(P_ID) AS total FROM Patient;";
            PreparedStatement pst = c.connection.prepareStatement(q);
            ResultSet re = pst.executeQuery();

            if (re.next()) {
               int totalPatients = re.getInt("total");
            animateCount(patientsinfo, totalPatients, 1500);
              }
        
        
        }catch(Exception e){
        
            e.printStackTrace();
        }
        
 
        JPanel doctors = new JPanel();
        doctors.setLayout(null);
        doctors.setBounds(580,50,300,200);
        doctors.setBackground(new Color(100, 140, 100));
        add(doctors);
        
        ImageIcon imageicon4 = new ImageIcon(getClass().getResource("/icon/icon8.png"));
	Image i4 = imageicon4.getImage().getScaledInstance(64,64,Image.SCALE_DEFAULT);
	ImageIcon imageicon5 = new ImageIcon(i4);
	JLabel Imagelabel2 = new JLabel(imageicon4);
	Imagelabel2.setBounds(25,20,64,64);
	doctors.add(Imagelabel2);
        
        JLabel doctorstext = new JLabel("Total Doctor");
        doctorstext.setBounds(25,60,200,100);
        doctorstext.setFont(new Font("Segoe UI", Font.BOLD, 20));
        doctorstext.setForeground(new Color(0,0,0));
        doctors.add(doctorstext);
        
        JLabel doctorsinfo = new JLabel("Loading......");
        doctorsinfo.setBounds(25,110,400,100);
        doctorsinfo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        doctorsinfo.setForeground(new Color(0,0,0));
        doctors.add(doctorsinfo);
        try{
            conn c = new conn();
            
            String q = "SELECT COUNT(D_ID) AS total FROM Doctor;";
            PreparedStatement pst = c.connection.prepareStatement(q);
            ResultSet re = pst.executeQuery();

            if (re.next()) {
               int totaldoctor = re.getInt("total");
            animateCount(doctorsinfo, totaldoctor, 1500);
              }
        
        
        }catch(Exception e){
        
            e.printStackTrace();
        }

        JPanel employees = new JPanel();
        employees.setLayout(null);
        employees.setBounds(900,50,300,200);
        employees.setBackground(new Color(100, 140, 100));
        add(employees);
        
        ImageIcon imageicon6 = new ImageIcon(getClass().getResource("/icon/icon9.png"));
	Image i6 = imageicon6.getImage().getScaledInstance(64,64,Image.SCALE_DEFAULT);
	ImageIcon imageicon7 = new ImageIcon(i6);
	JLabel Imagelabel3 = new JLabel(imageicon7);
	Imagelabel3.setBounds(25,20,64,64);
	employees.add(Imagelabel3);
        
        JLabel employeestext = new JLabel("Total Employee");
        employeestext.setBounds(25,60,200,100);
        employeestext.setFont(new Font("Segoe UI", Font.BOLD, 20));
        employeestext.setForeground(new Color(0,0,0));
        employees.add(employeestext);
        
        JLabel employeesinfo = new JLabel("Loading......");
        employeesinfo.setBounds(25,110,400,100);
        employeesinfo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        employeesinfo.setForeground(new Color(0,0,0));
        employees.add(employeesinfo);
        try{
            conn c = new conn();
            
            String q = "SELECT(SELECT count(D_ID) FROM Doctor)+(SELECT count(E_ID) FROM Employee) AS total;";
            PreparedStatement pst = c.connection.prepareStatement(q);
            ResultSet re = pst.executeQuery();

            if (re.next()) {
               int totalEmployees = re.getInt("total");
            animateCount(employeesinfo, totalEmployees, 1500);
              }
        
        
        }catch(Exception e){
        
            e.printStackTrace();
        }
        
        
        
        
        JPanel appointments = new JPanel();
        appointments.setLayout(null);
        appointments.setBounds(1220,50,300,200);
        appointments.setBackground(new Color(100, 140, 100));
        add(appointments);

        ImageIcon imageicon8 = new ImageIcon(getClass().getResource("/icon/icon10.png"));
	Image i8 = imageicon8.getImage().getScaledInstance(64,64,Image.SCALE_DEFAULT);
	ImageIcon imageicon9 = new ImageIcon(i8);
	JLabel Imagelabel4 = new JLabel(imageicon9);
	Imagelabel4.setBounds(25,20,64,64);
	appointments.add(Imagelabel4);
        
        JLabel appointtext = new JLabel("Appointment");
        appointtext.setBounds(25,60,200,100);
        appointtext.setFont(new Font("Segoe UI", Font.BOLD, 20));
        appointtext.setForeground(new Color(0,0,0));
        appointments.add(appointtext);
        
        JLabel appointsinfo = new JLabel("Loading......");
        appointsinfo.setBounds(25,110,400,100);
        appointsinfo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        appointsinfo.setForeground(new Color(0,0,0));
        appointments.add(appointsinfo);
        try{
            conn c = new conn();
            
            String q = "SELECT COUNT(APP_ID) AS total FROM Appointments;";
            PreparedStatement pst = c.connection.prepareStatement(q);
            ResultSet re = pst.executeQuery();

            if (re.next()) {
               int totalAppoint = re.getInt("total");
            animateCount(appointsinfo, totalAppoint, 1500);
              }
        
        
        }catch(Exception e){
        
            e.printStackTrace();
        }






        
        
        JButton btn1 = new JButton("Patient");
        btn1.setBounds(45,350,150, 30);
        btn1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn1.setBackground(new Color(143, 188, 143));
        btn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_info();
            }
        });
        nav.add(btn1);
        
        
        JButton btn2 = new JButton("Doctor info");
        btn2.setBounds(45,400,150, 30);
        btn2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn2.setBackground(new Color(143, 188, 143));
        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Doctor_info();
            }
        });
        nav.add(btn2);

        
        JButton btn3 = new JButton("Employee Info");
        btn3.setBounds(45,450,150, 30);
        btn3.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn3.setBackground(new Color(143, 188, 143));
        btn3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               new Employee_info();
            }
        });
        nav.add(btn3);
        
        
        JButton btn4 = new JButton("Appointments");
        btn4.setBounds(45,500,150, 30);
        btn4.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn4.setBackground(new Color(143, 188, 143));
        btn4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Appointment_info();
            }
        });
        nav.add(btn4);
        
        JButton btn5 = new JButton("Bill Info");
        btn5.setBounds(45,550,150, 30);
        btn5.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn5.setBackground(new Color(143, 188, 143));
        btn5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
         
            }
        });
        nav.add(btn5);
        
        
        JButton btn6 = new JButton("Logout");
        btn6.setBounds(45,700,150, 30);
        btn6.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn6.setBackground(new Color(143, 188, 143));
        btn6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    dispose();
                    new Login();
            }
        });
        nav.add(btn6);
        
        JButton btn7 = new JButton("Refresh");
        btn7.setBounds(45,660,150,30);
        btn7.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn7.setBackground(new Color(143, 188, 143));
        btn7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    dispose();
                    new home();
                }
            
            
            
            });
         nav.add(btn7);
         JLabel r_patient = new JLabel("Recent Patient");
         r_patient.setBounds(285,300,400,50);
         r_patient.setFont(new Font("Segoe UI", Font.BOLD, 20));
         r_patient.setForeground(new Color(0,0,0));
         add(r_patient);
         
         
         
         
         
         
         JTable info_table = new JTable();
         info_table.setBounds(285,350,1200,420);
         info_table.setBackground(Color.white);
         info_table.setFont(new Font("Segoe UI", Font.BOLD, 14));
            
         JScrollPane scrollPane = new JScrollPane(info_table);
         scrollPane.setBounds(285,350, 1200, 420);
         add(scrollPane);
           
            try{
                conn c = new conn();
                
                String q = "SELECT * FROM (SELECT TOP 20 * FROM Patient ORDER BY P_ID DESC)AS recent ORDER BY P_ID ASC;";

                
               PreparedStatement pst = c.connection.prepareStatement(q);
                
               ResultSet rs = pst.executeQuery();
               
               info_table.setModel(DbUtils.resultSetToTableModel(rs));
               
                
            
            
            }catch(Exception e){
            
                e.printStackTrace();
            }
        
   	getContentPane().setBackground(new Color(143, 188, 143));
	setTitle("Medix");
	setSize(1920, 1080);
	setLayout(null);
        setResizable(true);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
                
    }
    public static void main(String[] args){
        new home();
    
    
    }
    public void animateCount(JLabel label, int target, int durationMs) {
    int delay = 20;
    int steps = durationMs / delay;
    double increment = (double) target / steps;

    Timer timer = new Timer(delay, null);
    final double[] count = {0};

    timer.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            count[0] += increment;
            if (count[0] >= target) {
                label.setText(String.valueOf(target));
                timer.stop();
            } else {
                label.setText(String.valueOf((int) count[0]));
            }
        }
    });

    timer.start();
}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
