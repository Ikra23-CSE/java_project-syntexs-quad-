package Entity;
public final class Staff extends Person{
    private String role;

    public Staff(double id,String name, double age, String gender, String role) {
       super(id,name,age,gender);
        this.role = role;
    }	
	
    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {return role;}

public void showInfo() {
            System.out.println("Staff Name: " + name);
            System.out.println("Staff Age: " + age);
            System.out.println("Staff ID: " + id);
            System.out.println("Staff Gender: " + gender);
			System.out.println("Staff Role: " + role);
    }

}
