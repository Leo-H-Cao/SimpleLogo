# DESIGN Document for SLogo

## NAME(s)
Leo Cao, Jed Yang, Edison Ooi, Alex Bildner

  
  

## Role(s)

  

* Team member #1: Edison Ooi
	* Controller
	* "Fullstack", some frontend (turtle animation) and backend (implementing some turtle commands)
	* Linking frontend and backend through the controller using external API methods
	* Debugging and testing in general

* Team member #2

* Team member #3

  

* Team member #4

  
  

## Design Goals
Our goal was to follow Model-View-Controller architecture such that implementation details could be sufficiently abstracted away into just a few external API methods. We wanted to make our code as modular and extendible as possible, meaning lots of API's, abstract classes, and interfaces.
  
  

## High-Level Design
Our design follows the Model-View-Controller architecture, meaning there is never direct communication between our frontend and our backend, nor does either end need to know implementation details or API's of the other. The SLogoController class acts as both the middle man to our frontend and backend as well as a general "owner" of an entire instance of SLogo.

All stateful logic and nontrivial calculations are placed in our backend code, whereas all visual components and their accompanying logic is in our frontend code. These are separated into their respective packages. The controller oversees and owns both ends, passing data from one to the other through external API method calls.
  
  

## Assumptions or Simplifications
* Multiple turtles are not supported
* Command language is the only preference that can be altered by the user. No preferences, visual or backend, can be altered mid-program.
* The user is responsible for making sure their commands do not move the turtle out of the window.

  
  

## Changes from the Plan
* Backend no longer maintains any knowledge of the "tracks" of a turtle, only the discrete locations which a turtle has moved to
* Checking validity of a command is no longer a backend external command, it has been moved internal
  
  

## How to Add New Features
Because of the modularity of our design, adding new features is relatively straightforward, as long as the API's are adhered to.

#### Adding new language Command  
Add a new subclass of Operator that has the same name as the command and override its abstract methods. If the command also moves the turtle, create a new implementor of TurtleTransformer of the same name and implement its methods. In SlogoToJava.properties, add its appropriate key-value pair in the same format as all the existing pairs. Finally, add its appropriate translation to all of the specific language properties files.  
  
#### Adding new front end component  
The frontend is owned by the View class, which owns a MainUI object, which stores all of its components in its BorderPane named layout. To add a new frontend component, just add a JavaFX node to that BorderPane in the appropriate pane and, if needed, make a reference to it as an instance variable in MainUI.

#### New feature example 
One easy feature to implement would be undoing a certain command. Our program saves every single intermediate turtle state for the entire lifespan of the program in a Deque<Deque< Turtle>>, so reverting/undoing back to a certain command is as simple as moving the turtle back to the last entry in its respective Deque. This could either be done instantaneously or by reverse iterating through the Deques and playing a reversed animation.
