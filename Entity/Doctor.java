package Entity;
public final class Doctor extends Person {

    private String specialization;
	

    public Doctor(double id, String name, double age, String gender, String specialization) {
       super(id,name,age,gender);
        this.specialization = specialization;
    }


    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public String getSpecialization() {return specialization;}

	public void showInfo() {
            System.out.println("Doctor Name: " + name);
            System.out.println("Doctor Age: " + age);
            System.out.println("Doctor ID: " + id);
            System.out.println("Doctor Gender: " + gender);
			System.out.println("Doctor Spcialization: " + specialization);
    }
}
