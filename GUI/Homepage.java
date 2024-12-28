package GUI;
import EntityList.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Homepage extends JFrame implements ActionListener
{	
	JPanel panel;
	JButton btnPatientManager, btnDoctorManager, btnStaffManager, logout;
	JLabel label;
	PatientList patientList;
	DoctorList doctorList;
	StaffList staffList;
	Login login;
	Font font = new Font("Bookman Old Style", Font.BOLD, 20);
	Font font2 = new Font("Bookman Old Style", Font.BOLD, 30);
	
	public Homepage(Login login, PatientList patientList, DoctorList doctorList, StaffList staffList){
		super("Homepage");
		this.login = login;
		this.patientList = patientList;
		this.doctorList = doctorList;
		this.staffList = staffList;
        this.setSize(700, 450);
        this.setLocation(400, 200);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

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

		//BackGround 
		ImageIcon image = new ImageIcon("./GUI/Resource/bg3.png");
		JLabel background = new JLabel();
		background.setBounds(0,0,700,450);
		background.setIcon(image);
		this.add(background);

		//Label
		label = new JLabel("Welcome to Homepage");
		label.setBounds(180,20,400,40);
		label.setFont(font2);
		this.add(label);

		//Buttons
		btnPatientManager = new JButton("Patient Manager");
        btnPatientManager.setBounds(230, 80, 240, 60);
        btnPatientManager.setFont(font);
		btnPatientManager.setForeground(Color.WHITE);
		btnPatientManager.setBackground(new Color(76, 141, 245));
        btnPatientManager.addActionListener(this);
        this.add(btnPatientManager);
		
		btnDoctorManager = new JButton("Doctor Manager");
        btnDoctorManager.setBounds(230, 160, 240, 60);
        btnDoctorManager.setFont(font);
		btnDoctorManager.setForeground(Color.WHITE);
		btnDoctorManager.setBackground(new Color(76, 141, 245));
        btnDoctorManager.addActionListener(this);
        this.add(btnDoctorManager);
		
		btnStaffManager = new JButton("Staff Manager");
        btnStaffManager.setBounds(230, 240, 240, 60);
        btnStaffManager.setFont(font);
		btnStaffManager.setForeground(Color.WHITE);
		btnStaffManager.setBackground(new Color(76, 141, 245));
        btnStaffManager.addActionListener(this);
        this.add(btnStaffManager);

		logout = new JButton("logout");
        logout.setBounds(530, 340, 100, 40);
        logout.setFont(font);
		logout.setForeground(Color.WHITE);
		logout.setBackground(new Color(214, 36, 36));
        logout.addActionListener(this);
        this.add(logout);
		
		panel.add(label);
		panel.add(btnPatientManager);
        panel.add(btnDoctorManager);
        panel.add(btnStaffManager);
		panel.add(logout);

		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
        if(btnPatientManager == e.getSource()){
			new PatientManagerFrame(this, patientList);
			this.setVisible(false);
		}
		else if(btnDoctorManager == e.getSource()){
			new DoctorManagerFrame(this, doctorList);
			this.setVisible(false);
		}
		else if(btnStaffManager == e.getSource()){
			new StaffManagerFrame(this, staffList);
			this.setVisible(false);
		}
		else if(logout == e.getSource()){
			int option = JOptionPane.showConfirmDialog(this,"Do you want to logout?");
			if(option == JOptionPane.YES_OPTION){
				this.dispose();
				login.setVisible(true);
			}
		}
    }
}
