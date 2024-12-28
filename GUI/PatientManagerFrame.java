package GUI;
import Files.*;
import Entity.*;
import EntityList.PatientList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.table.*;

public class PatientManagerFrame extends JFrame implements ActionListener{
	Font font = new Font("Lucida Sans Unicode", Font.PLAIN, 16);
	Font font2 = new Font("Bookman Old Style", Font.BOLD, 40);
	JPanel panel;
	
	JLabel label;	
	
	JTextField TName, TAge, TId, TGender, TBP, searchField;
	JButton add, remove, back, search;
	
	DefaultTableModel model;
	JTable table;
	PatientList patientList;
	Homepage home;
	
	public PatientManagerFrame(Homepage home, PatientList patientList){
		super("My Patient Manager");
		this.home = home;
		this.patientList = patientList;
		
		initializeFrame();	
		
		createTable();
		
		
		//Display the window after all initialization
		this.setVisible(true);
	}
	
	public void initializeFrame(){
		this.setSize(1000,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200,50);
		this.setLayout(null);
		
		//Creating a Panel Container
		panel = new JPanel();
		panel.setBounds(0,0,1000,700);
		panel.setOpaque(false);
		panel.setLayout(null);
		this.add(panel);

		//Window Icon
        ImageIcon icon = new ImageIcon("./GUI/Resource/Hospital.jpg"); 
        Image WImage = icon.getImage();
        this.setIconImage(WImage);
		
		//BackGround 
		ImageIcon image = new ImageIcon("./GUI/Resource/bg5.png");
		JLabel background = new JLabel();
		background.setBounds(0,0,1000,700);
		background.setIcon(image);
		this.add(background);
		
		//Crating Labels
		label = new JLabel("Manage Patient");
		label.setBounds(350,10,360,50);
		label.setFont(font2);
		
		JLabel idLabel = new JLabel("Patient ID");
		idLabel.setFont(font);
		idLabel.setBounds(40,60,100,40);

		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(font);
		nameLabel.setBounds(160,60,100,40);

		JLabel ageLabel = new JLabel("Age");
		ageLabel.setFont(font);
		ageLabel.setBounds(280,60,100,40);
		
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setFont(font);
		genderLabel.setBounds(400,60,100,40);
		
		JLabel bloodPressureLabel = new JLabel("Blood Pressure");
		bloodPressureLabel.setFont(font);
		bloodPressureLabel.setBounds(520,60,140,40);
		
		//TextFields
		TId = new JTextField(" ");
		TId.setFont(font);
		TId.setBounds(40,100,100,40);

		TName = new JTextField(" ");
		TName.setFont(font);
		TName.setBounds(160,100,100,40);

		TAge = new JTextField(" ");
		TAge.setFont(font);
		TAge.setBounds(280,100,100,40);
		
		TGender = new JTextField(" ");
		TGender.setFont(font);
		TGender.setBounds(400,100,100,40);
		
		TBP = new JTextField(" ");
		TBP.setFont(font);
		TBP.setBounds(520,100,100,40);
		
		//Creating Buttons
		add = new JButton("Add Patient");
		add.setFont(font);
		add.setBounds(800,180,165,40);
		add.setForeground(Color.WHITE);
		add.setBackground(new Color(36, 214, 42));
		add.addActionListener(this);

		remove = new JButton("Remove Patient");
		remove.setFont(font);
		remove.setBounds(800,230,165,40);
		remove.setForeground(Color.WHITE);
		remove.setBackground(new Color(214, 36, 36));
		remove.addActionListener(this);

		back = new JButton("Back>");
        back.setBounds(770, 580, 100, 40);
        back.setFont(font);
		back.setForeground(Color.WHITE);
		back.setBackground(new Color(214, 36, 36));
        back.addActionListener(this);
        this.add(back);

		//Search Button
		search = new JButton("Search");
		search.setFont(font);
		search.setBounds(730, 100, 100, 40);
		search.setForeground(Color.WHITE);
		search.setBackground(new Color(76, 141, 245));
		search.addActionListener(this);
		
		searchField = new JTextField();
		searchField.setFont(font);
		searchField.setBounds(850, 100, 100, 40);
		
		//adding components to Panel
		panel.add(label);
		panel.add(idLabel);
		panel.add(nameLabel);
		panel.add(ageLabel);
		panel.add(genderLabel);
		panel.add(searchField);
		panel.add(bloodPressureLabel);
		panel.add(TId);
		panel.add(TName);
		panel.add(TAge);
		panel.add(TGender);
		panel.add(TBP);
		panel.add(add);
		panel.add(remove);
		panel.add(back);
		panel.add(search);
	}
	
