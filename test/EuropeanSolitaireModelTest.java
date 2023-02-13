import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

/**
 * creates the tests for european solitaire model game.
 */
public class EuropeanSolitaireModelTest {

  private MarbleSolitaireModel europeanModelDefaultConstructor;
  private MarbleSolitaireModel europeanModelDiffArmConstructor;
  private MarbleSolitaireModel europeanModelDiffRowColConstructor;
  private MarbleSolitaireModel europeanModelDiffArmRowColConstructor;

  private MarbleSolitaireModel europeanModelConstructorGameOver;
  private MarbleSolitaireModelState.SlotState invalid = MarbleSolitaireModelState.SlotState.Invalid;
  private MarbleSolitaireModelState.SlotState marble = MarbleSolitaireModelState.SlotState.Marble;
  private MarbleSolitaireModelState.SlotState empty = MarbleSolitaireModelState.SlotState.Empty;
  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructor;

  private MarbleSolitaireModelState.SlotState[][] boardDiffArmConstructor;
  private MarbleSolitaireModelState.SlotState[][] boardDiffRowColConstructor;
  private MarbleSolitaireModelState.SlotState[][] boardDiffArmRowColConstructor;
  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMoveRight;
  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMoveLeft;
  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMoveUp;
  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMoveDown;

