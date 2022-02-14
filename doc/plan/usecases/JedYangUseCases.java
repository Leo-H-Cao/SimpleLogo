public class JedYangUseCases {

  /*
  Parser parses the commands in file1.txt and runner converts the code into an abstract syntax tree
   */
  public void UseCase1(){
    Parser p = new Parser();
    LexResult tokens = p.parseCommand("file1.txt");
    Runner turtleRunner = new Runner();
    AST tree = turtleRunner.runLexicalAnalyzer(tokens);
  }

  /*
  turtle steps to the next instruction and the new state gets stored into a stack
   */
  public void UseCase2(Turtle t, AST tree, ASTNode currentInstCounter){
    Turtle newTurtle = t.step(tree);
    Updater.addTurtleToHistory(newTurtle);

  }

  /*
  adds a queue of turtles (representing its movement after the current set of instructions_
   to the list of queues (representing the total history of the turtle's movement)
   */
  public void UseCase3(Queue<Turtle> turtleQueue){
    Runner turtleRunner = new Runner();
    turtleRunner.addTurtleQueueToHistory(turtleQueue);
  }
}