	public void createTable(){
		//Create Model For Table
		model = new DefaultTableModel();
		model.addColumn("Patient ID");
		model.addColumn("Patient Name");
		model.addColumn("Patient Age");
		model.addColumn("Patient Gender");
		model.addColumn("Blood Pressure");
		
		//Create Table with model
		table = new JTable(model);
		table.setFont(font);
		table.setBackground(new Color(146, 211, 247));
		table.setBounds(0, 0, 750, 300);
		table.setRowHeight(30);
		table.setSelectionBackground(new Color(247, 146, 146));
		table.getTableHeader().setFont(font);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 150, 750, 300);
		
		//copy data from patient list to Model
		Entity.Patient patients[];
		patients = this.patientList.getAllPatient();
		
		for(int i=0;i<patients.length;i++){
			if(patients[i]!=null){
				model.addRow(new Object[]{
					patients[i].getId(),
					patients[i].getName(),
					patients[i].getAge(),
					patients[i].getGender(),
					patients[i].getBloodPressure()
				});
				
			}
		}
		
		//add the scrollPane to panel
		panel.add(scrollPane);
	}
	
	public void actionPerformed(ActionEvent e){
		if(add == e.getSource()){
			try {
				Double id = Double.parseDouble(TId.getText());
				String name = TName.getText();
				Double age = Double.parseDouble(TAge.getText());
				String gender = TGender.getText();
				String bloodPressure = TBP.getText();
			
				Entity.Patient p = new Entity.Patient(id,name,age,gender,bloodPressure);
				patientList.insertPatient(p);
			
				model.addRow(new Object[]{
					p.getId(),
					p.getName(),
					p.getAge(), 
					p.getGender(),
					p.getBloodPressure()
				});
				PatientFileIO.writeInFile(p.getId()+";"+p.getName()+";"+p.getAge()+";"+p.getGender()+";"+p.getBloodPressure(),
					"Files/PatientInfo.txt",
					true);
				TId.setText("");
				TName.setText("");
				TAge.setText("");
				TGender.setText("");
				TBP.setText("");
			} 
			catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(this, "Please enter all details", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Error uccoured, Can't add", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(remove == e.getSource()) { 
			try {
				int option = JOptionPane.showConfirmDialog(this,"Are you sure you want to remove?");
					if(option == JOptionPane.YES_OPTION){
						int selectedRows[] = table.getSelectedRows();
						Arrays.sort(selectedRows);		
			
						if(selectedRows!=null){
							for(int i=selectedRows.length-1; i>= 0; i--){
								double id = Double.parseDouble(
									table.getModel().
									getValueAt(selectedRows[0], 0).
									toString());
							patientList.removePatientById(id);
							model.removeRow(selectedRows[i]);
							}
							PatientFileIO.savePatientListInFile(patientList,"Files/PatientInfo.txt",false);
							JOptionPane.showMessageDialog(this,"Removed Successfully");
						}
				}
			} 
			catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Invalid input! Enter ID in number format", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(this, "Please enter Id", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Error uccoured, Can't remove", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(search == e.getSource()){
            try{int i;
            for(i = 0;i<table.getRowCount();i++){
                if (Double.parseDouble(searchField.getText()) == ((Double) table.getValueAt(i, 0)).doubleValue()) {
					table.setSelectionBackground(new Color(50, 240, 91));	 
                    break;
                     }
            }
            table.setRowSelectionInterval(i, i);
			
       		 }
				
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(this, "Invalid input! Enter Correctly ID", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Cannot find Patient", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
	

		else if(back == e.getSource()){
			home.setVisible(true);
			this.dispose();
		}
	}
}