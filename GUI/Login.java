package GUI;
import Files.*;
import EntityList.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JLabel userNameLabel, userPassLabel, loginLabel;
    JPanel panel;
    JTextField userName;
    JPasswordField password;
    JButton btnLogin;

    Font font = new Font("Bookman Old Style", Font.BOLD, 20);
    Font font2 = new Font("Bookman Old Style", Font.BOLD, 40);

    public Login() {
        super("Login");
        this.setSize(700, 450);
        this.setLocation(400, 200);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btnLogin = new JButton("Login");
        btnLogin.setBounds(425, 260, 180, 40);
        btnLogin.setFont(font);
        btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(76, 141, 245));
        btnLogin.addActionListener(this);
        this.add(btnLogin);

        //Panel Container
        panel = new JPanel();
		panel.setBounds(0,0,700,450);
		panel.setOpaque(false);
		panel.setLayout(null);
		this.add(panel);
        
        //Window Icon
        ImageIcon icon = new ImageIcon("./GUI/Resource/Hospital.jpg"); 
        Image WImage = icon.getImage();
        this.setIconImage(WImage);

        

        //Welcome Label
        loginLabel = new JLabel("Login");
        loginLabel.setBounds(470, 30, 180, 50);
        loginLabel.setFont(font2);
        this.add(loginLabel);

        // USER NAME Label
        userNameLabel = new JLabel("User Name");
        userNameLabel.setBounds(390, 80, 180, 40);
        userNameLabel.setFont(font);
        this.add(userNameLabel);

        // USER NAME TextField
        userName = new JTextField("Asif");
        userName.setBounds(390, 120, 240, 40);
        userName.setFont(font);
        this.add(userName);

        // User Password Label
        userPassLabel = new JLabel("Password");
        userPassLabel.setBounds(390, 170, 150, 40);
        userPassLabel.setFont(font);
        this.add(userPassLabel);

        // User Password Password Field
        password = new JPasswordField("1234");
        password.setBounds(390, 210, 240, 40);
        password.setEchoChar('*');
        password.setFont(font);
        this.add(password);

        panel.add(userNameLabel);
        panel.add(userPassLabel);
        panel.add(loginLabel);
		
		//Images
        ImageIcon image = new ImageIcon("./GUI/Resource/bg1.png");
		JLabel background = new JLabel();
		background.setBounds(0,0,340,450);
		background.setIcon(image);
		this.add(background);

        ImageIcon image2 = new ImageIcon("./GUI/Resource/bg2.png");
		JLabel background2 = new JLabel();
		background2.setBounds(340,0,360,450);
		background2.setIcon(image2);
		this.add(background2);
		
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (btnLogin == e.getSource()) {
            String name = userName.getText();
            String pass = String.valueOf(password.getPassword());
    
        try {
            if (name.equals("Asif") && pass.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                
                PatientList patientList = new PatientList(100);
                PatientFileIO.readFromFile("files/patientInfo.txt",patientList);

                DoctorList doctorList = new DoctorList(100);
                DoctorFileIO.readFromFile("files/DoctorInfo.txt",doctorList);

                StaffList staffList = new StaffList(100);
                StaffFileIO.readFromFile("files/StaffInfo.txt",staffList);

                new Homepage(this, patientList, doctorList, staffList);
    
                userName.setText("");
                password.setText("");
                this.setVisible(false);
            }
        }
        
    
        catch (Exception exp) {
            
            JOptionPane.showMessageDialog(this, "Invalid User Name or Password", 
											  "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
    

