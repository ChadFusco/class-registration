# cs111b-java-programs
A sampling of programs I wrote in Java for CS111B at City College of San Francisco.  
[Project 1 - Credit Card Validator 💳](#project-1---credit-card-validator) | [Project 2 - Course Registration 👩‍🎓](#project-2---course-registration) | [Project 3 - Animal Kingdom 🐋](#project-3---animal-kingdom)

## Project 1 - Credit Card Validator
### What It Does
This program validates a credit card entered by the user. Validation checks performed are:
- Checks if card is expired.
  - Prompts user to reenter year if expiration year is before current year.
  - Prompts user to reenter month if card expires this year and expiration month is before current month. Program prints a warning if card is set to expire this month.
- Checks that card number is valid by verifying that it:
  - has a valid number of digits.
  - starts with a 4, 5, or 6.
  - passes the Checksum test using the Luhn algorithm described [here](https://en.wikipedia.org/wiki/Luhn_algorithm).
### What I Learned
This little project was a good refresher for me in Java fundamentals such as conditionals, logical and relational operators, looping structures, data types, and the principle of encapsulation to make reusable code. This was also good practice in programming in a strongly-typed language, as the project involves many different data types and conversions between them.

## Project 2 - Course Registration
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
### What I Learned
This program was a nice exercise for me in object-oriented programming principles, and an exposure to queue and stack data structures. The program consists of three custom classes (not including the tester classes): Student, Course, and InterativeDriver. This was another good exercise to writing reusable code. In keeping with the principle of encapsulation, instance data variables and helper methods are private, and getter and setter methods were written to access the variables as appropriate.

## Project 3 - Animal Kingdom\🐋