  @Before
  public void testSetUp() {
    europeanModelDefaultConstructor = new EuropeanSolitaireModel();
    europeanModelDiffArmConstructor = new EuropeanSolitaireModel(5);
    europeanModelDiffArmRowColConstructor = new EuropeanSolitaireModel(5, 2,3);
    europeanModelDiffRowColConstructor = new EuropeanSolitaireModel(1,3);
    europeanModelConstructorGameOver = new EuropeanSolitaireModel(2,3);
    boardDefaultConstructor = new MarbleSolitaireModelState.SlotState[][]
        {{invalid, invalid, marble, marble, marble, invalid, invalid},
        {invalid, marble, marble, marble, marble, marble, invalid},
        {marble, marble, marble, marble, marble, marble, marble},
        {marble, marble, marble, empty, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble},
        {invalid, marble, marble, marble, marble, marble, invalid},
        {invalid, invalid, marble, marble, marble, invalid, invalid}};

    boardDiffRowColConstructor = new MarbleSolitaireModelState.SlotState[][]
        {{invalid, invalid, marble, marble, marble, invalid, invalid},
        {invalid, marble, marble, empty, marble, marble, invalid},
        {marble, marble, marble, marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble},
        {invalid, marble, marble, marble, marble, marble, invalid},
        {invalid, invalid, marble, marble, marble, invalid, invalid}};

    boardDiffArmConstructor = new MarbleSolitaireModelState.SlotState[][]
        {{invalid, invalid, invalid, invalid, marble, marble, marble, marble, marble,
        invalid, invalid, invalid, invalid},
        {invalid, invalid, invalid, marble, marble, marble, marble, marble, marble,
        marble,  invalid, invalid, invalid},
        {invalid, invalid, marble, marble, marble, marble, marble, marble, marble,
        marble, marble, invalid, invalid},
        {invalid, marble, marble, marble,  marble, marble, marble, marble, marble,
        marble, marble, marble, invalid},
        {marble, marble, marble, marble, marble, marble, marble, marble, marble,
        marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble, marble, marble,
        marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, empty, marble, marble,
        marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble, marble, marble,
        marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble, marble, marble,
        marble, marble, marble, marble},
        {invalid, marble, marble, marble,  marble, marble, marble, marble, marble,
        marble, marble, marble, invalid},
        {invalid, invalid, marble, marble, marble, marble, marble, marble, marble,
        marble, marble, invalid, invalid},
        {invalid, invalid, invalid, marble,  marble, marble, marble, marble, marble,
        marble, invalid, invalid, invalid},
        {invalid, invalid, invalid, invalid, marble, marble, marble, marble, marble,
        invalid, invalid, invalid, invalid}};

    boardDiffArmRowColConstructor = new MarbleSolitaireModelState.SlotState[][]
        {{invalid, invalid, invalid, invalid, marble, marble, marble, marble, marble,
        invalid, invalid, invalid, invalid},
        {invalid, invalid, invalid, marble, marble, marble, marble, marble, marble,
        marble,  invalid, invalid, invalid},
        {invalid, invalid, marble, empty, marble, marble, marble, marble, marble,
        marble, marble, invalid, invalid},
        {invalid, marble, marble, marble,  marble, marble, marble, marble, marble,
        marble, marble, marble, invalid},
        {marble, marble, marble, marble, marble, marble, marble, marble, marble,
        marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble, marble, marble,
        marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble, marble, marble,
        marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble, marble, marble,
        marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble, marble, marble,
        marble, marble, marble, marble},
        {invalid, marble, marble, marble,  marble, marble, marble, marble, marble,
        marble, marble, marble, invalid},
        {invalid, invalid, marble, marble, marble, marble, marble, marble, marble,
        marble, marble, invalid, invalid},
        {invalid, invalid, invalid, marble,  marble, marble, marble, marble, marble,
        marble, invalid, invalid, invalid},
        {invalid, invalid, invalid, invalid, marble, marble, marble, marble, marble,
        invalid, invalid, invalid, invalid}};

    boardDefaultConstructorMoveLeft = new MarbleSolitaireModelState.SlotState[][]
        {{invalid, invalid, marble, marble, marble, invalid, invalid},
        {invalid, marble, marble, marble, marble, marble, invalid},
        {marble, marble, marble, marble, marble, marble, marble},
        {marble, marble, marble, marble, empty, empty, marble},
        {marble, marble, marble, marble, marble, marble, marble},
        {invalid, marble, marble, marble, marble, marble, invalid},
        {invalid, invalid, marble, marble, marble, invalid, invalid}};

    boardDefaultConstructorMoveRight = new MarbleSolitaireModelState.SlotState[][]
        {{invalid, invalid, marble, marble, marble, invalid, invalid},
        {invalid, marble, marble, marble, marble, marble, invalid},
        {marble, marble, marble, marble, marble, marble, marble},
        {marble, empty, empty, marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble},
        {invalid, marble, marble, marble, marble, marble, invalid},
        {invalid, invalid, marble, marble, marble, invalid, invalid}};

    boardDefaultConstructorMoveUp = new MarbleSolitaireModelState.SlotState[][]
        {{invalid, invalid, marble, marble, marble, invalid, invalid},
        {invalid, marble, marble, marble, marble, marble, invalid},
        {marble, marble, marble, marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble},
        {marble, marble, marble, empty, marble, marble, marble},
        {invalid, marble, marble, empty, marble, marble, invalid},
        {invalid, invalid, marble, marble, marble, invalid, invalid}};

    boardDefaultConstructorMoveDown = new MarbleSolitaireModelState.SlotState[][]
        {{invalid, invalid, marble, marble, marble, invalid, invalid},
        {invalid, marble, marble, empty, marble, marble, invalid},
        {marble, marble, marble, empty, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble},
        {invalid, marble, marble, marble, marble, marble, invalid},
        {invalid, invalid, marble, marble, marble, invalid, invalid}};
  }

  @Test
  public void testValidConstructors() {
    for (int row = 0; row < europeanModelDefaultConstructor.getBoardSize(); row++) {
      for (int col = 0; col < europeanModelDefaultConstructor.getBoardSize(); col++) {
        assertEquals(boardDefaultConstructor[row][col],
                europeanModelDefaultConstructor.getSlotAt(row, col));
      }
    }

    for (int row = 0; row < europeanModelDiffArmConstructor.getBoardSize(); row++) {
      for (int col = 0; col < europeanModelDiffArmConstructor.getBoardSize(); col++) {
        assertEquals(boardDiffArmConstructor[row][col],
                europeanModelDiffArmConstructor.getSlotAt(row, col));
      }
    }

    for (int row = 0; row < europeanModelDiffRowColConstructor.getBoardSize(); row++) {
      for (int col = 0; col < europeanModelDiffRowColConstructor.getBoardSize(); col++) {
        assertEquals(boardDiffRowColConstructor[row][col],
                europeanModelDiffRowColConstructor.getSlotAt(row, col));
      }
    }

    for (int row = 0; row < europeanModelDiffArmRowColConstructor.getBoardSize(); row++) {
      for (int col = 0; col < europeanModelDiffArmRowColConstructor.getBoardSize(); col++) {
        assertEquals(boardDiffArmRowColConstructor[row][col],
                europeanModelDiffArmRowColConstructor.getSlotAt(row, col));
      }
    }

  }

