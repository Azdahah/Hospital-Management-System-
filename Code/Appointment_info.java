package h.m.s;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class Appointment_info extends JFrame implements ActionListener{
        
        Appointment_info(){
            
            JPanel panel1 = new JPanel();
            panel1.setLayout(null);
            panel1.setBounds(5,600,990,50);
            panel1.setBackground(new Color(100, 140, 100));
            
            
            JLabel title = new JLabel("Appointments' Information");
            title.setLayout(null);
            title.setBounds(80,10,500,50);
            title.setFont(new Font("Segoe UI", Font.BOLD, 36));
            add(title);
            
            ImageIcon imageicon = new ImageIcon(getClass().getResource("/icon/icon3.png"));
            Image i1 = imageicon.getImage().getScaledInstance(175,80,Image.SCALE_DEFAULT);
            ImageIcon imageicon1 = new ImageIcon(i1);
            JLabel Imagelabel = new JLabel(imageicon1);
            Imagelabel.setBounds(800,5, 175, 80);
            add(Imagelabel);
            
            ImageIcon imageicon0 = new ImageIcon(getClass().getResource("/icon/icon5.png"));
            Image i2 = imageicon0.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
            ImageIcon imageicon2 = new ImageIcon(i2);
            JLabel Imagelabel2 = new JLabel(imageicon2);
            Imagelabel2.setBounds(650,-5, 100, 100);
            add(Imagelabel2);
            
            
            JButton btn1 = new JButton("Back");
            btn1.setBounds(850,15,100,30);
            btn1.setFont(new Font("Segoe UI", Font.BOLD, 16));
            btn1.setBackground(new Color(143, 188, 143));
            btn1.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            
            
            
            });
            panel1.add(btn1);
            
            JButton btn2 = new JButton("Add");
            btn2.setBounds(20,15,100,30);
            btn2.setFont(new Font("Segoe UI", Font.BOLD, 16));
            btn2.setBackground(new Color(143, 188, 143));
            btn2.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Add_Appointment();
                }
            });
            panel1.add(btn2);
            
            JButton btn3 = new JButton("Update");
            btn3.setBounds(170,15,100,30);
            btn3.setFont(new Font("Segoe UI", Font.BOLD, 16));
            btn3.setBackground(new Color(143, 188, 143));
            btn3.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Update_Appointment();
                }
            });
            panel1.add(btn3);
            
            JButton btn4= new JButton("Cancel");
            btn4.setBounds(320,15,130,30);
            btn4.setFont(new Font("Segoe UI", Font.BOLD, 16));
            btn4.setBackground(new Color(143, 188, 143));
            btn4.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Cancel_Appointment();
                }
            });
            panel1.add(btn4);
            
            
            
            
            JButton btn5 = new JButton("Refresh");
            btn5.setBounds(720,15,100,30);
            btn5.setFont(new Font("Segoe UI", Font.BOLD, 16));
            btn5.setBackground(new Color(143, 188, 143));
            btn5.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new Appointment_info();
                }
            
            
            
            });
            panel1.add(btn5);
            
            
            
            
            JTable info_table = new JTable();
            info_table.setBounds(10,100,990,550);
            info_table.setBackground(Color.white);
            info_table.setFont(new Font("Segoe UI", Font.BOLD, 14));
            
            JScrollPane scrollPane = new JScrollPane(info_table);
            scrollPane.setBounds(10,95, 970, 500);
            add(scrollPane);
            
            add(panel1);
            try{
                conn c = new conn();
                
                String q ="SELECT a.APP_ID AS 'Appointment ID',"
                        + "p.P_ID AS 'Patient ID',"
                        + "p.P_Name AS 'Patient Name',"
                        + "d.D_Name AS 'Doctor Name', d.Specialty,"
                        + "dept.DEP_Name AS 'Department Name', " 
                        + "a.APP_Date AS 'Appointment Date', a.APP_Time AS 'Appointment Time'"
                        + "FROM Appointments a " 
                        + "INNER JOIN Patient p ON a.P_ID = p.P_ID " 
                        + "INNER JOIN Doctor d ON a.D_ID = d.D_ID " 
                        + "INNER JOIN Department dept ON d.DEP_ID = dept.DEP_ID;";
               PreparedStatement pst = c.connection.prepareStatement(q);
                
               ResultSet rs = pst.executeQuery();
               
               info_table.setModel(DbUtils.resultSetToTableModel(rs));
               
                
            pst.close();
            c.connection.close();
            
            }catch(Exception e){
            
            
            }
            
            
            
            
            
            
            
            
            
        getContentPane().setBackground(new Color(140, 180, 140));
	setTitle("Medix");
	setSize(1000, 650);
        setUndecorated(true);
	setLayout(null);
        setResizable(false);
        setVisible(true);
	setLocation(320,160);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        }
    
    public static void main(String[] args){
    
        new Appointment_info();
    
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
    
