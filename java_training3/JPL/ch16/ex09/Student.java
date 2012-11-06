package ch16.ex09;

class Student{
	String name;
	private int age;
	public boolean sex;
	
	
	public Student(String name, int age, boolean sex){
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	public Student(String name, int age){
		this.name = name;
		this.age = age;
		this.sex = false;
	}	
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setSex(boolean sex){
		this.sex = sex;
	}
	
	
	public boolean getSex(){
		return sex;
	}

	
	public String toString(){
		return name + " , " + age + " , " + sex; 
	}
}