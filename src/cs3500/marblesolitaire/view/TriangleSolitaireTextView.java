package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;

/**
 * A representation of the display of the current state of the game. This includes:
 * - any messages
 * - translating the board into string form
 * - displaying the board
 */
public class TriangleSolitaireTextView extends AbstractMarbleSolitaireTextView {
  public TriangleSolitaireTextView(MarbleSolitaireModelState model, Appendable out) {
    super(model, out);
  }

  public TriangleSolitaireTextView(MarbleSolitaireModelState model) {
    super(model, System.out);
  }

  /**
   * Transforms the array list of slot states in to the visual representation of the game.
   *
   * @return a string representation of the game at the model
   */
  public String toString() {
    String board_to_String = "";
    int numOfSpaces = model.getBoardSize() - 1;
    for (int row = 0; row < model.getBoardSize(); row ++ ) {
      for (int i = 0; i < numOfSpaces; i++) {
        board_to_String = board_to_String + " ";
      }
      for (int col = 0; col < model.getBoardSize(); col ++) {
        if (model.getSlotAt(row, col) == Invalid) {
          break;
        }
        else if (model.getSlotAt(row, col) == Marble) {
          if (col == 0) {
            board_to_String = board_to_String + "O";
          }
          else {
            board_to_String = board_to_String + " O";
          }
        }
        else if (model.getSlotAt(row, col) == Empty) {
          if (col == 0) {
            board_to_String = board_to_String + "_";
          }
          else {
            board_to_String = board_to_String + " _";
          }
        }
      }
      if (row != model.getBoardSize() - 1) {
        board_to_String = board_to_String + "\n";
      }
      numOfSpaces--;
    }
    return board_to_String;
  }
}
