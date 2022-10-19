
public class MyCourseTester {

	public static void main(String[] args) {
		Course course1 = new Course("Intro to Java Programming", 2, 2);
		
		System.out.println(course1.getMaxEnrolled());
		System.out.println(course1.getMaxWaitlist());
		System.out.println(course1);
		
		Student student1 = new Student("Chad", "S1234", true);
		Student student2 = new Student("Mike", "S1235", true);
		Student student3 = new Student("Fred", "S1236", false);
		Student student4 = new Student("Bill", "S1237", true);
		Student student5 = new Student("Billy", "S1238", true);
		Student student6 = new Student("Billum", "S1239", true);
		
		System.out.println(course1.addStudent(student1));
		System.out.println(course1.addStudent(student3));
		System.out.println(course1.addStudent(student2));
		System.out.println(course1.addStudent(student2));
		System.out.println(course1.addStudent(student4));
		System.out.println(course1.addStudent(student4));
		System.out.println(course1.addStudent(student5));
		System.out.println(course1.addStudent(student6));
		
		System.out.println(course1);
		
		course1.setMaxEnrolled(5);
		
		System.out.println(course1);
		
		course1.setMaxEnrolled(4);
		
		System.out.println(course1);
		
		System.out.println(course1.addStudent(student6));
		course1.setMaxWaitlist(4);
		
		System.out.println(course1);
		
		System.out.println(course1.dropStudent(student1));
		
		System.out.println(course1);
		
	}

}
