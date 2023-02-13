package cs3500.marblesolitaire.model.hw02;


import cs3500.marblesolitaire.model.hw04.AbstractMarbleSolitaireModel;

/**
 * Represents a traditional game of English Solitaire,
 * style of a 3x3 board with goal of getting one marble in the center
 * and clearing the rest off of the board.
 */
public final class EnglishSolitaireModel extends AbstractMarbleSolitaireModel {

  /**
   * Constructs an English Solitaire game with armThickness, sRow, and sCol.
   *
   * @param armThickness represents length of row with least
   *                     amount of marbles (at point of construction)
   * @param sRow         represents the row at which the empty slot is (at point of construction)
   * @param sCol         represents the row at which the empty slot is (at point of construction)
   * @throws IllegalArgumentException if the arm thickness if not even
   * @throws IllegalArgumentException if the row and/or col give an invalid slot
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    super(armThickness, sRow, sCol);

  }


  /**
   * creates an english solitaire model and takes in arm thickness.
   * @param armThickness represents length of row with least amount of marbles
   *                    (at point of construction)
   * @throws IllegalArgumentException if the row and/or col give an invalid slot
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    super(armThickness, ((armThickness * 3) - 3)  / 2, ((armThickness * 3) - 3)  /  2);
  }

  /**
   * Creates an english solitaire model without any parameters.
   */
  public EnglishSolitaireModel() {
    super(3, 3, 3);
  }


  /**
   * accepts only an empty row and empty column spot.
   * @param sRow the empty row spot when constructing the board
   * @param sCol the empty column spot when constructing the board
   * @throws IllegalArgumentException if arm thickness is even
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(3, sRow, sCol);
  }



  @Override
  protected SlotState[][] initBoard() {
    // already should be an int because checked that armThickness is odd
    int validLowerBound = (armThickness - 1);
    int validUpperBound = validLowerBound + (armThickness - 1);

    int boardDimension = (3 * armThickness) - 2;
    this.board = new SlotState[boardDimension][boardDimension];

    for (int row = 0; row < boardDimension; row++) {
      for (int col = 0; col < boardDimension; col++) {
        if ((row >= validLowerBound) && (row <= validUpperBound)
                || (col >= validLowerBound) && (col <= validUpperBound)) {
          board[row][col] = SlotState.Marble;

        } else {
          board[row][col] = SlotState.Invalid;

        }
      }
      System.out.print("\n");
    }

    return board;
  }

  /**
   * determines the board size based on arm thickness (i.e. length of the longest row/col,
   * i.e. center row).
   *
   * @return the board dimensions of the game based on arm thickness
   */
  public int getBoardSize() {
    return (3 * armThickness) - 2;
  }

  /**
   * gets the SlotState of a position at a given row or col if it is on the board,
   * else throws exception.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the SlotState of the position on the board
   * @throws IllegalArgumentException if it is off the board
   */
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (!isInBounds(row) || !isInBounds(col)) {
      throw new IllegalArgumentException("Out of board");
    } else {
      return board[row][col];
    }
  }
}