  @Test
  public void CreateInvalidBoardOneArg() {
    assertThrows(IllegalArgumentException.class,
        () -> new EuropeanSolitaireModel(4));
  }

  @Test
  public void CreateInvalidBoardTwoArgs() {
    assertThrows(IllegalArgumentException.class,
        () -> new EuropeanSolitaireModel(15, 15));
    assertThrows(IllegalArgumentException.class,
        () -> new EuropeanSolitaireModel(0, 0));
  }

  @Test
  public void CreateInvalidBoardThreeArgs() {
    assertThrows(IllegalArgumentException.class,
        () -> new EuropeanSolitaireModel(3, 15, 15));
    assertThrows(IllegalArgumentException.class,
        () -> new EuropeanSolitaireModel(4, 0, 0));
  }

  // most invalid moves are handled by english solitaire model, implicit testing
  @Test
  public void InvalidMove() {
    // invalid to invalid
    assertThrows(IllegalArgumentException.class,
        () -> europeanModelDefaultConstructor.move(0, 3, 2, 3));
    // empty to marble
    assertThrows(IllegalArgumentException.class,
        () -> europeanModelDefaultConstructor.move(3, 3, 5, 3));
    // marble (diff from english) to marble
    assertThrows(IllegalArgumentException.class,
        () -> europeanModelDefaultConstructor.move(1, 1, 1, 3));
    // out of board
    assertThrows(IllegalArgumentException.class,
        () -> europeanModelDefaultConstructor.move(5, 2, 7, 2));
    assertThrows(IllegalArgumentException.class,
        () -> europeanModelDefaultConstructor.move(7, 2, 5, 2));
    // distance is wrong
    assertThrows(IllegalArgumentException.class,
        () -> europeanModelDefaultConstructor.move(4, 2, 7, 2));
    europeanModelDefaultConstructor.move(5,3,3,3);
    assertThrows(IllegalArgumentException.class,
        () -> europeanModelDefaultConstructor.move(3, 3, 5, 3));
  }

