package ch20.ex07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Attr {
	private final String name;
	private Object value = null;

	public Attr(String name) {
		this.name = name;
	}

	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public Attr(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		this.name = in.readUTF();
		this.value = in.readObject();
	}

	public Object getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public Object setValue(Object newValue) {
		Object oldValue = value;
		this.value = newValue;
		return oldValue;
	}

	public String toString() {
		return name + "='" + value + "'";
	}

	public void save(ObjectOutputStream out) throws IOException {
		out.writeUTF(name);
		out.writeObject(value);
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		Attr attr1 = new Attr("hello", "world");
		System.out.println(attr1.getName() + " = " + attr1.getValue());
		attr1.save(new ObjectOutputStream(new FileOutputStream("JPL/ch20/ex07/testfile.txt")));
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("JPL/ch20/ex07/testfile.txt"));
		Attr attr2 = new Attr(in);
		System.out.println("------------");
		System.out.println(attr2.getName() + " = " + attr2.getValue());
	}

	
}
