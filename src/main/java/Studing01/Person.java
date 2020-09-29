package Studing01;

public class Person{
	
	private String name;
	
	Person(String name){
		this.name = name;
	}
	
	public void displayName() {
		System.out.println(this.name);
	}
	
	public void setName(String newname) {
		this.name = newname;
	}
}