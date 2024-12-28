package Files;
import java.io.*;
import java.util.Scanner;
import Entity.*;
import EntityList.PatientList;

public class PatientFileIO{
	
	public static void readFromFile(String fname,PatientList patientList){
		try{
			Scanner sc=new Scanner(new File(fname)); 
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");

				Double id = Double.parseDouble(data[0]);
				String name = data[1];
				Double age = Double.parseDouble(data[2]);
				String gender = data[3];
				String role = data[4];

				Entity.Patient s = new Entity.Patient(id,name,age,gender,role);
				patientList.insertPatient(s);
			}
			sc.close();
		}
		catch(Exception e){
			System.out.println("Cannot Read the File");
		}
	}
	
	public static void writeInFile(String line, String fname, boolean append){
		try {
		FileWriter writer = new FileWriter(fname,append);
		writer.write(line+"\n");
		writer.close();
		} catch (IOException e) {
			System.out.println("Cannot Write in File");
		}
	}
	public static void savePatientListInFile(PatientList patientList, String fname, boolean append){
		try {
		FileWriter writer = new FileWriter(fname,append);
		Patient patients[] = patientList.getAllPatient();
		
		for(int i=0;i<patients.length;i++){
			if(patients[i]!=null){
				String line = patients[i].getId()+";"+
							  patients[i].getName()+";"+
							  patients[i].getAge()+";"+
							  patients[i].getAge()+";"+
							  patients[i].getBloodPressure();
							  
				writer.write(line+"\n");
			}
		}
		
		writer.close();
		} catch (IOException e) {
			System.out.println("Cannot Write in File");
		}
	}
}
