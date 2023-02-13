package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents the view of a marble solitaire game by displaying the board,
 * rendering any messages for the game and representing the outputs of the model
 * in a user-readable format.
 */
public class MarbleSolitaireTextView extends AbstractMarbleSolitaireTextView {

  /**
   * Represents a marble solitaire game's display that only takes in a model.
   * @param model a traditional game of english solitaire
   * @throws IllegalArgumentException if the model inputted is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model) throws IllegalArgumentException {
    super(model, System.out);
  }

  /**
   * Represents a marble solitaire game's display that takes in a model and appendable.
   * @param model a traditional game of english solitaire
   * @param out the output stream for the display
   * @throws IllegalArgumentException if the model or the appendable/output stream is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable out)
          throws IllegalArgumentException {
    super(model, out);

  }


}
