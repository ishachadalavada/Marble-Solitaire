import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/*
Controller tests
- european
- triangle
 */

/**
 Make sure the controller is using the model correctly.
 */

public class MarbleSolitaireControllerImplTest {
  private String outputPlayGameDiffAT = "        O O O O O\n        O O O O O\n        O O O O O"
          + "\n        O O O O O\nO O O O O O O O O O O O O\nO O O O O O O O O O O O O"
          + "\nO O O O O O _ O O O O O O\nO O O O O O O O O O O O O\nO O O O O O O O O O O O O"
          + "\n        O O O O O\n        O O O O O\n        O O O O O\n        O O O O O"
          + "\nScore: 104"
          + "\n        O O O O O\n        O O O O O\n        O O O O O\n        "
          + "O O O O O\nO O O O O O O O O O O O O\nO O O O O O O O O O O O O"
          + "\nO O O O O O O O O O O O O\nO O O O O O _ O O O O O O\nO O O O O O _ O O O O O O"
          + "\n        O O O O O\n        O O O O O\n        O O O O O\n        O O O O O"
          + "\nScore: 103\n"
          + "Game quit!\nState of game when quit:"
          + "\n        O O O O O\n        O O O O O\n        O O O O O\n        "
          + "O O O O O\nO O O O O O O O O O O O O\nO O O O O O O O O O O O O"
          + "\nO O O O O O O O O O O O O\nO O O O O O _ O O O O O O\nO O O O O O _ O O O O O O"
          + "\n        O O O O O\n        O O O O O\n        O O O O O\n        O O O O O"
          + "\nScore: 103\n";
  private String outputPlayGameDiffATRC = "        O O O O O\n        O O O O O\n        O O O O O"
          + "\n        O O O O O\nO O O O O O O O O O O O O\nO O O O O O O O O O O O O"
          + "\nO O O O O O O O O O O O O\nO O O O O O O O O O O O O\nO O O O O O O O O O _ O O"
          + "\n        O O O O O\n        O O O O O\n        O O O O O\n        O O O O O"
          + "\nScore: 104"
          + "\n        O O O O O\n        O O O O O\n        O O O O O\n        "
          + "O O O O O\nO O O O O O O O O O O O O\nO O O O O O O O O O O O O"
          + "\nO O O O O O O O O O O O O\nO O O O O O O O O O O O O\nO O O O O O O O _ _ O O O"
          + "\n        O O O O O\n        O O O O O\n        O O O O O\n        O O O O O"
          + "\nScore: 103\n"
          + "Game quit!\nState of game when quit:"
          + "\n        O O O O O\n        O O O O O\n        O O O O O\n        "
          + "O O O O O\nO O O O O O O O O O O O O\nO O O O O O O O O O O O O"
          + "\nO O O O O O O O O O O O O\nO O O O O O O O O O O O O\nO O O O O O O O _ _ O O O"
          + "\n        O O O O O\n        O O O O O\n        O O O O O\n        O O O O O"
          + "\nScore: 103\n";

  private String outputPlayGameDiffRC = "    O O O\n    O O O\nO O O O O O O\nO O O O O O O"
          + "\nO O O O O _ O\n    O O O\n    O O O\nScore: 32"
          + "\n    O O O\n    O O O\nO O O O O O O\nO O O O O O O"
          + "\nO O O _ _ O O\n    O O O\n    O O O\nScore: 31"
          + "\nGame quit!\nState of game when quit:\n"
          + "    O O O\n    O O O\nO O O O O O O\nO O O O O O O"
          + "\nO O O _ _ O O\n    O O O\n    O O O\nScore: 31\n";

  private String gameQuitPlayGame = "    O O O\n    O O O\nO O O O O O O\nO O O _ O O O"
          + "\nO O O O O O O\n    O O O\n    O O O\nScore: 32\nGame quit!\nState of game when quit:"
          + "\n    O O O\n    O O O\nO O O O O O O\nO O O _ O O O"
          + "\nO O O O O O O\n    O O O\n    O O O\nScore: 32\n";

  private String invalidMovePlayGameD = "    O O O\n    O O O\nO O O O O O O\nO O O _ O O O"
          + "\nO O O O O O O\n    O O O\n    O O O\nScore: 32\n"
          + "Invalid Move. Play Again. Invalid distance between from and to marble"
          + "\nGame quit!\nState of game when quit:"
          + "\n    O O O\n    O O O\nO O O O O O O\nO O O _ O O O"
          + "\nO O O O O O O\n    O O O\n    O O O\nScore: 32\n";

