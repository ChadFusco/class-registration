
## CourseEase
### What It Does
This is a course registration program. The program tracks the number of the students enrolled in and waitlisted for a course. It allows the user to take the following actions:
1. Add a student
2. Drop a student
3. Print the course
4. Expand or shrink the course roster
5. Expand or shrink the course waitlist

When a student is added, the program first attempts to add the student to the roster array of student objects. If the roster is full, the program then attempts to add the student to the waitlist.
The waitlist array is structured as a queue so that the first student added to the waitlist is the first student moved to the roster once a spot opens up. When a student is dropped from the roster, for example, the program automatically shifts the array and pushes the first-in student to the roster.
When the roster is expanded, students are automatically moved from the waitlist to the roster until the roster either becomes full or the waitlist becomes empty.
