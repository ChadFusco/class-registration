
public class Course {

	private String name;
	private Student[] roster;
	private Student[] waitlist;
	private short maxEnrolled;
	private short maxWaitlist;
	private short numEnrolled;
	private short numWaitlist;

	public Course(String name, int maxEnrolled, int maxWaitlist) {

		this.name = name;
		this.maxEnrolled = (short) maxEnrolled;
		this.maxWaitlist = (short) maxWaitlist;
		roster = new Student[maxEnrolled];
		waitlist = new Student[maxWaitlist];

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getMaxEnrolled() {
		return maxEnrolled;
	}

	public boolean setMaxEnrolled(int maxEnrolled) {

		if(maxEnrolled < numEnrolled) {

			return false;

		}
		else {

			// Create new bigger array and copy old array contents into
			// the new array.
			roster = expandArr(roster,maxEnrolled);

			// Move students from waitlist to roster
			for(int i=this.maxEnrolled; i<maxEnrolled; i++) {

				int waitlistIndex = i - this.maxEnrolled;

				if(waitlistIndex == maxWaitlist ||
						waitlist[waitlistIndex] == null) {
					break;
				}

				roster[i] = waitlist[waitlistIndex];
				waitlist[waitlistIndex] = null;
				numWaitlist--;
				numEnrolled++;

			}
			shiftStudentArr(waitlist);

			// Update max enrolled to the new number specified by user.
			this.maxEnrolled = (short) maxEnrolled;

			return true;

		}

	}

	public short getNumEnrolled() {
		return numEnrolled;
	}

	// no setter for numEnrolled because we want to control this variable
	// internally, as it's important to the logic of the program.

	public short getMaxWaitlist() {
		return maxWaitlist;
	}

	public boolean setMaxWaitlist(int maxWaitlist) {

		if(maxWaitlist < numWaitlist) {
			return false;
		}
		else {
			// Create new bigger array and copy old array contents into
			// the new array.
			waitlist = expandArr(waitlist,maxWaitlist);

			// Update max waitlist to the new number specified by user.
			this.maxWaitlist = (short) maxWaitlist;

			return true;
		}

	}

	public short getNumWaitlist() {
		return numWaitlist;
	}

	// no setter for numWaitlist because we want to control this variable
	// internally, as it's important to the logic of the program.

	public String getEnrolled() {
		return getStudents(roster);
	}

	public String getWaitlist() {
		return getStudents(waitlist);
	}

	public boolean addStudent(Student student) {

		if(student.isTuitionPaid() && !isStudentInArray(roster,student)
				&& !isStudentInArray(waitlist,student)) {

			// First, try adding student to roster.
			if(addStudentToArray(roster,student)) {
				numEnrolled++;
				return true;
			}
			// Otherwise, try adding student to waitlist
			else if(addStudentToArray(waitlist,student)) {
				numWaitlist++;
				return true;
			}
			else {
				return false;
			}

		}
		else {
			return false;
		}

	}

	public boolean dropStudent(Student student) {

		boolean studentDropped = false;

		if(dropStudentFromArr(roster,student)) {
			studentDropped = true;
			numEnrolled--;
			shiftStudentArr(roster);

			// if roster was previously full, move student from 1st waitlist
			// position to the open roster spot.
			if(numEnrolled == maxEnrolled - 1 && waitlist[0] != null) {
				roster[maxEnrolled - 1] = waitlist[0];
				numEnrolled++;
				waitlist[0] = null;
				numWaitlist--;
				shiftStudentArr(waitlist);
			}
		}
		else {

			if(dropStudentFromArr(waitlist,student)) {
				studentDropped = true;
				numWaitlist--;
				shiftStudentArr(waitlist);
			}

		}

		return studentDropped;

	}

/*

	public Student getStudent(String id) {

		for(Student student : roster) {
			if(student != null) {
				if(student.getID() == id) {
					return student;
				}
			}
		}
	}

*/

// ************************************************
// HELPER METHODS BELOW....
// ************************************************

	private Student[] expandArr(Student[] oldArr, int newArrLen) {

		Student[] newArr = new Student[newArrLen];

		for(int i=0; i < oldArr.length; i++) {
			if(oldArr[i] == null) {
				break;
			}
			newArr[i] = oldArr[i];
		}

		return newArr;

	}

	/*
	 * getStudents method below is private because "getEnrolled" and
	 * "getWaitlist" are easier to understand from the method name and
	 * by making their referenced method "getStudents" private we are in
	 * keeping with encapsulation principles.
	 */
	private String getStudents(Student[] studentArr) {

		String students = "";

		for(Student student : studentArr) {

			if(student != null) {
				students = students=="" ? students : students + "\n";
				students += "\t" + student.getName() + " - ID " + student.getID();
			}

		}

		return students;

	}

	private boolean dropStudentFromArr(Student[] studentArr, Student student) {

		for(int i=0; i < studentArr.length; i++) {
			if(studentArr[i] != null && studentArr[i].equals(student)) {
				studentArr[i] = null;
				return true;
			}
		}
		return false;

	}

	private void shiftStudentArr(Student[] studentArr) {

		int arrayLen = studentArr.length;
		Student[] newStudentArr = new Student[arrayLen];
		int newStudentArrIndex = 0;

		for(int i=0; i < arrayLen; i++) {
			if(studentArr[i] != null) {
				newStudentArr[newStudentArrIndex] = studentArr[i];
				newStudentArrIndex++;
			}
		}

		for(int i=0; i < arrayLen; i++) {
			studentArr[i] = newStudentArr[i];
		}

	}

	private boolean isStudentInArray(Student[] studentArr, Student student) {

		for(int i=0; i < studentArr.length; i++) {

			if(studentArr[i] == null) {
				return false;
			}
			else if (studentArr[i].equals(student)) {
				return true;
			}

		}
		return false;

	}

	private boolean addStudentToArray(Student[] studentArr, Student student) {

		for(int i=0; i < studentArr.length; i++) {

			if(studentArr[i] == null) {
				studentArr[i] = student;
				return true;
			}

		}
		return false;

	}

	public String toString() {

		return name + "\n" + numEnrolled + " enrolled (maximum allowed: "
				+ maxEnrolled + ")\n" + getEnrolled() + "\n" + numWaitlist
				+ " waitlisted (maximum allowed: " + maxWaitlist + ")\n"
				+ getWaitlist();

	}

}
