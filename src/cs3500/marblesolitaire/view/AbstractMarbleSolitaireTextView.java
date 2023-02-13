package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents a standard display of a marble solitaire game (displays every
 * marble as implemented in the array with a space in between).
 */
public abstract class AbstractMarbleSolitaireTextView implements MarbleSolitaireView {
  protected MarbleSolitaireModelState model;
  protected Appendable out;

  /**
   * constructs a standard representation of a view.
   * @param model the backend processes of the game
   * @param out the output stream
   */
  public AbstractMarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable out) {
    if (model == null || out == null) {
      throw new IllegalArgumentException("Model is null");
    }
    this.model = model;
    this.out = out;
  }

  /**
   * displays the board in string format.
   *
   * @returns a string that displays the board
   */
  public String toString() {
    String display = "";
    int boardSize = model.getBoardSize();
    int armThickness = (boardSize + 2 ) / 3;
    int validLowerBound = armThickness - 1 ;
    int validUpperBound = 2 * (armThickness - 1) ;
    System.out.println(display);
    for (int row = 0; row < this.model.getBoardSize(); row++) {
      for (int col = 0; col < this.model.getBoardSize(); col++) {
        if (col == 0) {
          display = display + strSlot(row, col);
        }
        else if (col > validUpperBound && (model.getSlotAt(row, col)
                == MarbleSolitaireModelState.SlotState.Invalid)) {
          // do nothing if invalid in order to not add spaces
        }
        else {
          display = display + " " + strSlot(row, col);
        }
      }
      if (row != this.model.getBoardSize() - 1) {
        display = display + "\n";
      }
    }

    return display;
  }

  /**
   * returns the display of a single slot.
   * @param row represents the row in the board
   * @param col represents the col in the board
   * @returns the character version of the slot state
   */
  protected String strSlot(int row, int col) {
    MarbleSolitaireModelState.SlotState slot = model.getSlotAt(row, col);
    if (slot == MarbleSolitaireModelState.SlotState.Empty) {
      return "_";
    }
    else if (slot == MarbleSolitaireModelState.SlotState.Invalid) {
      return " ";
    }
    else {
      return "O";
    }
  }

  /**
   * displays the board in the current state of the model.
   * @throws IOException if the append command throws an error
   */
  public void renderBoard() throws IOException {
    try {
      this.out.append(this.toString() + '\n');
    } catch (IOException e) {
      throw new IOException("Transfer to Output Stream ");
    }
  }

  /**
   * displays a message from a controller.
   * @param message the message to be transmitted
   * @throws IOException if the append command throws an error
   */
  public void renderMessage(String message) throws IOException {
    try {
      this.out.append(message);
    } catch (IOException e) {
      throw new IOException("Transfer to Output Stream");
    }
  }
}
