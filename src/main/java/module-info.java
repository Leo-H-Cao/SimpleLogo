open module slogo_app {
  // list all imported class packages since they are dependencies
  requires javafx.controls;
  requires javafx.graphics;
  requires javafx.base;
  requires javafx.media;
  requires javafx.web;
  requires java.logging;
  requires org.jooq.jool;

  // allow other classes to access listed packages in your project
  exports slogo;
  exports slogo.BackendExternalAPIs;
  exports slogo.BackendInternalAPIs;
  exports slogo.Backend;
  exports slogo.Backend.SyntaxParser;
  exports slogo.Backend.LexicalAnalyzer;
  exports slogo.Backend.State;
  exports slogo.Backend.TurtleState;
  exports slogo.Frontend;
  exports slogo.FrontendExternalAPIs;
  exports slogo.FrontendInternalAPIs;
  exports slogo.Backend.TurtleTransformers;
  exports slogo.Frontend.MenuItems;
  exports slogo.Backend.SyntaxParser.Math;
}
