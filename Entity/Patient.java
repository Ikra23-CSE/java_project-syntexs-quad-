package Entity;
public final class Patient extends Person {
    private String bloodPressure;

    public Patient(double id,String name, double age,  String gender, String bloodPressure) {
       super(id,name,age,gender);
        this.bloodPressure = bloodPressure;
    }	

    public void setBloodPressure(String bloodPressure){
        this.bloodPressure = bloodPressure;
    }
    public String getBloodPressure() {return bloodPressure;}
	
	public void showInfo() {
            System.out.println("Patient Name: " + name);
            System.out.println("Patient Age: " + age);
            System.out.println("Patient ID: " + id);
            System.out.println("Patient Gender: " + gender);
			System.out.println("Patient Blood pressure: " + bloodPressure);
    }
}
