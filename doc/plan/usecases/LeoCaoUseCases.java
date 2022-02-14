public class LeoCaoUseCases{

  /**
   * User changes color theme
   */
  public void useCase1(){
    Select themeSelect = new Select("theme");
    Toolbar general = new General();
    general.add(themeSelect);
    String theme = themeSelect.getCurrentOption();
    Controller.setStyle(theme);
  }

  /**
   * User clicks to see history of commands
   */
  public void useCase2(){
    ModelState modelState = new ModelState();
    History history = modelState.getHistory();
    Window commandHistory =  new Window(history);
    commandHistory.display();
  }

  /**
   * User selects different command language
   */
  public void useCase3(){
    InputBox languageInput = new InputBox();
    String commandLanguage  = languageInput.submit();
    ModelState modelState = new ModelState();
    modelState.setCommandLanguage(commandLanguage);
  }
}