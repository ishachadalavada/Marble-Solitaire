package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Abstract class representing a generic format of the building
 * blocks of a marble solitaire game. This includes:
 * - move method
 * - basic model functionality
 * - constructs the model of the game
 */
public abstract class AbstractMarbleSolitaireModel implements MarbleSolitaireModel {
  protected SlotState[][] board;

  protected final int armThickness;
  protected final int row;
  protected final int col;

  /**
   * takes in all of the parameters necessary to create a "standard" model of the game.
   * Moves up, down, left, or right and jumps over a marble with the goal of removing all
   * marbles on game.
   * @param armThickness determines the size of the board
   * @param row determines the location of the empty slot (row)
   * @param col determines the location of the empty slot (col)
   */
  public AbstractMarbleSolitaireModel(int armThickness, int row, int col) {
    if (isValidArmThickness(armThickness)) {
      this.armThickness = armThickness;
    } else {
      throw new IllegalArgumentException("Arm Thickness is Invalid");
    }
    this.board = this.initBoard();

    if (!isValidRowCol(row, col)) {
      throw new IllegalArgumentException("Row and Col is out of bounds");
    }
    else {
      if (board[row][col] == SlotState.Invalid) {
        throw new IllegalArgumentException("Row and Col is invalid");
      } else {
        this.row = row;
        this.col = col;
      }
    }
    board[row][col] = SlotState.Empty;
  }


  /**
   * Creates a full board, as displayed at the start of the game.
   * @return a board, constructed depending on the model, at the beginning of the game
   */
  protected abstract SlotState[][] initBoard();

  /**
   * Depending on the board and constructor parameters.
   * @return the size of the board
   */
  public int getBoardSize() {
    return (3 * this.armThickness) - 2;
  }

  /**
   * used for the constructor to determine if the constructor input for
   * arm thickness is valid depending on requirements of
   * the type of game (overriden by triangle).
   * @param armThickness the size of the board
   * @return if the armThickness is a valid parameter to start the game
   */
  protected boolean isValidArmThickness(int armThickness) {
    return (((armThickness % 2) == 1) && (armThickness >= 0));
  }


  /**
   * used for the constructor to determine if the constructor input is valid
   * for empty slot depending on requirements of the
   * type of game (overriden by triangle).
   * @param row the empty spot on the board (row)
   * @param col the empty spot on the board (col)
   * @return if the row, col are valid parameters to start the game
   */
  protected boolean isValidRowCol(int row, int col) {
    return ((isInBounds(row)) &&  (isInBounds(col)));
  }

  /**
   * used to determine if a row or column is in bounds of the game.
   * @param num the row or column that the method is validity checking
   * @return true if the row or column is in bounds
   */
  protected boolean isInBounds(int num) {
    return (num >= 0) && (num < this.getBoardSize());
  }

  /**
   * Checks that the move is valid under the following conditions, position of origin has a marble,
   * jumps over exactly one space which has a marble, and lands on an empty space.
   * (overriden by triangle).
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
   * determines if game is over by checking if any marbles can make a move or
   * if there is only one peg in the center position (or position given by player).
   *
   * @return if the game is over
   */
  public boolean isGameOver() {
    int count = 0;
    boolean inCenter = false;
    for (int row = 0; row < this.getBoardSize(); row++) {
      for (int col = 0; col < this.getBoardSize(); col++) {
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
    if (((fromRow + 1) < this.getBoardSize()) && ((fromRow + 2) < this.getBoardSize())
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
      return (((fromCol + 1) < this.getBoardSize()) && ((fromCol + 2) < this.getBoardSize())
              && (board[fromRow][fromCol + 1] == SlotState.Marble)
              && (board[fromRow][fromCol + 2] == SlotState.Empty));
    }
  }

  /**
   * returns the state of the slot at the given (row, col) position.
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the slotstate of the position in the board.
   * @throws IllegalArgumentException if the slot is not in the board
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (!isInBounds(row) || !isInBounds(col)) {
      throw new IllegalArgumentException("Out of board");
    }
    return board[row][col];
  }

  /**
   * counts the number of marbles left on the board.
   * @return the number of marbles left on the board
   */
  public int getScore() {
    int count = 0;
    for (int row = 0; row < this.getBoardSize(); row++) {
      for (int col = 0; col < this.getBoardSize(); col++) {
        if (board[row][col] == SlotState.Marble) {
          count = count + 1;
        }
      }
    }
    return count;
  }

}
