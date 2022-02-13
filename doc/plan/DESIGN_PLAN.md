# SLogo Design Plan
### NAMES
Alex Bildner, Leo Cao, Edison Ooi, Marcus Ortiz

### TEAM
7


#### Examples

Here is a graphical look at my design:

![This is cool, too bad you can't see it](online-shopping-uml-example.png "An initial UI")

made from [a tool that generates UML from existing code](http://staruml.io/).


Here is our amazing UI:

![This is cool, too bad you can't see it](29-sketched-ui-wireframe.jpg "An alternate design")

taken from [Brilliant Examples of Sketched UI Wireframes and Mock-Ups](https://onextrapixel.com/40-brilliant-examples-of-sketched-ui-wireframes-and-mock-ups/).


## Introduction


## Overview
* Backend API External Controller/Model
    * returns the next state of the turtle after processing
    * Possibly use a Queue, to have the future states set up
    * get the next instruction(s) from the front end
    * get the tracks drawn by the turtle
    * getNextTurtleState
    * getHelp
    * getHistory
    * loadFile
    * getLanguage
    * setLanguage
    * getUserVariables
    * getUserCommands
    * checkValidity    // Checking if the command is valid
    * checkResult  // Checking what the valid result is
    * getErrorText

* Frontend API External
    * getInputText
    * displayTurtle (turtle image)
    * putTurtleState
    * setStyle
    * putError
    * displayHelp
    * setLanguage


* Frontend API Internal
    * setSpeed

## User Interface


## Design Details


## Design Considerations
Design Issue: Getting next state
Have the frontend check error 
* Have the front end check for any errors
* If there is display errors
* If no error, display next state
Have the backend handle everything
* Using the stop from Operating Systems

Design Issue:
* The speed of the animation, who handles it
    * How is the acutal thing happening


## Test Plan


## Team Responsibilities

 * Team Member #1: Edison
   * Fullstack
   * Controller class which orchestrates communication between frontend
   and backend

 * Team Member #2: Jed
   * Backend
   * Parsing

 * Team Member #3: Marcus Ortiz
   * Frontend

 * Team Member #4: Leo Cao
   * Frontend

 * Team Member #5: Alex Bildner
   * Backend
 


  

      
