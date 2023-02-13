import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.io.IOException;

/**
 * tests display method Marble Solitaire View.
 */
public class MarbleSolitaireTextViewTest {



  private EuropeanSolitaireModel europeanBoard = new EuropeanSolitaireModel();
  private EuropeanSolitaireModel europeanBoardDiffRowCol = new
          EuropeanSolitaireModel(1, 2);

  private Appendable outEB = new StringBuilder();

  private MarbleSolitaireTextView europeanBoardTextView = new
          MarbleSolitaireTextView(europeanBoard, outEB);

  private MarbleSolitaireTextView europeanBoardTextViewDiffRowCol = new
          MarbleSolitaireTextView(europeanBoardDiffRowCol, System.out);

  private String europeanBoardString =
          "    O O O\n"
          + "  O O O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "  O O O O O\n"
          + "    O O O";
  private String europeanBoardStringRenderBoard =
          "    O O O\n"
          + "  O O O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "  O O O O O\n"
          + "    O O O\n";

  private String europeanBoardStringDiffRowCol =
          "    O O O\n"
          + "  O _ O O O\n"
          + "O O O O O O O\n"
          + "O O O O O O O\n"
          + "O O O O O O O\n"
          + "  O O O O O\n"
          + "    O O O";

  private String boardToString = "    O O O\n    O O O\nO O O O O O O\nO O O _ O O O"
          + "\nO O O O O O O\n    O O O\n    O O O";

  private String boardToStringRenderBoard = "    O O O\n    O O O\nO O O O O O O\nO O O _ O O O"
          + "\nO O O O O O O\n    O O O\n    O O O\n";
  private MarbleSolitaireModel game1 = new EnglishSolitaireModel();
  private EnglishSolitaireModel game2 = new EnglishSolitaireModel(5, 6, 6);

  private Appendable out = new StringBuilder();
  private Appendable outD = new StringBuilder();
  private MarbleSolitaireTextView display1 = new MarbleSolitaireTextView(game1, outD);
  private MarbleSolitaireTextView display2 = new MarbleSolitaireTextView(game1, out);
  private MarbleSolitaireTextView display3 = new MarbleSolitaireTextView(game2);
  private String boardToString2 = "        O O O O O\n        O O O O O\n        O O O O O\n"
         + "        O O O O O\nO O O O O O O O O O O O O\nO O O O O O O O O O O O O"
         + "\nO O O O O O _ O O O O O O\nO O O O O O O O O O O O O\nO O O O O O O O O O O O O"
         + "\n        O O O O O\n        O O O O O\n        O O O O O\n        O O O O O";


  @Test
  public void testViewConstructorExceptionsOneArg() {
    assertThrows(IllegalArgumentException.class,
        () -> new MarbleSolitaireTextView(null));
  }

  @Test
  public void testViewConstructorExceptionsTwoArgs() {
    assertThrows(IllegalArgumentException.class,
        () -> new MarbleSolitaireTextView(null, new StringBuilder()));
    assertThrows(IllegalArgumentException.class,
        () -> new MarbleSolitaireTextView(new EnglishSolitaireModel(), null));
  }

  @Test
  public void testIOException() {
    Appendable out = new AppendableFail();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(model, out);
    assertThrows(IOException.class,
        () -> view.renderBoard());
    assertThrows(IOException.class,
        () -> view.renderMessage("hello"));

  }

  @Test
  public void testToString() {
    assertEquals(boardToString, display1.toString());
    assertEquals(boardToString2, display3.toString());

    assertEquals(europeanBoardString, europeanBoardTextView.toString());
    assertEquals(europeanBoardStringDiffRowCol, europeanBoardTextViewDiffRowCol.toString());
  }

  @Test
  public void testRenderBoard() {
    try {
      display1.renderBoard();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(boardToStringRenderBoard, outD.toString());

    try {
      europeanBoardTextView.renderBoard();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(europeanBoardStringRenderBoard, outEB.toString());

  }

  @Test
  public void testRenderMessage() {
    try {
      display2.renderMessage("Hello\n");

    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals("Hello\n", out.toString());
  }


}
