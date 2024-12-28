package GUI;
import Files.*;
import Entity.*;
import EntityList.DoctorList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.table.*;

	public class DoctorManagerFrame extends JFrame implements ActionListener{
		Font font = new Font("Lucida Sans Unicode", Font.PLAIN, 16);
		Font font2 = new Font("Bookman Old Style", Font.BOLD, 40);
		JPanel panel;
		
		JLabel label;	
		
		JTextField TName, TAge, TId, TGender, TSpecialization, TSearch;
		JButton add, remove, back, search, update;
		
		DefaultTableModel model;
		JTable table;
		DoctorList doctorList;
		Homepage home;
		public DoctorManagerFrame(Homepage home, DoctorList doctorList){
			super("My Doctor Manager");
			this.home = home;
			this.doctorList = doctorList;
			
			initializeFrame();	
			
			createTable();
			
			
			//Display the window after all initialization
			this.setVisible(true);
		}
		
		public void initializeFrame(){
			this.setSize(1000,700);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocation(220,50);
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
			ImageIcon image = new ImageIcon("./GUI/Resource/bg4.png");
			JLabel background = new JLabel();
			background.setBounds(0,0,1000,700);
			background.setIcon(image);
			this.add(background);
			
			//Crating Labels
			label = new JLabel("Manage Doctor");
			label.setBounds(350,10,360,50);
			label.setFont(font2);
			
			JLabel idLabel = new JLabel("Doctor ID");
			idLabel.setFont(font);
			idLabel.setBounds(40,60,100,40);

			JLabel nameLabel = new JLabel("Name");
			nameLabel.setFont(font);
			nameLabel.setBounds(160,60,100,40);

			JLabel ageLabel = new JLabel("age");
			ageLabel.setFont(font);
			ageLabel.setBounds(280,60,100,40);
			
			JLabel genderLabel = new JLabel("Gender");
			genderLabel.setFont(font);
			genderLabel.setBounds(400,60,100,40);
			
			JLabel specializationLabel = new JLabel("Specialization");
			specializationLabel.setFont(font);
			specializationLabel.setBounds(520,60,140,40);
			
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
			
			TSpecialization = new JTextField(" ");
			TSpecialization.setFont(font);
			TSpecialization.setBounds(520,100,100,40);
			
			//Creating Buttons
			add = new JButton("Add Doctor");
			add.setFont(font);
			add.setBounds(800,180,165,40);
			add.setForeground(Color.WHITE);
			add.setBackground(new Color(36, 214, 42));
			add.addActionListener(this);
			
			remove = new JButton("Remove Doctor");
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

			//Search Button
			search = new JButton("Search");
			search.setFont(font);
			search.setBounds(730, 100, 100, 40);
			search.setForeground(Color.WHITE);
			search.setBackground(new Color(76, 141, 245));
			search.addActionListener(this);
		
			TSearch = new JTextField();
			TSearch.setFont(font);
			TSearch.setBounds(850, 100, 100, 40);
			
			//Update Button
			update = new JButton("Update");
			update.setFont(font);
			update.setBounds(800,280,165,40);
			update.setForeground(Color.WHITE);
			update.setBackground(new Color(76, 141, 245));
			update.addActionListener(this);
		
			
			
			//adding components to Panel
			panel.add(label);
			panel.add(idLabel);
			panel.add(nameLabel);
			panel.add(ageLabel);
			panel.add(genderLabel);
			panel.add(specializationLabel);
			panel.add(TId);
			panel.add(TName);
			panel.add(TAge);
			panel.add(TGender);
			panel.add(TSpecialization);
			panel.add(add);
			panel.add(remove);
			panel.add(back);
			panel.add(search);
			panel.add(update);
			panel.add(TSearch);
			
		}
		
		public void createTable(){
			//Create Model For Table
			model = new DefaultTableModel();
			model.addColumn("Doctor ID");
			model.addColumn("Doctor Name");
			model.addColumn("Doctor Age");
			model.addColumn("Doctor Gender");
			model.addColumn("Specialization");
			
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
			
			//copying data from patient list to Model
			Entity.Doctor doctors[];
			doctors = this.doctorList.getAllDoctor();
			
			for(int i=0;i<doctors.length;i++){
				if(doctors[i]!=null){
					model.addRow(new Object[]{
						doctors[i].getId(),
						doctors[i].getName(),
						doctors[i].getAge(),
						doctors[i].getGender(),
						doctors[i].getSpecialization()
					});
				}
			}
			
			//adding the scrollPane to panel
			panel.add(scrollPane);
		}
		
		public void actionPerformed(ActionEvent e){
			if(add == e.getSource()){
				try {
					Double id = Double.parseDouble(TId.getText());
					String name = TName.getText();
					Double age = Double.parseDouble(TAge.getText());
					String gender = TGender.getText();
					String specialization = TSpecialization.getText();
				
					Entity.Doctor d = new Entity.Doctor(id,name,age,gender,specialization);
					doctorList.insertDoctor(d);
				
					model.addRow(new Object[]{
						d.getId(),
						d.getName(),
						d.getAge(),
						d.getGender(),
						d.getSpecialization()
					});
					DoctorFileIO.writeInFile(d.getId()+";"+d.getName()+";"+d.getAge()+";"+d.getGender()+";"+d.getSpecialization(),
						"Files/DoctorInfo.txt",
						true);
					TId.setText("");
					TName.setText("");
					TAge.setText("");
					TGender.setText("");
					TSpecialization.setText("");
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
							doctorList.removeDoctorById(id);
							model.removeRow(selectedRows[i]);
							}
							DoctorFileIO.saveDoctorListInFile(doctorList,"Files/DoctorInfo.txt",false);
							JOptionPane.showMessageDialog(this,"Removed Successfully");
						}
					}
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(this, "Invalid input! Enter Correctly ID", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Cannot find Doctor", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			else if(search == e.getSource()){
            try{int i;
            for(i = 0;i<table.getRowCount();i++){
                if (Double.parseDouble(TSearch.getText()) == ((Double) table.getValueAt(i, 0)).doubleValue()) {
					table.setSelectionBackground(new Color(50, 240, 91));	 
                    break;
                     }
            }
            table.setRowSelectionInterval(i, i);
			JOptionPane.showMessageDialog(this, "Found at row: "+(i+1));
       		 }
				catch (NullPointerException ex) {
					JOptionPane.showMessageDialog(this, "No Id detected, Please enter Id", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(this, "Invalid input! Enter ID in number format", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Cannot find Doctor", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			else if (update == e.getSource()){
				tableModuleToList();
				DoctorFileIO.saveDoctorListInFile(doctorList,"Files/DoctorInfo.txt",false);
				JOptionPane.showMessageDialog(this,"Updated Successfully");
			}

			else if (back == e.getSource()) {
				home.setVisible(true);
				this.dispose();
			}
		}
		
		public void tableModuleToList(){
			int rows = table.getRowCount();
			DoctorList updatedList = new DoctorList(100);
			for(int i=0; i<rows; i++){
				double id = Double.parseDouble(table.getModel().getValueAt(i, 0).toString());
				String name =table.getModel().getValueAt(i, 1).toString();
				double age = Double.parseDouble(table.getModel().getValueAt(i, 2).toString());
				String gender =table.getModel().getValueAt(i, 3).toString();
				String specialization =table.getModel().getValueAt(i, 4).toString();
				
				Doctor doc = new Doctor(id,name,age,gender,specialization);
				updatedList.insertDoctor(doc);
			}
			doctorList.setAllDoctors(updatedList.getAllDoctor());
			
								
		}
		
	}