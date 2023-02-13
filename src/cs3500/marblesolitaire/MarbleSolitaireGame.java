package cs3500.marblesolitaire;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import java.io.InputStreamReader;


/**
 * Responsible for starting the game.
 */
public class MarbleSolitaireGame {
  /**
   * Starts the game by calling the controller
   * and inputting all of the necessary parameters to start the game.
   */
  public static void main(String[] args) {
    MarbleSolitaireModel model;
    MarbleSolitaireView view;
    // checks if any args taken in, otherwise runs a default english solitaire game
    if (args.length > 0) {
      int armThickness = -1;
      int row = -1;
      int col = -1;
      try {
        for (int i = 0; i < args.length; i++) {
          if (args[i].equals("-size")) {
            if (i + 1 < args.length) {
              armThickness = Integer.parseInt(args[i + 1]);
            } else {
              throw new IllegalStateException("size not have necessary parameters");
            }
          }
          else if (args[i].equals("-hole")) {
            if (i + 2 < args.length) {
              row = Integer.parseInt(args[i + 1]);
              col = Integer.parseInt(args[i + 2]);
            }
            else {
              throw new IllegalStateException("hole does not have necessary parameters");
            }
          }
        }
      } catch (NumberFormatException e) {
        throw new IllegalStateException("Parameters in incorrect format");
      }
      String modelString = args[0];
      if (modelString.equalsIgnoreCase("english")) {
        if (armThickness == -1) {
          armThickness = 3;
        }
        if (row == -1 || col == -1) {
          row = ((3 * armThickness) - 2) / 2;
          col = ((3 * armThickness) - 2) / 2;
        }
        model = new EnglishSolitaireModel(armThickness, row, col);
        view = new MarbleSolitaireTextView(model, System.out);
      }
      else if (modelString.equalsIgnoreCase("european")) {
        if (armThickness == -1) {
          armThickness = 3;
        }
        if (row == -1 || col == -1) {
          row = ((3 * armThickness) - 2) / 2;
          col = ((3 * armThickness) - 2) / 2;
        }
        model = new EuropeanSolitaireModel(armThickness, row, col);
        view = new MarbleSolitaireTextView(model, System.out);
      }
      else if (modelString.equalsIgnoreCase("triangular")) {
        if (armThickness == -1) {
          armThickness = 5;
        }
        if (row == -1 || col == -1) {
          row = 0;
          col = 0;
        }
        model = new TriangleSolitaireModel(armThickness, row, col);
        view = new TriangleSolitaireTextView(model, System.out);
      }
      else {
        throw new IllegalStateException("Model not valid");
      }
    }
    else {
      model = new EnglishSolitaireModel(5);
      view = new MarbleSolitaireTextView(model, System.out);
    }
    try {
      new MarbleSolitaireControllerImpl(model,
              view, new InputStreamReader(System.in)).playGame();
    } catch (IllegalStateException e) {
      e.printStackTrace();
    }
  }

}
