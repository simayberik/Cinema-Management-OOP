# Cinema-Management-OOP
This is my term project for my course Object Oriented Programming. I had made a cinema ticket reservation desktop application using JAVA.
The aim of this project is to develop a cinema management system, a real-time system to reliably adjust the ticket bookings for any kind of movies and reserves the seat for the viewers.
# Purpose of the project:
The objective of this project is simply to provide a movie ticket booking where the customer is able to choose a movie in a specified hall, seat, date and hour.
The system is integrated to be used in a larger area that has typically several halls with casual seat order in each hall and it requiers and keeps customer’s data and ticket information and also checks the booking record while reservation. In aspect to this the customer is able to cancel the reservation of any time .
# Scope of the project:
To initilize the booking, the system requiers user to send detailed information of him/herself with collecting the selection inputs of movie, date and seat by use of GUI. After checking the booking record and the availabilities of  given inputs before the verify, the request is accepted and recorded with user and ticket data. User is able to cancel the booking of any time after the system checks and verifies if  the user data is recorded or not. In admin panel, admin can add any kinds of movies, halls and also delete them.
# Input/Form Design
The input to the system  starts with the staff/student login form, which is entered through the keyboard. If the process is succesfull, it follows other menus with their operations and processes like a cycle. Other input forms are message the creation of new admin operator and creation of staff and student, creation off movies and halls for admin and also cancelling processes can be achieved for both admin and the user. Input types like election of seats, halls and movies are generated if the client is user and they are not applicable for admin. For the GUI java swing WindowBuilders are used , lots of textfields, comboboxes and buttons takes input for which are referred below.
# Output Design
The output form is designed to generate printable reports from the database .The output is placed on a database as textfiles and contains information on the staff’s/user’s records. The output produced can be printed on a hard copy or viewed on the screen. The outputs generated include:
Admin Dashboard, User Dashboard, Movie Board, Hall Board, Ticket Board.
# Database Design
Text files are used in this project, and all the data is saved as String lines . The way of design that data is kept is similar to JSON object storing. There are several advantages of storing data like this because it makes simple while parsing any data.
All data is stored at three different separate textfiles which keeps movies, halls and all the clients including both admins and users . While saving movies, all the ticket and hall information belongs to that spesific movie are saved too in movie.txt file. When starting the application again, with load() method all data are parsed again from textfiles and placed into Queue Objects in orderly. There is an ‘Manager’ abstract class which controls all users, halls and movies and MovieManager, UserManager and HallManager extends this class. In Main method all managers are created and all data are loaded directly from the start. Main method starts with creating ViewLogin menu.


