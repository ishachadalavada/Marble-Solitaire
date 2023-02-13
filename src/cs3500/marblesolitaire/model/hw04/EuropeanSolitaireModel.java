package cs3500.marblesolitaire.model.hw04;

/**
 * Represents a game of european solitaire model, a game with an octogonal board
 * and otherwise operates under the typical format of a marble solitaire game (the version
 * in abstract solitaire model).
 */
public class EuropeanSolitaireModel extends AbstractMarbleSolitaireModel {

  /**
   * constructs a european solitaire model that takes in the necessary parameters
   * to build a board.
   * @param armThickness size of the board
   * @param row empty slot to start game (row).
   * @param col empty slot to start game (col).
   * @throws IllegalArgumentException if arm thickness is less than 0 or is odd
   * @throws IllegalArgumentException if row and col are out of bounds or are in an invalid slot
   */
  public EuropeanSolitaireModel(int armThickness, int row, int col)
          throws IllegalArgumentException {
    super(armThickness, row, col);


  }

  /**
   * constructs a european solitaire model that takes in the necessary parameters
   * to build a board, defaulting arm thickness to 3.
   * @param row empty slot to start game (row).
   * @param col empty slot to start game (col).
   * @throws IllegalArgumentException if arm thickness is less than 0 or is odd
   * @throws IllegalArgumentException if row and col are out of bounds or are in an invalid slot
   */
  public EuropeanSolitaireModel(int row, int col)
          throws IllegalArgumentException {
    super(3, row, col);
  }

  /**
   * constructs a european solitaire model that takes in the necessary parameters
   * to build a board, defaulting row and col to the center position of the board.
   * @param armThickness size of the board
   * @throws IllegalArgumentException if arm thickness is less than 0 or is odd
   * @throws IllegalArgumentException if row and col are out of bounds or are in an invalid slot
   */
  public EuropeanSolitaireModel(int armThickness)
          throws IllegalArgumentException {
    super(armThickness, ((armThickness * 3) - 3)  / 2, ((armThickness * 3) - 3)  /  2);
  }

  /**
   * constructs a european solitaire model that takes in the necessary parameters
   * to build a board, defaulting arm thickness to 3 and row and col to the center slot.
   * @throws IllegalArgumentException if arm thickness is less than 0 or is odd
   * @throws IllegalArgumentException if row and col are out of bounds or are in an invalid slot
   */
  public EuropeanSolitaireModel()
          throws IllegalArgumentException {
    super(3,3,3);
  }

  /**
   * initializes the board at the start of the game.
   * @return a 2D array of slot states
   */
  @Override
  protected SlotState[][] initBoard() {

    SlotState[][] board = new SlotState[this.getBoardSize()][this.getBoardSize()];

    for (int r = 0; r < this.getBoardSize(); r++) {
      for (int c = 0; c < this.getBoardSize(); c++) {
        board[r][c] = SlotState.Invalid;
      }
    }


    // already should be an int because checked that armThickness is odd
    int validLowerBoundCol = (this.armThickness - 1);
    int validUpperBoundCol = validLowerBoundCol + (armThickness - 1);

    int validLowerBoundRow  = (armThickness - 1);
    int validUpperBoundRow = validLowerBoundRow + (armThickness - 1);


    for (int r = 0; r < this.getBoardSize(); r++) {
      if (r >= validUpperBoundRow) {
        validLowerBoundCol++;
        validUpperBoundCol--;
      }
      for (int c = 0; c < this.getBoardSize(); c++) {
        if ((c >= validLowerBoundCol) && (c <= validUpperBoundCol)) {
          board[r][c] = SlotState.Marble;
        }
      }
      if (r <= validLowerBoundRow) {
        validLowerBoundCol--;
        validUpperBoundCol++;
      }

    }
    return board;
  }

}
