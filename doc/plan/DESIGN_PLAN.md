# SLogo Design Plan
### NAMES
Alex Bildner, Leo Cao, Edison Ooi, Marcus Ortiz

### TEAM
7

## Introduction



## Overview
* Backend API External Controller/Model: dictates functionality for the model, including state access, state modification, initialization, error
checking, and controlling the turtle. These are all functions that will be used by the view or controller, so they need to be external
APIs
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

* Backend API Internal:
  * Parsing
  * running
  * updating

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

![UI sketch](wireframe/ui.png "An initial UI")


## Design Details


## Design Considerations
Design Issue: How to check for errors
* Have the front end check for any errors and if it finds one, display that error and if not just display the next state
  * Advantages: The backend does not need to make a call to the frontend lowering dependencies and also making the model less reliable on the frontend that is used (can easily be interchanged)
  * Disadvantages: This means that the frontend has to do a lot of thinking that should be delegated to the backend
* Have the backend handle everything
  * Advantages: The backend/controller has quick knowledge of the errors and it is where most of the error handling should occur rather than the frontend
  * Disadvantages: Increases dependencies
* Our Current Decision: Have backend handle it

Design Issue: Who handles the speed of the animation
  * Controller
    * Advantages: It's easy to keep track of the overall time and states of the program all in the controller
    * Disadvantages: The job of animation speed is certainly a task that should be given to the frontend
  * Frontend
    * Advantages: The frontend should hold most of the animation control, and the user already calls the button for the speed in the user interface making it quite easy and clean to implement
    * Disadvantages: It's easy to keep track of the overall time and states of the program all in the controller
  * Our Current Decision: Frontend

Assumptions and Dependencies
* All unique shapes can be done using combinations of the basic commands, including repeat
* The Controller will handle both the frontend and backend and will depend on both
* The Frontend will have a large external API, but for the purpose of communicating to the controller not the backend
* The help display is static and does not show the help for the exact command, but rather all the commands
* We can use the AnimateFX github package that will allow quite a bit of timeline manipulation that our design is looking for

## Test Plan
### Testing Strategies Discussed
* Our goal with the design of our classes and API's is to make each component
as small as possible. For example, we initially wanted to feed the backend
a command and check if there was an error found all in the same method, but
realized that those two are fundamentally different functionalities and
in order to effectively test them, we could split them into two API methods,
one for feeding in a command and one for fetching any possible errors.
* Another strategy we employed was designing our API's such that the internal
API's could only be called between frontend classes, and same for backend.
On the other hand, external commands are intended only to be called by the
controller, so that adds a level of predictability to the possible inputs
or times that the external API methods could be called.

### Test Scenarios
#### Feature 1: Passing a command to backend to be parsed and turned into turtle states
* Test case 1: Input a command that uses the repeat x [] functionality. The number
of next states generated should equal x. This can be checked by looking at the size of the queue
of next states immediately after the command has finished processing.
* Test case 2: Input a series of x commands. Besides the turtle moving and
drawing in the expected manner, the command history should show the same
x commands ordered by recency. This can be checked by calling getHistory().
* Test case 3: Pass a malformed command into BackendExternalAPI.putInstruction().
The return value of this method should be false, and we should expect some
nonempty error message if we call getErrorText() immediately after.

#### Feature 2: Customizable UI attributes
* Test case 1: Ensure that the turtle speeds up or slows down appropriately
when the respective button is pressed. In the case that the speed is equal
to the max allowable speed, ensure that pressing the speed-up button does not
do anything, and that any commands run instantaneously move the turtle to
the final state. AKA, the parameter passed into FrontendInternalAPI.setSpeed()
should never be greater than the turtle max speed.
* Test case 2: Test a variety of theme resource files, and ensure the visual
properties match what is in the file. If there is an invalid field, the program
should not crash or throw an error, but instead provide a default value.
* Test case 3: Pass in a configuration file that contains an invalid language
option, or one that is not supported. Then call getErrorText() and expect
some valid text relevant to the invalid language choice, prompting the user
to modify the file.

#### Feature 3: Moving the turtle and drawing line
* Test case 1: Pass the example command to draw a circle. 
Observe to see if the turtle actually moves in a circle. Also, the final state of
  the turtle after it completes all of the steps should have the same location and
  direction as the initial state. This can be done by comparing the result of
  getCurrentTurtleState() before and after the command is run.
* Test case 2: Execute a command which moves the turtle x units to the right.
Then change the pen color, and move the turtle x/2 units back to the left. The
resulting line should be colored half with the old color, and half with the
new color.
* Test case 3: Pass a command that causes the turtle to move past the bounds
of the screen. Detect this error and display the text obtained from getErrorText()
before trying to update the next state of the turtle (invalid states will not be
added to the queue).

#### Feature 4: Saving/loading states
* Test case 1: Run a series of 5 commands and record what the initial and final
states are. Then run the same 5 commands except in between each command we save
the current state, exit the program, and then load the state back. The initial
and final states of that trial should be identical to the continuous trial.
* Test case 2: Load a state with the turtle out of bounds. There should be
an error text inside getErrorText() describing the error.
* Test case 3: Run the circle command. Then save the state, exit the program,
and change the resource file such that the turtle is a different image.
When we load back the state, everything should be the same, including
command history, the lines drawn, and position/direction of turtle. The only
change should be how the turtle looks.


## Team Responsibilities

 * Team Member #1: Edison
   * Fullstack
   * Controller class which orchestrates communication between frontend
   and backend and is in charge of when to call functionality from each
   side

 * Team Member #2: Jed
   * Backend
   * Parsing

 * Team Member #3: Marcus Ortiz
   * Frontend

 * Team Member #4: Leo Cao
   * Frontend

 * Team Member #5: Alex Bildner
   * Backend
 


  

      
