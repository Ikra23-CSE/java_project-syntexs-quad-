package Entity;
public abstract class Person {
    protected double id;
    protected String name;
    protected double age;
    protected String gender;

    public Person(double id, String name, double age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void setid(double id) {
        this.id = id;
    }
    public double getId() {return id;}


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {return name;}


    public void setAge(double age) {
        this.age = age;
    }
    public double getAge() {return age;}
	

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {return gender;}
	
	public abstract void showInfo(); 
            

}
