package EntityList;
import Entity.Doctor;
public class DoctorList{
	private Doctor doctors[];
	
	public DoctorList(){
		doctors = new Doctor[50];
	}
	public DoctorList(int size){
		doctors = new Doctor[size];
	}
	
	//show all doctors
	public void showAllDoctors(){
		for(int i=0;i<doctors.length;i++){
			if(doctors[i] != null){
				doctors[i].showInfo();
			}
		}
	}
	
	//insert Doctor into Array
	public void insertDoctor(Doctor d){
		boolean flag = false;
		for(int i=0;i<doctors.length;i++){
			
			if(doctors[i] == null){
				doctors[i] = d;
				flag = true;
				break;
			}
		}
		if(flag){
			System.out.println("Doctor added");
		}
		else{
			System.out.println("Doctor List is Fulll ! Failed to add");
		}
	}
	
	public void removeDoctorById(double id){
		boolean flag = false; 
		for(int i=0;i<doctors.length;i++){
			if(doctors[i] != null){
				if(doctors[i].getId() == id){
					doctors[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("Doctor Deleted Successfully");
		}
		else{
			System.out.println("Doctor is not Found");			
		}
	}

	public Doctor getDoctorById(double id) {
		for (int i = 0; i < doctors.length; i++) {
			if (doctors[i] != null && doctors[i].getId() == id) {
				return doctors[i];
			}
		}
		return null; // doctor with the given ID is not found
	}
	
	public Doctor[] getAllDoctor(){return doctors;} 
	
	public void setAllDoctors(Doctor[] doctors ){
		this.doctors = doctors;
	}
}