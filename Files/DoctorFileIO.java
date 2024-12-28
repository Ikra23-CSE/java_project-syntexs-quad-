package Files;
import java.io.*;
import java.util.Scanner;
import Entity.*;
import EntityList.DoctorList;

public class DoctorFileIO{
	
	public static void readFromFile(String fname,DoctorList doctorList){
		try{
			Scanner sc=new Scanner(new File(fname)); 
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");

				Double id = Double.parseDouble(data[0]);
				String name = data[1];
				Double age = Double.parseDouble(data[2]);
				String gender = data[3];
				String specialization = data[4];

				Entity.Doctor d = new Entity.Doctor(id,name,age,gender,specialization);
				doctorList.insertDoctor(d);
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
	public static void saveDoctorListInFile(DoctorList doctorList, String fname, boolean append){
		try {
		FileWriter writer = new FileWriter(fname,append);
		Doctor doctors[] = doctorList.getAllDoctor();
		
		for(int i=0;i<doctors.length;i++){
			if(doctors[i]!=null){
				String line = doctors[i].getId()+";"+
							  doctors[i].getName()+";"+
							  doctors[i].getAge()+";"+
							  doctors[i].getGender()+";"+
							  doctors[i].getSpecialization();
							  
				writer.write(line+"\n");
			}
		}
		
		writer.close();
		} catch (IOException e) {
			System.out.println("Cannot Write in File");
		}
	}
}
