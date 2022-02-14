# SLogo Design Plan
### NAMES
Alex Bildner, Leo Cao, Edison Ooi, Marcus Ortiz

### TEAM
7

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
    * setLanguage


* Frontend API Internal
    * setSpeed
    * displayHelp

## User Interface
User interacts with program through toolbar and buttons to set speed, colors, play/pause, etc.
User observes turtle drawing, text outputs, errors. User
can input scripts and define commands with user input box.

![UI sketch](ui.png "An initial UI")


## Design Details


## Design Considerations
Design Issue: How to check for errors
* Have the front end check for any errors
  * If there is display errors
  * If no error, display next state
* Have the backend handle everything
  * Using the stop from Operating Systems

Design Issue:
* Who handles the speed of the animation
  * Controller
  * Frontend
    * How is the actual thing happening

Assumptions and Dependencies
* All unique shapes can be done using combinations of the basic commands, including repeat
* The Controller will handle both the frontend and backend and will depend on both
* The Frontend will have a large external API, but for the purpose of communicating to the controller not the backend
* The help display is static and does not show the help for the exact command, but rather all the commands
* We can use the AnimateFX github package that will allow quite a bit of timeline manipulation that our design is looking for

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
 


  

      
