package mylambdaprac;

public class Student {
	private String name;
	private int id;
	
	public Student() {
	
	}
	public Student(String name) {
		this.name = name;
	}
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String name() {
		return this.name;
	}
	
	public int id() {
		return this.id;
	}
}
