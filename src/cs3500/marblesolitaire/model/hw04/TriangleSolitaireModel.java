package cs3500.marblesolitaire.model.hw04;

/**
 * Represents a game of triangle solitaire model, a game with an triangular board
 * and operates under the typical format of a marble solitaire game (the version
 * in abstract solitaire model) except moves left, right, diag right up, diag left up,
 * diag right bottom, and diag left bottom.
 */
public class TriangleSolitaireModel extends AbstractMarbleSolitaireModel {

  /**
   * Constructs an Triangle Solitaire game with armThickness, sRow, and sCol.
   *
   * @param armThickness represents length of row with least
   *                     amount of marbles (at point of construction)
   * @param row         represents the row at which the empty slot is (at point of construction)
   * @param col         represents the row at which the empty slot is (at point of construction)
   * @throws IllegalArgumentException if the arm thickness if not even
   * @throws IllegalArgumentException if the row and/or col give an invalid slot
   */
  public TriangleSolitaireModel(int armThickness, int row, int col)
          throws IllegalArgumentException {
    super(armThickness, row, col);


  }

  /**
   * creates an triangle solitaire model and takes in arm thickness.
   * @param armThickness represents length of row with least amount of marbles
   *                    (at point of construction)
   * @throws IllegalArgumentException if the row and/or col give an invalid slot
   */
  public TriangleSolitaireModel(int armThickness) {
    super(armThickness, 0, 0);
  }

  /**
   * accepts only an empty row and empty column spot.
   * @param row the empty row spot when constructing the board
   * @param col the empty column spot when constructing the board
   * @throws IllegalArgumentException if arm thickness is even
   */
  public TriangleSolitaireModel(int row, int col) {
    super(5, row, col);
  }

  /**
   * default constructor for triangle solitaire game (board size defaults to 3,
   * row = 3, col = 3).
   * @throws IllegalArgumentException if arm thickness is even
   */
  public TriangleSolitaireModel() {
    super(5, 0, 0);
  }

  /**
   * determines if the value given is within the array to avoid Illegal argument exceptions.
   * @param num the row or column that the method is validity checking
   * @return true if in bounds of the board
   */
  protected boolean isInBounds(int num) {
    return (num >= 0) && (num < this.getBoardSize());
  }

  /**
   * constructs a triangle solitaire board in its state at the beginning of the game.
   * @return board at the beginning of the game
   */
  @Override
  protected SlotState[][] initBoard() {
    SlotState[][] board = new SlotState[this.getBoardSize()][this.getBoardSize()];

    for (int r = 0; r < this.getBoardSize(); r++) {
      for (int c = 0; c < this.getBoardSize(); c++) {
        board[r][c] = SlotState.Invalid;
      }
    }
    for (int r = 0; r < this.getBoardSize(); r++) {
      for (int c = 0; c <= r; c++) {
        board[r][c] = SlotState.Marble;
      }
    }
    return board;
  }

  /**
   * checks validity of use-inputted arm thickness.
   * @param armThickness the size of the board
   * @return true if the arm thickness is valid for board construction
   */
  @Override
  protected boolean isValidArmThickness(int armThickness) {
    return armThickness > 0;

  }


  /**
   * Overrides move in the abstract. Checks that the move is valid under the following
   * conditions, position of origin has a marble,njumps over exactly one space which has a marble,
   * and lands on an empty space.
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
   * @throws IllegalArgumentException if invalid distance between marble
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    int distRow = fromRow - toRow;
    int distCol = fromCol - toCol;
    if ((isInBounds(fromRow)) && (isInBounds(toRow))
            && (isInBounds(fromCol)) && (isInBounds(toCol))) {
      // diagonal down right
      if ((distRow == -2) && (distCol == -2)) {
        if  ((board[fromRow + 1][fromCol + 1] == SlotState.Marble)
                && (board[fromRow][fromCol] == SlotState.Marble)
                && (board[fromRow + 2][fromCol + 2] == SlotState.Empty)) {
          board[fromRow + 1][fromCol + 1] = SlotState.Empty;
          board[fromRow][fromCol] = SlotState.Empty;
          board[fromRow + 2][fromCol + 2] = SlotState.Marble;
        }
        else {
          throw new IllegalArgumentException("SlotState for from, to, "
                  + "or middle marble is not valid");
        }
      }
      // diagonal down left
      else if ((distRow == -2) && (distCol == 0)) {
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
      // diagonal up right
      else if ((distRow == 2) && (distCol == 0)) {
        if  ((board[fromRow - 1][fromCol] == SlotState.Marble)
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
      //diagonal up left
      else if ((distRow == 2) && (distCol == 2)) {
        if ((board[fromRow - 1][fromCol - 1] == SlotState.Marble)
                && (board[fromRow][fromCol] == SlotState.Marble)
                && (board[fromRow - 2][fromCol - 2] == SlotState.Empty)) {
          board[fromRow - 1][fromCol - 1] = SlotState.Empty;
          board[fromRow][fromCol] = SlotState.Empty;
          board[fromRow - 2][fromCol - 2] = SlotState.Marble;
        }
        else {
          throw new IllegalArgumentException("SlotState for from, to, "
                  + "or middle marble is not valid");
        }
      }
      // moves right
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
      // moves left
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
   * Checks if a move is possible for a specific model to help is game over.
   * @param fromRow position of marble (row)
   * @param fromCol position of marble (col)
   * @return true if any move can be made from a marble.
   */
  @Override
  protected boolean isMovePossible(int fromRow, int fromCol) {
    // diagonal down right
    if (((fromRow + 1) < this.getBoardSize()) && ((fromRow + 2) < this.getBoardSize())
            && ((fromCol + 1) < this.getBoardSize()) && ((fromCol + 2) < this.getBoardSize())
            && board[fromRow + 1][fromCol + 1] == SlotState.Marble
            && board[fromRow + 2][fromCol + 2] == SlotState.Empty) {
      return true;
      // diagonal up left
    } else if (((fromRow - 1) >= 0) && ((fromRow - 2) >= 0)
            && board[fromRow - 1][fromCol] == SlotState.Marble
            && board[fromRow - 2][fromCol] == SlotState.Empty) {
      return true;
      // diagonal down right
    } else if ((fromRow + 1 < this.getBoardSize()) && (fromRow + 2 < this.getBoardSize())
            && (board[fromRow + 1][fromCol] == SlotState.Marble
            && board[fromRow + 1][fromCol] == SlotState.Empty)) {
      return true;
      // diagonal down left
    } else if (((fromRow - 1) >= 0) && ((fromRow - 2) >= 0)
            && ((fromCol - 1) >= 0) && ((fromCol - 2) >= 0)
            && board[fromRow - 1][fromCol - 1] == SlotState.Marble
            && board[fromRow - 2][fromCol - 2] == SlotState.Empty) {
      return true;
      //left
    } else if ((fromCol - 1 >= 0) && (fromCol - 2 >= 0)
            && (board[fromRow][fromCol - 1] == SlotState.Marble
            && board[fromRow][fromCol - 2] == SlotState.Empty)) {
      return true;
    } else {
      //right
      return (((fromCol + 1) < this.getBoardSize()) && ((fromCol + 2) < this.getBoardSize())
              && (board[fromRow][fromCol + 1] == SlotState.Marble)
              && (board[fromRow][fromCol + 2] == SlotState.Empty));
    }
  }

  /**
   * gets the size of the board.
   * @return the dimensions of the board
   */
  @Override
  public int getBoardSize() {
    return this.armThickness;
  }



}
