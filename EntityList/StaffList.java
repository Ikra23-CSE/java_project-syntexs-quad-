package EntityList;
import Entity.Staff;
public class StaffList{
	private Staff staffs[];
	
	public StaffList(){
		staffs = new Staff[5];
	}
	public StaffList(int size){
		staffs = new Staff[size];
	}
	
	//show all staffs
	public void showAllStaffs(){
		for(int i=0;i<staffs.length;i++){
			if(staffs[i] != null){
				staffs[i].showInfo();
			}
		}
	}
	
	//insert Staff into Array
	public void insertStaff(Staff s){
		boolean flag = false;
		for(int i=0;i<staffs.length;i++){
			if(staffs[i] == null){
				staffs[i] = s;
				flag = true;
				break;
			}
		}
		if(flag){
			System.out.println("Staff added");
		}
		else{
			System.out.println("Staff List is Fulll ! Failed to add");
		}
	}
	
	public void removeStaffById(double id){
		boolean flag = false; 
		for(int i=0;i<staffs.length;i++){
			if(staffs[i] != null){
				if(staffs[i].getId() == id){
					staffs[i] = null;
					flag = true;
					break; 
				}
			}
		}
		if(flag){
			System.out.println("Staff Deleted Successfully");
		}
		else{
			System.out.println("Staff is not Found");			
		}
	}

	public Staff[] getAllStaff(){return staffs;} 
}