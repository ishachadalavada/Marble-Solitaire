package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import java.util.Scanner;
import java.io.IOException;

/**
 * Represents the controller of a marble solitaire game by interacting with the model and view
 * interfaces and user input in order to make an interactive game.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private final Readable in;

  /**
   * Represents the controller and takes in the model, display, and
   * user input that it facilitates the interaction of.
   * @param model the functionality of a marble solitaire game
   * @param view the display interface for the game
   * @param in the input stream to gather moves from the user
   * @throws IllegalArgumentException if model, view, or readable is null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
         MarbleSolitaireView view, Readable in) throws IllegalArgumentException {
    if (model == null || view == null || in == null) {
      throw new IllegalArgumentException("Null Argument");
    }
    this.model = model;
    this.view = view;
    this.in = in;
  }

  /**
   * Interacts with user, model, and view to make an interactive game, by collecting
   * move inputs and editing the model to create displays at every state of the
   * game (beginning, middle across all move, and in the end game scenario).
   *
   * @throws IllegalStateException if it cannot read an input or write an output
   *     and if it catches any input/output exceptions from display interface(view)
   * @throws IllegalStateException if run out of inputs
   */
  public void playGame() throws IllegalStateException {
    boolean quit = false;

    String currentScore;
    String num1;

    int fromCol;
    int fromRow;
    int toRow;
    int toCol;

    Scanner scan = new Scanner(this.in);
    try {
      this.displayBoard(model);
      int[] inputs = new int[4];
      int count = 0;

      while (!model.isGameOver()) {
        // takes in the next four inputs for move, accounting for incorrect inputs
        if (!scan.hasNext()) {
          throw new IllegalStateException("No other inputs");
        }
        num1 = scan.next();

        if ((num1.charAt(0) == 'Q') || (num1.charAt(0) == 'q')) {
          gameEnds(model);
          break;
        }
        int input = -1;
        try {
          input = Integer.parseInt(num1);
          if ((input >= 1) && (count <= 3)) {
            inputs[(count)] = input - 1;
            count++;
          }
          else {
            view.renderMessage("Can't input negative message. Please enter again.\n");
          }
        } catch (NumberFormatException ne) {
          view.renderMessage("Can't input non-int message. Please enter again.\n");
        }
        try {
          if ((count % 4 == 0) && (count >= 1)) {
            fromRow = inputs[0];
            fromCol = inputs[1];
            toRow = inputs[2];
            toCol = inputs[3];
            count = 0;
            // emptied for next move by re-instantiated
            model.move(fromRow, fromCol, toRow, toCol);
            inputs = new int[4];
            this.displayBoard(model);
          }
        } catch (IllegalArgumentException e) {
          view.renderMessage("Invalid Move. Play Again. " + e.getMessage() + '\n');
        }
      }
      if (model.isGameOver()) {
        gameEnds(model);
      }
    } catch (IOException e) {
      throw new IllegalStateException("Can't read input or write output");
    }
  }

  /**
   * interacts with the view and displays the current game state.
   * @param model inputs the model at the current of the game
   * @throws IOException handles the IO Exception if the view outputs one
   */
  private void displayBoard(MarbleSolitaireModel model) throws IOException {
    try {
      view.renderBoard();
      String currentScore = "Score: " + model.getScore();
      view.renderMessage(currentScore + '\n');
    } catch (IOException e) {
      throw new IllegalStateException("Can't read input or write output");
    }
  }

  private void gameEnds(MarbleSolitaireModel model) throws IOException {
    if (model.isGameOver()) {
      view.renderMessage("Game over!\n");
    }
    else {
      view.renderMessage("Game quit!\n");
      view.renderMessage("State of game when quit:\n");
    }
    view.renderBoard();
    String currentScore = "Score: " + model.getScore();
    view.renderMessage(currentScore + '\n');
  }
}


