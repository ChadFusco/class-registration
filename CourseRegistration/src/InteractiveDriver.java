
import java.util.*;

public class InteractiveDriver {

	public static void main(String[] args) {

		// Create a hard-coded course object
		Course course1 = new Course("Quantum Mechanics for Poets", 2, 2);

		System.out.println("Welcome to the Course Registration system for the"
				+ " following course:\n");
		System.out.println(course1);

		int option;
		Scanner scan = new Scanner(System.in);

		// Interactive menu
		do {
			System.out.println("What action would you like to take?\n"
					+ "\tEnter 1 to add a student\n"
					+ "\tEnter 2 to drop a student\n"
					+ "\tEnter 3 to print the course\n"
					+ "\tEnter 4 to expand/shrink the course roster\n"
					+ "\tEnter 5 to expand/shrink the course waitlist\n"
					+ "\tEnter 9 to exit");
			option = Integer.parseInt(scan.nextLine());

			switch(option) {

				// Add a student
				case 1:
					System.out.println("Enter student name:");
					String name = scan.nextLine();
					System.out.println("Enter student ID:");
					String id1 = scan.nextLine();
					System.out.println("Has the student paid tuition? Enter"
							+ " y or n:");
					String isTuitionPaid = scan.nextLine();
					boolean tuitionPaid = (isTuitionPaid.equalsIgnoreCase("y"))
							? true:false;
					Student student1 = new Student(name,id1,tuitionPaid);
					if(course1.addStudent(student1)) {
						System.out.println("Student with ID " + id1
								+ " added successfully\n");
					}
					else {
						System.out.println("Student with ID " + id1
								+ " has not been added\n");
					}
					break;

				// Drop a student
				case 2:
					System.out.println("Enter student ID:");
					String id2 = scan.nextLine();
					Student student2 = new Student("",id2,true);
					if(course1.dropStudent(student2)) {
						System.out.println("Student with ID " + id2
								+ " dropped successfully\n");
					}
					else {
						System.out.println("Student with ID " + id2
								+ " has not been dropped\n");
					}
					break;

				// Print the course
				case 3:
					System.out.println(course1);
					break;

				// Expand roster
				case 4:
					System.out.println("What is the new max roster size"
							+ " for the class?");
					int maxEnrolled = Integer.parseInt(scan.nextLine());
					if(course1.setMaxEnrolled(maxEnrolled)) {
						System.out.println("Roster sucessfully changed to "
								+ maxEnrolled + " students max\n");
					}
					else {
						System.out.println("ERROR: Max enrolled cannot be set"
								+ " to less than the number of students "
								+ "enrolled.\n");
					}
					break;

				// Expand waitlist
				case 5:
					System.out.println("What is the new max waitlist size"
							+ " for the class?");
					int maxWaitlist = Integer.parseInt(scan.nextLine());
					if(course1.setMaxWaitlist(maxWaitlist)) {
						System.out.println("Waitlist sucessfully changed to "
								+ maxWaitlist + " max students\n");
					}
					else {
						System.out.println("ERROR: Max waitlisted cannot be "
								+ "set to less than the number of students"
								+ " currently waitlisted.\n");
					}
					break;

				// Exit program
				case 9:
					System.out.println("Goodbye!");
					break;

				// Invalid option catch
				default:
					System.out.println("Invalid option. Please try again");
			}

		} while(option != 9);

		scan.close();

	}

}
