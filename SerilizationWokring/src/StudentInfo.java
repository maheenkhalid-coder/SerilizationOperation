import java.io.Serializable;

public class StudentInfo implements Serializable {

	private String name;
	private int age;
	private int id;

	public StudentInfo(String name, int age, int id) {
		this.name = name;
		this.age = age;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\n" + "Age: " + age + '\n' + "ID: " + id + '\n';
	}

}
