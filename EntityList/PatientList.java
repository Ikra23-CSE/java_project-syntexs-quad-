package EntityList;
import Entity.Patient;
public class PatientList{
	private Patient patients[];
	
	public PatientList(){
		patients = new Patient[5];
	}
	public PatientList(int size){
		patients = new Patient[size];
	}
	
	//show all patients
	public void showAllPatients(){
		for(int i=0;i<patients.length;i++){
			if(patients[i] != null){
				patients[i].showInfo();
			}
		}
	}
	
	//insert Patient into Array
	public void insertPatient(Patient p){
		boolean flag = false;
		for(int i=0;i<patients.length;i++){
			if(patients[i] == null){
				patients[i] = p;
				flag = true;
				break;
			}
		}
		//Based on the value of flag Now we know the Patient was stored successfully
		if(flag){
			System.out.println("Patient add");
		}
		else{
			System.out.println("Patient List is Fulll ! Failed to add");
		}
	}
	
	public void removePatientById(double id){
		boolean flag = false; 
		for(int i=0;i<patients.length;i++){
			if(patients[i] != null){
				if(patients[i].getId() == id){
					patients[i] = null;
					flag = true;
					break; 
				}
			}
		}
		if(flag){
			System.out.println("Patient Deleted Successfully");
		}
		else{
			System.out.println("Patient is not Found");			
		}
	}

	 public Patient[] getAllPatient(){return patients;}
}