  private String invalidMovePlayGameSS = "    O O O\n    O O O\nO O O O O O O\nO O O _ O O O"
          + "\nO O O O O O O\n    O O O\n    O O O\nScore: 32\n"
          + "Invalid Move. Play Again. SlotState for from, to, or middle marble is not valid"
          + "\nGame quit!\nState of game when quit:\n"
          + "    O O O\n    O O O\nO O O O O O O\nO O O _ O O O"
          + "\nO O O O O O O\n    O O O\n    O O O\nScore: 32\n";

  private String invalidMovePlayGameOB = "    O O O\n    O O O\nO O O O O O O\nO O O _ O O O"
          + "\nO O O O O O O\n    O O O\n    O O O\nScore: 32\n"
          + "Invalid Move. Play Again. Out of Bounds of the board"
          + "\nGame quit!\nState of game when quit:\n"
          + "    O O O\n    O O O\nO O O O O O O\nO O O _ O O O"
          + "\nO O O O O O O\n    O O O\n    O O O\nScore: 32\n";

  // invalid input other character- not an int
  private String invalidInputPlayGameC = "    O O O\n    O O O\nO O O O O O O\nO O O _ O O O"
          + "\nO O O O O O O\n    O O O\n    O O O\nScore: 32"
          + "\nCan't input non-int message. Please enter again.\n    O O O"
          + "\n    O O O\nO O O O O O O\nO O O O O O O"
          + "\nO O O _ O O O\n    O _ O\n    O O O\nScore: 31"
          + "\nGame quit!\nState of game when quit:\n"
          + "    O O O\n    O O O\nO O O O O O O\nO O O O O O O"
          + "\nO O O _ O O O\n    O _ O\n    O O O\nScore: 31\n";


  // invalid input other character - negative
  private String invalidInputPlayGameN = "    O O O\n    O O O\nO O O O O O O\nO O O _ O O O"
          + "\nO O O O O O O\n    O O O\n    O O O\nScore: 32\nCan't input negative message. "
          + "Please enter again.\n    O O O"
          + "\n    O O O\nO O O O O O O\nO O O O O O O"
          + "\nO O O _ O O O\n    O _ O\n    O O O\nScore: 31"
          + "\nGame quit!\nState of game when quit:\n"
          + "    O O O\n    O O O\nO O O O O O O\nO O O O O O O"
          + "\nO O O _ O O O\n    O _ O\n    O O O\nScore: 31\n";

  private String invalidInputPlayGametc = "    O O O\n    O O O\nO O O O O O O\nO O O _ O O O"
          + "\nO O O O O O O\n    O O O\n    O O O\nScore: 32\nCan't input negative message. "
          + "Please enter again.\n    O O O"
          + "\n    O O O\nO O O O O O O\nO O O O O O O"
          + "\nO O O _ O O O\n    O _ O\n    O O O\nScore: 31"
          + "\nGame quit!\nState of game when quit:\n"
          + "    O O O\n    O O O\nO O O O O O O\nO O O O O O O"
          + "\nO O O _ O O O\n    O _ O\n    O O O\nScore: 31\n";

  private String endGame1 = "    O O O\n    O O O\nO O O O O O O\nO O O _ O O O"
          + "\nO O O O O O O\n    O O O\n    O O O\nScore: 32\n"
          + "    O O O\n    O O O\nO O O O O O O\nO O O O O O O"
          + "\nO O O _ O O O\n    O _ O\n    O O O\nScore: 31\n"
          + "    O O O\n    O O O\nO O O _ O O O\nO O O _ O O O"
          + "\nO O O O O O O\n    O _ O\n    O O O\nScore: 30\n"
          + "    O _ O\n    O _ O\nO O O O O O O\nO O O _ O O O"
          + "\nO O O O O O O\n    O _ O\n    O O O\nScore: 29\n"
          + "    O _ O\n    O _ O\nO O O O O O O\nO O O O _ _ O"
          + "\nO O O O O O O\n    O _ O\n    O O O\nScore: 28\n"
          + "    O _ O\n    O _ O\nO O O O O O O\nO O _ _ O _ O"
          + "\nO O O O O O O\n    O _ O\n    O O O\nScore: 27\n"
          + "    O _ O\n    O _ O\nO O O O O O O\n_ _ O _ O _ O"
          + "\nO O O O O O O\n    O _ O\n    O O O\nScore: 26\n"
          + "Game over!\n"
          + "    O _ O\n    O _ O\nO O O O O O O\n_ _ O _ O _ O"
          + "\nO O O O O O O\n    O _ O\n    O O O\nScore: 26\n";


