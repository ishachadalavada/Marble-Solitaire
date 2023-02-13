import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;


/**
 * Represents a traditional game of English Solitaire,
 * style of a 3x3 board with goal of getting one marble in the center
 * and clearing the rest off of the board.
 */
public final class ModelMock implements MarbleSolitaireModel {
  private final int armThickness; //number of marbles in top row

  private final int sRow;
  private final int sCol;

  // initialize board
  private SlotState[][] board;

  final StringBuilder log; // needs to be able to be accessed from tests

  private final int boardDimension; // board dimensions dependent on arm thickness

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
  public ModelMock(int armThickness, int sRow, int sCol, StringBuilder log)
          throws IllegalArgumentException {

    if (((armThickness % 2) == 0) && (armThickness != 0)) {
      throw new IllegalArgumentException("Invalid arm thickness");
    } else {
      this.armThickness = armThickness;
    }

    this.log = log;
    // already should be an int because checked that armThickness is odd
    int validLowerBound = (armThickness - 1);
    int validUpperBound = validLowerBound + (armThickness - 1);

    this.boardDimension = (3 * armThickness) - 2;
    this.board = new SlotState[this.boardDimension][this.boardDimension];

    for (int row = 0; row < this.boardDimension; row++) {
      for (int col = 0; col < this.boardDimension; col++) {
        if ((row >= validLowerBound) && (row <= validUpperBound)
                || (col >= validLowerBound) && (col <= validUpperBound)) {
          board[row][col] = SlotState.Marble;

        } else {
          board[row][col] = SlotState.Invalid;

        }
      }
      System.out.print("\n");
    }


    if (isInBounds(sRow) &&  isInBounds(sCol) && board[sRow][sCol] != SlotState.Invalid) {
      this.sRow = sRow;
      this.sCol = sCol;
      board[sRow][sCol] = SlotState.Empty;
    } else {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ", "
              + sCol + ")");
    }
  }




  /**
   * creates an english solitaire model and takes in arm thickness.
   * @param armThickness represents length of row with least amount of marbles
   *                    (at point of construction)
   * @throws IllegalArgumentException if the row and/or col give an invalid slot
   */
  public ModelMock(int armThickness, StringBuilder log) throws IllegalArgumentException {
    this(armThickness, ((armThickness * 3) - 3)  / 2, ((armThickness * 3) - 3)  /  2,
            log);
  }

  /**
   * Creates an english solitaire model without any parameters.
   */
  public ModelMock(StringBuilder log) {
    this(3, 3, 3, log);
  }


  /**
   * accepts only an empty row and empty column spot.
   * @param sRow the empty row spot when constructing the board
   * @param sCol the empty column spot when constructing the board
   * @throws IllegalArgumentException if arm thickness is even
   */
  public ModelMock(int sRow, int sCol,StringBuilder log) throws IllegalArgumentException {
    this(3, sRow, sCol, log);
  }


  /**
   * determines the board size based on arm thickness (i.e. length of the longest row/col,
   * i.e. center row).
   *
   * @return the board dimensions of the game based on arm thickness
   */
  public int getBoardSize() {
    return this.boardDimension;
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


  /**
   * counts the number of marbles left on the board.
   * @return the number of marbles left on the board
   */
  public int getScore() {
    int count = 0;
    for (int row = 0; row < this.boardDimension; row++) {
      for (int col = 0; col < this.boardDimension; col++) {
        if (board[row][col] == SlotState.Marble) {
          count = count + 1;
        }
      }
    }
    return count;
  }

  /**
   * Checks that the move is valid under the following conditions, position of origin has a marble,
   * jumps over exactly one space which has a marble, and lands on an empty space.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if SlotState from, middle, and to are invalid
   * @throws IllegalArgumentException if out of bounds
   * @throws IllegalArgumentException if invalid distance between marbles
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    int distRow = fromRow - toRow;
    int distCol = fromCol - toCol;

    log.append(fromRow);
    log.append(fromCol);
    log.append(toRow);
    log.append(toCol);

    if ((isInBounds(fromRow)) && (isInBounds(toRow))
            && (isInBounds(fromCol)) && (isInBounds(toCol))) {
      if ((distRow == -2) && (fromCol == toCol)) {
        if  ((board[fromRow + 1][fromCol] == SlotState.Marble)
                && (board[fromRow][fromCol] == SlotState.Marble)
                && (board[fromRow + 2][fromCol] == SlotState.Empty)) {
          board[fromRow + 1][fromCol] = SlotState.Empty;
          board[fromRow][fromCol] = SlotState.Empty;
          board[fromRow + 2][fromCol] = SlotState.Marble;
        }
        else {
          throw new IllegalArgumentException("SlotState for from, to, "
                  + "or middle marble is not valid");
        }
      }
      else if ((distRow == 2) && (fromCol == toCol)) {
        if ((board[fromRow - 1][fromCol] == SlotState.Marble)
                && (board[fromRow][fromCol] == SlotState.Marble)
                && (board[fromRow - 2][fromCol] == SlotState.Empty)) {
          board[fromRow - 1][fromCol] = SlotState.Empty;
          board[fromRow][fromCol] = SlotState.Empty;
          board[fromRow - 2][fromCol] = SlotState.Marble;
        }
        else {
          throw new IllegalArgumentException("SlotState for from, to, "
                  + "or middle marble is not valid");
        }
      }
      else if ((fromRow == toRow) && distCol == -2) {
        if ((board[fromRow][fromCol + 1] == SlotState.Marble)
                && (board[fromRow][fromCol] == SlotState.Marble)
                && (board[fromRow][fromCol + 2] == SlotState.Empty)) {
          board[fromRow][fromCol + 1] = SlotState.Empty;
          board[fromRow][fromCol] = SlotState.Empty;
          board[fromRow][fromCol + 2] = SlotState.Marble;
        }
        else {
          throw new IllegalArgumentException("SlotState for from, to, "
                  + "or middle marble is not valid");
        }
      }
      else if ((fromRow == toRow) && distCol == 2) {
        if ((board[fromRow][fromCol - 1] == SlotState.Marble)
                && (board[fromRow][fromCol] == SlotState.Marble)
                && (board[fromRow][fromCol - 2] == SlotState.Empty)) {
          board[fromRow][fromCol - 1] = SlotState.Empty;
          board[fromRow][fromCol] = SlotState.Empty;
          board[fromRow][fromCol - 2] = SlotState.Marble;
        }
        else {
          throw new IllegalArgumentException("SlotState for from, to, "
                  + "or middle marble is not valid");
        }
      }
      else {
        throw new IllegalArgumentException("Invalid distance between from and to marble");
      }
    }
    else {
      throw new IllegalArgumentException("Out of Bounds of the board");
    }
  }


  /**
   * checks if a marble is in the bounds of a board.
   * @param num the row or column
   * @returns true if a row or column is in bounds
   */
  protected boolean isInBounds(int num) {
    return ((num >= 0) && (num < boardDimension));
  }


  /**
   * determines if game is over by checking if any marbles can make a move or
   * if there is only one peg in the center position (or position given by player).
   *
   * @return if the game is over
   */
  public boolean isGameOver() {
    int count = 0;
    boolean inCenter = false;
    for (int row = 0; row < this.boardDimension; row++) {
      for (int col = 0; col < this.boardDimension; col++) {
        if (board[row][col] == SlotState.Marble) {
          count = count + 1;
          if (isMovePossible(row, col)) {
            return false;
          }
        }
      }
    }

    return true;
  }

  /**
   * checks if a move is possible at any given marble.
   * @param fromRow position of marble (row)
   * @param fromCol position of marble (col)
   * @returns true if a move is possible
   */

  protected boolean isMovePossible(int fromRow, int fromCol) {
    if (((fromRow + 1) < boardDimension) && ((fromRow + 2) < boardDimension)
            && board[fromRow + 1][fromCol] == SlotState.Marble
            && board[fromRow + 2][fromCol] == SlotState.Empty) {
      return true;
    } else if (((fromRow - 1) >= 0) && ((fromRow - 2) >= 0)
            && board[fromRow - 1][fromCol] == SlotState.Marble
            && board[fromRow - 2][fromCol] == SlotState.Empty) {
      return true;
    } else if ((fromCol - 1 >= 0) && (fromCol - 2 >= 0)
            && (board[fromRow][fromCol - 1] == SlotState.Marble
            && board[fromRow][fromCol - 2] == SlotState.Empty)) {
      return true;
    } else {
      return (((fromCol + 1) < boardDimension) && ((fromCol + 2) < boardDimension)
              && (board[fromRow][fromCol + 1] == SlotState.Marble)
              && (board[fromRow][fromCol + 2] == SlotState.Empty));
    }
  }

}