  @Test
  public void testGetSlotAt() {
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid,
            europeanModelDefaultConstructor.getSlotAt(0, 0));
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble,
            europeanModelDefaultConstructor.getSlotAt(4, 4));
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty,
            europeanModelDefaultConstructor.getSlotAt(3, 3));
  }

  // most valid moves
  @Test
  public void testValidMoves() {
    MarbleSolitaireModel euroModel = new EuropeanSolitaireModel();
    euroModel.move(3, 5, 3, 3);
    for (int row = 0; row < euroModel.getBoardSize(); row++) {
      for (int col = 0; col < euroModel.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructorMoveLeft[row][col],
                euroModel.getSlotAt(row, col));
      }
    }
    euroModel = new EuropeanSolitaireModel();
    euroModel.move(3, 1, 3, 3);
    for (int row = 0; row < euroModel.getBoardSize(); row++) {
      for (int col = 0; col < euroModel.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructorMoveRight[row][col],
                euroModel.getSlotAt(row, col));
      }
    }
    euroModel = new EuropeanSolitaireModel();
    euroModel.move(5, 3, 3, 3);
    for (int row = 0; row < euroModel.getBoardSize(); row++) {
      for (int col = 0; col < euroModel.getBoardSize(); col++) {
        assertEquals(boardDefaultConstructorMoveUp[row][col],
                euroModel.getSlotAt(row, col));
      }
    }
    euroModel = new EuropeanSolitaireModel();
    euroModel.move(1, 3, 3, 3);
    for (int row = 0; row < euroModel.getBoardSize(); row++) {
      for (int col = 0; col < euroModel.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructorMoveDown[row][col],
                euroModel.getSlotAt(row, col));
      }
    }
  }

  @Test
  public void testgetScoreAt() {

    // got moves from wikipedia
    //testing score change after several moves have been made

    europeanModelDiffRowColConstructor.move(1, 1, 1, 3);
    europeanModelDiffRowColConstructor.move(3, 2, 1, 2);
    europeanModelDiffRowColConstructor.move(3, 4, 3, 2);
    assertEquals(33, europeanModelDiffRowColConstructor.getScore());
    europeanModelDiffRowColConstructor.move(1, 4, 3, 4);
    europeanModelDiffRowColConstructor.move(5, 3, 3, 3);
    europeanModelDiffRowColConstructor.move(4, 1, 4, 3);
    europeanModelDiffRowColConstructor.move(2, 1, 4, 1);
    europeanModelDiffRowColConstructor.move(2, 6, 2, 4);
    europeanModelDiffRowColConstructor.move(4, 4, 4, 2);
    europeanModelDiffRowColConstructor.move(3, 4, 1, 4);
    europeanModelDiffRowColConstructor.move(3, 2, 3, 4);
    europeanModelDiffRowColConstructor.move(5, 1, 3, 1);
    europeanModelDiffRowColConstructor.move(4, 6, 2, 6);
    europeanModelDiffRowColConstructor.move(3, 0, 3, 2);
    europeanModelDiffRowColConstructor.move(4, 5, 2, 5);
    europeanModelDiffRowColConstructor.move(0, 2, 2, 2);
    europeanModelDiffRowColConstructor.move(2, 6, 2, 4);
    europeanModelDiffRowColConstructor.move(6, 4, 4, 4);
    europeanModelDiffRowColConstructor.move(3, 4, 5, 4);
    europeanModelDiffRowColConstructor.move(2, 3, 2, 1);
    europeanModelDiffRowColConstructor.move(2, 0, 2, 2);
    europeanModelDiffRowColConstructor.move(1, 4, 3, 4);
    europeanModelDiffRowColConstructor.move(5, 5, 5, 3);
    europeanModelDiffRowColConstructor.move(6, 3, 4, 3);
    europeanModelDiffRowColConstructor.move(4, 3, 4, 1);
    europeanModelDiffRowColConstructor.move(6, 2, 4, 2);
    europeanModelDiffRowColConstructor.move(3, 2, 5, 2);
    europeanModelDiffRowColConstructor.move(4, 0, 4, 2);
    europeanModelDiffRowColConstructor.move(5, 2, 3, 2);
    europeanModelDiffRowColConstructor.move(3, 2, 1, 2);
    europeanModelDiffRowColConstructor.move(1, 2, 1, 4);
    europeanModelDiffRowColConstructor.move(0, 4, 2, 4);
    europeanModelDiffRowColConstructor.move(3, 4, 1, 4);
    europeanModelDiffRowColConstructor.move(1, 5, 1, 3);
    assertEquals(2, europeanModelDiffRowColConstructor.getScore());
    europeanModelDiffRowColConstructor.move(0, 3, 2, 3);
    assertTrue(europeanModelDiffRowColConstructor.isGameOver());
  }

  @Test
  public void testIsGameOver() {
    // got moves from wikipedia

    // no valid moves left -- losing
    europeanModelConstructorGameOver.move(0, 3, 2, 3);
    europeanModelConstructorGameOver.move(1, 1, 1, 3);
    assertFalse(europeanModelConstructorGameOver.isGameOver());
    europeanModelConstructorGameOver.move(3, 1, 1, 1);
    europeanModelConstructorGameOver.move(5, 1, 3, 1);
    europeanModelConstructorGameOver.move(5, 3, 5, 1);
    europeanModelConstructorGameOver.move(3, 3, 5, 3);
    europeanModelConstructorGameOver.move(3, 5, 3, 3);
    europeanModelConstructorGameOver.move(1, 5, 3, 5);
    europeanModelConstructorGameOver.move(4, 5, 2, 5);
    europeanModelConstructorGameOver.move(3, 2, 3, 4);
    europeanModelConstructorGameOver.move(1, 3, 3, 3);
    europeanModelConstructorGameOver.move(2, 5, 2, 3);
    assertFalse(europeanModelConstructorGameOver.isGameOver());
    europeanModelConstructorGameOver.move(2, 3, 2, 1);
    europeanModelConstructorGameOver.move(2, 1, 4, 1);
    europeanModelConstructorGameOver.move(4, 1, 4, 3);
    europeanModelConstructorGameOver.move(4, 3, 2, 3);
    europeanModelConstructorGameOver.move(5, 4, 5, 2);
    europeanModelConstructorGameOver.move(3, 4, 5, 4);
    europeanModelConstructorGameOver.move(0, 4, 2, 4);
    europeanModelConstructorGameOver.move(2, 4, 2, 2);
    europeanModelConstructorGameOver.move(6, 2, 4, 2);
    europeanModelConstructorGameOver.move(6, 4, 4, 4);
    assertTrue(europeanModelConstructorGameOver.isGameOver());

    //testing score change after several moves have been made

    europeanModelDiffRowColConstructor.move(1, 1, 1, 3);
    europeanModelDiffRowColConstructor.move(3, 2, 1, 2);
    europeanModelDiffRowColConstructor.move(3, 4, 3, 2);
    europeanModelDiffRowColConstructor.move(1, 4, 3, 4);
    europeanModelDiffRowColConstructor.move(5, 3, 3, 3);
    assertFalse(europeanModelDiffRowColConstructor.isGameOver());

    // no valid moves left -- winning
    europeanModelDiffRowColConstructor.move(4, 1, 4, 3);
    europeanModelDiffRowColConstructor.move(2, 1, 4, 1);
    europeanModelDiffRowColConstructor.move(2, 6, 2, 4);
    europeanModelDiffRowColConstructor.move(4, 4, 4, 2);
    europeanModelDiffRowColConstructor.move(3, 4, 1, 4);
    europeanModelDiffRowColConstructor.move(3, 2, 3, 4);
    europeanModelDiffRowColConstructor.move(5, 1, 3, 1);
    europeanModelDiffRowColConstructor.move(4, 6, 2, 6);
    europeanModelDiffRowColConstructor.move(3, 0, 3, 2);
    europeanModelDiffRowColConstructor.move(4, 5, 2, 5);
    europeanModelDiffRowColConstructor.move(0, 2, 2, 2);
    europeanModelDiffRowColConstructor.move(2, 6, 2, 4);
    europeanModelDiffRowColConstructor.move(6, 4, 4, 4);
    europeanModelDiffRowColConstructor.move(3, 4, 5, 4);
    europeanModelDiffRowColConstructor.move(2, 3, 2, 1);
    europeanModelDiffRowColConstructor.move(2, 0, 2, 2);
    europeanModelDiffRowColConstructor.move(1, 4, 3, 4);
    europeanModelDiffRowColConstructor.move(5, 5, 5, 3);
    europeanModelDiffRowColConstructor.move(6, 3, 4, 3);
    europeanModelDiffRowColConstructor.move(4, 3, 4, 1);
    europeanModelDiffRowColConstructor.move(6, 2, 4, 2);
    europeanModelDiffRowColConstructor.move(3, 2, 5, 2);
    europeanModelDiffRowColConstructor.move(4, 0, 4, 2);
    europeanModelDiffRowColConstructor.move(5, 2, 3, 2);
    europeanModelDiffRowColConstructor.move(3, 2, 1, 2);
    europeanModelDiffRowColConstructor.move(1, 2, 1, 4);
    europeanModelDiffRowColConstructor.move(0, 4, 2, 4);
    europeanModelDiffRowColConstructor.move(3, 4, 1, 4);
    europeanModelDiffRowColConstructor.move(1, 5, 1, 3);
    europeanModelDiffRowColConstructor.move(0, 3, 2, 3);
    assertTrue(europeanModelDiffRowColConstructor.isGameOver());
  }

}