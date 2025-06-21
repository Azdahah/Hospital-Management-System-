package h.m.s;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

	public JTextField textfield;
	private JPasswordField passwordfield;
        private JButton button1,button2;

	Login() {
		
		JPanel formPanel = new JPanel();
		formPanel.setLayout(null);
		formPanel.setBounds(310, 0, 380, 400); 
		formPanel.setBackground(new Color(240, 240, 240));
		
		
		ImageIcon imageicon = new ImageIcon(getClass().getResource("/icon/icon1.png"));
		Image i1 = imageicon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon imageicon1 = new ImageIcon(i1);
		JLabel Imagelabel = new JLabel(imageicon1);
		Imagelabel.setBounds(60, 60, 200, 200);
		add(Imagelabel);
                
                JLabel title = new JLabel("Medix's Managment System");
                title.setBounds(6,220, 300, 60);
		title.setFont(new Font("Segoe UI", Font.BOLD, 16));
		title.setForeground(new Color(44, 44, 44));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);
		add(title);
		
		
		

		// Title label
		JLabel loginText = new JLabel("Login");
		loginText.setBounds(120, 10, 130, 60);
		loginText.setFont(new Font("Segoe UI", Font.BOLD, 32));
		loginText.setForeground(new Color(44, 44, 44));
		loginText.setHorizontalAlignment(SwingConstants.CENTER);
		loginText.setVerticalAlignment(SwingConstants.CENTER);
		formPanel.add(loginText);

		// Username label
		JLabel nameLabel = new JLabel("Username");
		nameLabel.setBounds(40, 100, 100, 30);
		nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		nameLabel.setForeground(new Color(44, 44, 44));
		formPanel.add(nameLabel);

		// Password label
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(40, 180, 100, 30);
		passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		passwordLabel.setForeground(new Color(44, 44, 44));
		formPanel.add(passwordLabel);
		
		
		textfield = new JTextField();
		textfield.setBounds(40, 132, 320, 30);
		textfield.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textfield.setBackground(new Color(240, 240, 240));
		formPanel.add(textfield);
		
		passwordfield = new JPasswordField();
		passwordfield.setBounds(40, 212, 320, 30);
		passwordfield.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		passwordfield.setBackground(new Color(240, 240, 240));
		formPanel.add(passwordfield);
		
		button1 = new JButton("Login");
                button1.setBounds(60,270,100,35);
                button1.setFont(new Font("Segoe UI", Font.BOLD, 16));
                button1.setBackground(new Color(143, 188, 143));
                button1.addActionListener(this);
                formPanel.add(button1);
		
                button2 = new JButton("Cancel");
                button2.setBounds(240,270,100,35);
                button2.setFont(new Font("Segoe UI", Font.BOLD, 16));
                button2.setBackground(new Color(143, 188, 143));
                button2.addActionListener(this);
                formPanel.add(button2);
		
		add(formPanel);

		getContentPane().setBackground(new Color(143, 188, 143));
		setTitle("Medix");
		setSize(700, 400);
		setLayout(null);
                setResizable(false);
		setVisible(true);
		setLocation(450,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Login();
	}
  @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button1) {
        String user = textfield.getText();
        String password = new String(passwordfield.getPassword());

        String query = "SELECT * FROM login WHERE ID = ? AND PW = ?";
        System.out.println("user:"+user+password);

        try {
            conn c = new conn();

            
            PreparedStatement pst = c.connection.prepareStatement(query);
            pst.setString(1, user);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                this.dispose();
                new home();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }

            rs.close();
            pst.close();
            c.connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }
    
    if (e.getSource() == button2) {
        System.exit(0); // exit program on cancel
    }
}
  
}