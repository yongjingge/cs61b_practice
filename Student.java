/*
演示class variables的指向问题/计算机存储
*/

public class Student {
	String name;
	int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "a Student name is " + name + " and the age is " + age;
	}

	public static void main(String[] args) {
		/* note here:
		* s1 and s2 are pointing at the same insance
		*/
		Student s1 = new Student("Amy", 18);
		Student s2;
		s2 = s1; //s2 = where s1 is stored in the system; it is the address returned;
		s2.name = "Tom";
		s2.age = 19;
		System.out.println("s1 is:" + s1.toString());
		System.out.println("s2 is:" + s2.toString());
	}
}