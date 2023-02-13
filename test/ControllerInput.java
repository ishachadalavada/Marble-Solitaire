import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * Tests if scanner and in stream takes in what is actually being
 * inputted by the user. There is also a model mock, but this is supplied to
 * test if the controller receives the correct inputs as well.
 */
public class ControllerInput implements MarbleSolitaireController {
  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private final Readable in;

  final StringBuilder log; // needs to be not private for mocks testing

  /**
   * Tests if scanner is inputting correctly into controller.
   * @param model a game of marble solitaire
   * @param view the display for the game
   * @param in the input stream to take in user input
   * @param log records the input for testing
   */
  public ControllerInput(MarbleSolitaireModel model, MarbleSolitaireTextView view,
                         Readable in, StringBuilder log) {
    this.model = model;
    this.view = view;
    this.in = in;
    this.log = log;
  }

  /**
   * plays the game as a typical controller would and records the controller inputs.
   * @throws IllegalStateException if an IO Exception is caught
   * @throws IllegalStateException if no more input
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
    boolean newDisplay = true;
    while (!model.isGameOver()) {
      if (newDisplay) {
        //displays current state of the board by interacting with view
        try {
          view.renderBoard();
          currentScore = "Score: " + model.getScore();
          view.renderMessage(currentScore + '\n');
        } catch (IOException e) {
          throw new IllegalStateException("Can't read input or write output");
        }
      }

      // takes in the next four inputs for move, accounting for incorrect inputs
      try {
        int[] inputs = {0, 0, 0, 0};
        int count = 0;

        while (count < 4) {
          try {
            num1 = scan.next();
            this.log.append(num1);
          } catch (NoSuchElementException e) {
            throw new IllegalStateException("No more inputs");
          }
          if ((num1.charAt(0) == 'Q') || (num1.charAt(0) == 'q')) {
            quit = true;
            break;
          }
          int input = -1;
          try {
            input = Integer.parseInt(num1);
            if (input >= 1) {
              inputs[count] = input - 1;
              count++;
            }
            else {
              try {
                view.renderMessage("Can't input negative message. Please enter again.\n");
              } catch (IOException e) {
                throw new IllegalStateException("Can't read input or write output");
              }
            }
          } catch (NumberFormatException ne) {
            try {
              view.renderMessage("Can't input non-int message. Please enter again.\n");
            } catch (IOException e) {
              throw new IllegalStateException("Can't read input or write output");
            }

          }
        }
        if (quit) {
          break;
        }

        fromRow = inputs[0];
        fromCol = inputs[1];
        toRow = inputs[2];
        toCol = inputs[3];
        // emptied for next move by re-instantiated
        model.move(fromRow, fromCol, toRow, toCol);
        newDisplay = true;
      } catch (IllegalArgumentException e) {
        newDisplay = false;
        try {
          view.renderMessage("Invalid Move. Play Again. " + e.getMessage() + '\n');
        } catch (IOException ie) {
          throw new IllegalStateException("Can't read input or write output");
        }
      }
    }

    if (quit) {
      try {
        view.renderMessage("Game quit!\n");
        view.renderMessage("State of game when quit:\n");
        view.renderBoard();
        currentScore = "Score: " + model.getScore();
        view.renderMessage(currentScore + '\n');
      } catch (IOException e) {
        throw new IllegalStateException("Can't read input or write output");
      }
    }
    else if (model.isGameOver()) {
      try {
        view.renderMessage("Game over!\n");
        view.renderBoard();
        currentScore = "Score: " + model.getScore();
        view.renderMessage(currentScore + '\n');
      } catch (IOException e) {
        throw new IllegalStateException("Can't read input or write output");
      }
    }
  }

}