SLogo
====

This project implements a development environment that helps users write programs to draw using a turtle.

Names: Jed Yang, Alex Bildner, Leo Cao, Edison Ooi, Marcus Ortiz


### Timeline

Start Date: Feb 10, 2022

Finish Date: March 4, 2022

Hours Spent: 80-100

### Primary Roles
* Jed: Backend
* Alex: Backend
* Leo: Frontend
* Marcus: Frontend
* Edison: Controller/fullstack


### Resources Used


### Running the Program

Main class:

Data files needed: 
* Specific language properties files in src/main/resources/slogo/languages
* CommandToClassDirectory.properties
* stylesheet.css
* pen.png and turtle.png for default appearances

Features implemented:
* All movement commands
* All math commands
* Functional commands such as repeat, dotimes, for, if, and ifelse
* User defined variables
* User defined commands
* Set pen color and background color at runtime
* Select command language at start
* Variable animation speed
* User-friendly error handling
* Create multiple SLogo instances in separate windows


### Notes/Assumptions

Assumptions or Simplifications:
* Only one turtle can exist in each instance
* Each command and its arguments must be separated by whitespace (e.g. 
there must be a space between an opening bracket and the first operator
inside the bracket)
* 

Interesting data files:

Known Bugs:
* The turtle can move outside its window
* 

Noteworthy Features:


### Impressions
Overall this project was a true test of good design patterns and API's.
Integrating all three components of our MVC architecture went incredibly
smoothly because of our well-defined API's. The use of reflection also
allowed us to cut down a lot on messy and unreliable code to support
an arbitrary number of commands or other dynamically created data. Lastly,
the emphasis on testing not only changed our perspective of how to be
reliable programmers, but it also made it clear whether or not our ideas
would work by forcing us to think about the use cases in advance.

SLogo was a fun exploration of these new strategies and as a team we have all
learned something valuable from doing this project.

