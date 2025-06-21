package h.m.s;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Bill_info extends JFrame implements ActionListener{
        
        Bill_info(){
            
            JPanel panel1 = new JPanel();
            panel1.setLayout(null);
            panel1.setBounds(5,600,990,50);
            panel1.setBackground(new Color(100, 140, 100));
            
            
            JLabel title = new JLabel("Bill Information");
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
                
                String q = "SELECT b.B_ID AS [Bill ID], " +
                           "p.P_ID AS [Patient ID], " +
                           "p.P_Name AS [Patient Name], " +
                           "b.B_Date AS [Bill Date], " +
                           "b.TotalAmount AS [Total Amount] " +
                           "FROM Bills b " +
                           "JOIN Patient p ON b.P_ID = p.P_ID;";
                
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
    
        new Bill_info();
    
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