  // write a game with a normal center
  // write a game with an offset center (not in any line of symmetry)


  @Test
  public void createInvalidController() {
    Reader controllerIn = new StringReader("6 4 4 4 4 3 4 5 q");
    StringBuilder controllerOut = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(model, controllerOut);

    assertThrows(IllegalArgumentException.class,
        () -> new MarbleSolitaireControllerImpl(null, view, controllerIn));

    assertThrows(IllegalArgumentException.class,
        () -> new MarbleSolitaireControllerImpl(model, null, controllerIn));

    assertThrows(IllegalArgumentException.class,
        () -> new MarbleSolitaireControllerImpl(model, view, null));
  }

  @Test
  public void createInvalidIOException() {
    Reader controllerIn = new StringReader("6 4 4 4 4 3");
    StringBuilder controllerOut = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(model, controllerOut);
    MarbleSolitaireControllerImpl controller =
            new MarbleSolitaireControllerImpl(model, view, controllerIn);

    assertThrows(IllegalStateException.class,
        () -> controller.playGame());
  }

  @Test
  public void createInvalidNumberOfInputs() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    AppendableFail out = new AppendableFail();
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(model, out);
    assertThrows(IOException.class,
        () -> view.renderBoard());
  }

  // tests how controller handles model exception error displays
  @Test
  public void testInvalidInputMove() {
    // distance is off
    MarbleSolitaireModel modelD = new EnglishSolitaireModel();
    Appendable outD = new StringBuilder();
    Reader inD = new StringReader("6 4 3 4 q");
    MarbleSolitaireTextView viewD = new MarbleSolitaireTextView(modelD, outD);
    MarbleSolitaireControllerImpl controllerD
            = new MarbleSolitaireControllerImpl(modelD, viewD, inD);
    controllerD.playGame();

    assertEquals(invalidMovePlayGameD, outD.toString());

    // A Slot State of one of the from, to, or middle positions are wrong
    MarbleSolitaireModel modelSS = new EnglishSolitaireModel();
    Appendable outSS = new StringBuilder();
    Reader inSS = new StringReader("5 3 3 3 q");
    MarbleSolitaireTextView viewSS = new MarbleSolitaireTextView(modelSS, outSS);
    MarbleSolitaireControllerImpl controllerSS
            = new MarbleSolitaireControllerImpl(modelSS, viewSS, inSS);

    controllerSS.playGame();
    assertEquals(invalidMovePlayGameSS, outSS.toString());

    // Move is off the board
    MarbleSolitaireModel modelOB = new EnglishSolitaireModel();
    Appendable outOB = new StringBuilder();
    Reader inOB = new StringReader("8 6 8 8 q");
    MarbleSolitaireTextView viewOB = new MarbleSolitaireTextView(modelOB, outOB);
    MarbleSolitaireControllerImpl controllerOB
            = new MarbleSolitaireControllerImpl(modelOB, viewOB, inOB);
    controllerOB.playGame();
    assertEquals(invalidMovePlayGameOB, outOB.toString());


  }

  @Test
  public void testControllerInput() {
    // tests input
    Reader controllerIn = new StringReader("6 4 4 4 4 3 4 5 q");
    StringBuilder controllerOut = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(model, controllerOut);
    ControllerInput controller = new ControllerInput(model, view, controllerIn, log);
    String expectedInput = "64444345q";

    controller.playGame();
    assertEquals(expectedInput, log.toString());
  }

  @Test
  public void testModelInput() {
    // tests input
    Reader controllerIn = new StringReader("6 4 4 4 q");
    StringBuilder controllerOut = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new ModelMock(log);
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(model, controllerOut);
    MarbleSolitaireControllerImpl controller =
            new MarbleSolitaireControllerImpl(model, view, controllerIn);
    String expectedInput = "5333";

    controller.playGame();
    assertEquals(expectedInput, log.toString());

    // test input with invalid move and invalid inputs mixed in between
    Reader controllerInInvalidInput = new StringReader("A 6 4 B 3 4 6 4 B 4 4 q");//
    StringBuilder controllerOutInvalidInput = new StringBuilder();
    StringBuilder logInvalidInput = new StringBuilder();
    MarbleSolitaireModel modelInvalidInput = new ModelMock(logInvalidInput);
    MarbleSolitaireTextView viewInvalidInput =
            new MarbleSolitaireTextView(modelInvalidInput, controllerOutInvalidInput);
    MarbleSolitaireControllerImpl controllerInvalidInput =
            new MarbleSolitaireControllerImpl(modelInvalidInput,
                    viewInvalidInput, controllerInInvalidInput);
    String expectedInputInvalidInput = "53235333";

    controllerInvalidInput.playGame();
    assertEquals(expectedInputInvalidInput, logInvalidInput.toString());
  }

  @Test
  public void testDiffModels() {
    Reader controllerInDiffAT = new StringReader("9 7 7 7 q");
    StringBuilder controllerOutDiffAT = new StringBuilder();
    MarbleSolitaireModel modelDiffAT = new EnglishSolitaireModel(5);
    MarbleSolitaireTextView viewDiffAT = new MarbleSolitaireTextView(modelDiffAT,
            controllerOutDiffAT);
    MarbleSolitaireControllerImpl controllerDiffAT =
            new MarbleSolitaireControllerImpl(modelDiffAT, viewDiffAT, controllerInDiffAT);

    controllerDiffAT.playGame();
    assertEquals(outputPlayGameDiffAT, controllerOutDiffAT.toString());

    Reader controllerInDiffATRC = new StringReader("9 9 9 11 q");
    StringBuilder controllerOutDiffATRC = new StringBuilder();
    MarbleSolitaireModel modelDiffATRC = new EnglishSolitaireModel(5, 8,10);
    MarbleSolitaireTextView viewDiffATRC = new MarbleSolitaireTextView(modelDiffATRC,
            controllerOutDiffATRC);
    MarbleSolitaireControllerImpl controllerDiffATRC =
            new MarbleSolitaireControllerImpl(modelDiffATRC, viewDiffATRC, controllerInDiffATRC);

    controllerDiffATRC.playGame();
    assertEquals(outputPlayGameDiffATRC, controllerOutDiffATRC.toString());

    Reader controllerInDiffRC = new StringReader("5 4 5 6 q");
    StringBuilder controllerOutDiffRC = new StringBuilder();
    MarbleSolitaireModel modelDiffRC = new EnglishSolitaireModel(4,5);
    MarbleSolitaireTextView viewDiffRC = new MarbleSolitaireTextView(modelDiffRC,
            controllerOutDiffRC);
    MarbleSolitaireControllerImpl controllerDiffRC =
            new MarbleSolitaireControllerImpl(modelDiffRC, viewDiffRC, controllerInDiffRC);

    controllerDiffRC.playGame();
    assertEquals(outputPlayGameDiffRC, controllerOutDiffRC.toString());
  }

  @Test
  public void testInvalidInput() {
    // different character (non-integer) from row
    Reader invalidInputControllerInfr = new StringReader("A 6 4 4 4 q");
    StringBuilder invalidInputControllerOutfr = new StringBuilder();
    MarbleSolitaireModel invalidInputModelfr = new EnglishSolitaireModel();
    MarbleSolitaireTextView invalidInputViewfr = new MarbleSolitaireTextView(invalidInputModelfr,
            invalidInputControllerOutfr);
    MarbleSolitaireControllerImpl invalidInputControllerfr =
            new MarbleSolitaireControllerImpl(invalidInputModelfr, invalidInputViewfr,
                    invalidInputControllerInfr);

    invalidInputControllerfr.playGame();
    assertEquals(invalidInputPlayGameC, invalidInputControllerOutfr.toString());

    // different character (non-integer) from col
    Reader invalidInputControllerInfc = new StringReader("6 A 4 4 4 q");
    StringBuilder invalidInputControllerOutfc = new StringBuilder();
    MarbleSolitaireModel invalidInputModelfc = new EnglishSolitaireModel();
    MarbleSolitaireTextView invalidInputViewfc = new MarbleSolitaireTextView(invalidInputModelfc,
            invalidInputControllerOutfc);
    MarbleSolitaireControllerImpl invalidInputControllerfc =
            new MarbleSolitaireControllerImpl(invalidInputModelfc, invalidInputViewfc,
                    invalidInputControllerInfc);

    invalidInputControllerfc.playGame();
    assertEquals(invalidInputPlayGameC, invalidInputControllerOutfc.toString());

    // negative number to row
    Reader invalidInputControllerIntr = new StringReader("6 4 -5 4 4 q");
    StringBuilder invalidInputControllerOuttr = new StringBuilder();
    MarbleSolitaireModel invalidInputModeltr = new EnglishSolitaireModel();
    MarbleSolitaireTextView invalidInputViewtr = new MarbleSolitaireTextView(
            invalidInputModeltr, invalidInputControllerOuttr);
    MarbleSolitaireControllerImpl invalidInputControllertr =
            new MarbleSolitaireControllerImpl(invalidInputModeltr, invalidInputViewtr,
                    invalidInputControllerIntr);

    invalidInputControllertr.playGame();
    assertEquals(invalidInputPlayGameN, invalidInputControllerOuttr.toString());

    // negative number to col
    Reader invalidInputControllerIntc = new StringReader("6 4 4 -5 4 q");
    StringBuilder invalidInputControllerOuttc = new StringBuilder();
    MarbleSolitaireModel invalidInputModeltc = new EnglishSolitaireModel();
    MarbleSolitaireTextView invalidInputViewtc = new MarbleSolitaireTextView(
            invalidInputModeltc, invalidInputControllerOuttc);
    MarbleSolitaireControllerImpl invalidInputControllertc =
            new MarbleSolitaireControllerImpl(invalidInputModeltc, invalidInputViewtc,
                    invalidInputControllerIntc);

    invalidInputControllertc.playGame();
    assertEquals(invalidInputPlayGameN, invalidInputControllerOuttc.toString());
  }

  @Test
  public void testGameQuits() {
    Reader controllerInlqfr = new StringReader("q");
    StringBuilder controllerOutlqfr = new StringBuilder();
    MarbleSolitaireModel modellqfr = new EnglishSolitaireModel();
    MarbleSolitaireTextView viewlqfr = new MarbleSolitaireTextView(modellqfr, controllerOutlqfr);
    MarbleSolitaireControllerImpl controllerlqfr = new MarbleSolitaireControllerImpl(modellqfr,
            viewlqfr, controllerInlqfr);

    controllerlqfr.playGame();
    assertEquals(gameQuitPlayGame, controllerOutlqfr.toString());

    Reader controllerInUQfc = new StringReader("6 Q");
    StringBuilder controllerOutUQfc = new StringBuilder();
    MarbleSolitaireModel modelUQfc = new EnglishSolitaireModel();
    MarbleSolitaireTextView viewUQfc = new MarbleSolitaireTextView(modelUQfc, controllerOutUQfc);
    MarbleSolitaireControllerImpl controllerUQfc = new MarbleSolitaireControllerImpl(modelUQfc,
            viewUQfc, controllerInUQfc);

    controllerUQfc.playGame();
    assertEquals(gameQuitPlayGame, controllerOutUQfc.toString());

    Reader controllerInUQtr = new StringReader("6 4 Q 4 4");
    StringBuilder controllerOutUQtr = new StringBuilder();
    MarbleSolitaireModel modelUQtr = new EnglishSolitaireModel();
    MarbleSolitaireTextView viewUQtr = new MarbleSolitaireTextView(modelUQtr, controllerOutUQtr);
    MarbleSolitaireControllerImpl controllerUQtr = new MarbleSolitaireControllerImpl(modelUQtr,
            viewUQtr, controllerInUQtr);

    controllerUQtr.playGame();
    assertEquals(gameQuitPlayGame, controllerOutUQtr.toString());

    Reader controllerInUQtc = new StringReader("6 6 6 Q 4 4");
    StringBuilder controllerOutUQtc = new StringBuilder();
    MarbleSolitaireModel modelUQtc = new EnglishSolitaireModel();
    MarbleSolitaireTextView viewUQtc = new MarbleSolitaireTextView(modelUQtc, controllerOutUQtc);
    MarbleSolitaireControllerImpl controllerUQtc = new MarbleSolitaireControllerImpl(modelUQtc,
            viewUQtc, controllerInUQtc);

    controllerUQtc.playGame();
    assertEquals(gameQuitPlayGame, controllerOutUQtc.toString());
  }


  //tests a full game from start to finish
  @Test
  public void testGameOver() {
    Reader controllerIn = new StringReader("6 4 4 4 3 4 5 4 1 4 3 4 4 6 4 4 4 3 4 5 4 1 4 3");
    StringBuilder controllerOut = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(model, controllerOut);
    MarbleSolitaireControllerImpl controller =
            new MarbleSolitaireControllerImpl(model, view, controllerIn);

    controller.playGame();
    assertEquals(endGame1, controllerOut.toString());


  }
}