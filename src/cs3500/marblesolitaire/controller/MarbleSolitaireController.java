package cs3500.marblesolitaire.controller;

/**
 * Represents a controller (class that facilitates interaction between model, view,
 * errors from classes/other commands, and user input), for a marble solitaire game.
 */
public interface MarbleSolitaireController {

  /**
   * Responsible for playing the game i.e. creating an interactive display
   * that is edited through a game play session by user input in accordance with the rules.
   * @throws IllegalStateException if controller is unable to read input/transmit output
   */
  void playGame() throws IllegalStateException;
}
