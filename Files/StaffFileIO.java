package Files;
import java.io.*;
import java.util.Scanner;
import Entity.*;
import EntityList.StaffList;

public class StaffFileIO{
	
	public static void readFromFile(String fname,StaffList staffList){
		try{
			Scanner sc=new Scanner(new File(fname)); 
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");

				Double id = Double.parseDouble(data[0]);
				String name = data[1];
				Double age = Double.parseDouble(data[2]);
				String gender = data[3];
				String role = data[4];

				Entity.Staff s = new Entity.Staff(id,name,age,gender,role);
				staffList.insertStaff(s);
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
	public static void saveStaffListInFile(StaffList staffList, String fname, boolean append){
		try {
		FileWriter writer = new FileWriter(fname,append);
		Staff staffs[] = staffList.getAllStaff();
		
		for(int i=0;i<staffs.length;i++){
			if(staffs[i]!=null){
				String line = staffs[i].getId()+";"+
							  staffs[i].getName()+";"+
							  staffs[i].getAge()+";"+
							  staffs[i].getAge()+";"+
							  staffs[i].getRole();
							  
				writer.write(line+"\n");
			}
		}
		
		writer.close();
		} catch (IOException e) {
			System.out.println("Cannot Write in File");
		}
	}
}
