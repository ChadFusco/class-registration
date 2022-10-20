# cs111b-java-programs
A sampling of programs I wrote in Java for CS111B at City College of San Francisco.  
[Project 1 - Credit Card Validator](#project-1---credit-card-validator-💳) | [Project 2 - Course Registration](#project-2---course-registration-👨‍🎓-👩‍🎓) | [Project 3 - Animal Kingdom](#project-3---animal-kingdom-🐋)

## Project 1 - Credit Card Validator 💳
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

## Project 2 - Course Registration 👨‍🎓 👩‍🎓
### What It Does
This is a course registration program. The program tracks the number of the students enrolled in and waitlisted for a course. It allows the user to take the following actions:
- Add a student

## Project 3 - Animal Kingdom 🐋
