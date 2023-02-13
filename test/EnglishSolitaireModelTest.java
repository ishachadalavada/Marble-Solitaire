
import org.junit.Test;
import org.junit.Before;


import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

/**
 * Covers the various test cases for english solitaire model.
 * - create board, exception tests for each of the parameters and each of the constructors,
 *   various invalid move scenarios, etc.
 */
public class EnglishSolitaireModelTest {

  private EnglishSolitaireModel game2 = new EnglishSolitaireModel(5, 5, 7);
  private EnglishSolitaireModel game1;
  private EnglishSolitaireModel game3;

  private MarbleSolitaireModelState.SlotState[][] defaultBoardex1;

  private MarbleSolitaireModelState.SlotState[][] moveBoardex1;
  private MarbleSolitaireModelState.SlotState[][] moveBoardex2;
  private MarbleSolitaireModelState.SlotState[][] moveBoardex3;
  private MarbleSolitaireModelState.SlotState[][] moveBoardex4;

  private MarbleSolitaireModelState.SlotState[][] defaultBoardex2;

  @Before
  public void testSetUp() {

    MarbleSolitaireModelState.SlotState invalid;
    MarbleSolitaireModelState.SlotState marble;
    MarbleSolitaireModelState.SlotState empty;
    game1 = new EnglishSolitaireModel();
    game3 = new EnglishSolitaireModel(5, 5, 7);
    invalid = MarbleSolitaireModelState.SlotState.Invalid;
    marble = MarbleSolitaireModelState.SlotState.Marble;
    empty = MarbleSolitaireModelState.SlotState.Empty;

    defaultBoardex1 = new MarbleSolitaireModelState.SlotState[][]
        {{invalid, invalid, marble, marble, marble, invalid, invalid},
        {invalid, invalid, marble, marble, marble, invalid, invalid},
        {marble, marble, marble, marble, marble, marble, marble},
        {marble, marble, marble, empty, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble},
        {invalid, invalid, marble, marble, marble, invalid, invalid},
        {invalid, invalid, marble, marble, marble, invalid, invalid}};

    moveBoardex1 = new MarbleSolitaireModelState.SlotState[][]
        {{invalid, invalid, marble, marble, marble, invalid, invalid},
        {invalid, invalid, marble, marble, marble, invalid, invalid},
        {marble, marble, marble, marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble},
        {marble, marble, marble, empty, marble, marble, marble},
        {invalid, invalid, marble, empty, marble, invalid, invalid},
        {invalid, invalid, marble, marble, marble, invalid, invalid}};

    moveBoardex2 = new MarbleSolitaireModelState.SlotState[][]
        {{invalid, invalid, marble, marble, marble, invalid, invalid},
        {invalid, invalid, marble, marble, marble, invalid, invalid},
        {marble, marble, marble, marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble},
        {marble, empty, empty, marble, marble, marble, marble},
        {invalid, invalid, marble, empty, marble, invalid, invalid},
        {invalid, invalid, marble, marble, marble, invalid, invalid}};

    moveBoardex3 = new MarbleSolitaireModelState.SlotState[][]
        {{invalid, invalid, marble, marble, marble, invalid, invalid},
        {invalid, invalid, marble, marble, marble, invalid, invalid},
        {marble, marble, marble, marble, marble, marble, marble},
        {marble, marble, marble, empty, marble, marble, marble},
        {marble, empty, empty, empty, marble, marble, marble},
        {invalid, invalid, marble, marble, marble, invalid, invalid},
        {invalid, invalid, marble, marble, marble, invalid, invalid}};

    moveBoardex4 = new MarbleSolitaireModelState.SlotState[][]
        {{invalid, invalid, marble, marble, marble, invalid, invalid},
        {invalid, invalid, marble, marble, marble, invalid, invalid},
        {marble, marble, marble, marble, marble, marble, marble},
        {marble, marble, marble, empty, marble, marble, marble},
        {marble, empty, empty, marble, empty, empty, marble},
        {invalid, invalid, marble, marble, marble, invalid, invalid},
        {invalid, invalid, marble, marble, marble, invalid, invalid}};

    defaultBoardex2 = new MarbleSolitaireModelState.SlotState[][]
        {{invalid, invalid, invalid, invalid, marble, marble, marble, marble, marble,
        invalid, invalid, invalid, invalid},
        {invalid, invalid, invalid, invalid, marble, marble, marble, marble, marble,
        invalid,  invalid, invalid, invalid},
        {invalid, invalid, invalid, invalid, marble, marble, marble, marble, marble,
        invalid, invalid, invalid, invalid},
        {invalid, invalid, invalid, invalid,  marble, marble, marble, marble, marble,
        invalid, invalid, invalid, invalid},
        {marble, marble, marble, marble, marble, marble, marble, marble, marble,
        marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble, marble, marble,
        marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble, empty, marble,
        marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble, marble, marble,
        marble, marble, marble, marble},
        {marble, marble, marble, marble, marble, marble, marble, marble, marble,
        marble, marble, marble, marble},
        {invalid, invalid, invalid, invalid,  marble, marble, marble, marble, marble,
        invalid, invalid, invalid, invalid},
        {invalid, invalid, invalid, invalid, marble, marble, marble, marble, marble,
        invalid, invalid, invalid, invalid},
        {invalid, invalid, invalid, invalid,  marble, marble, marble, marble, marble,
        invalid, invalid, invalid, invalid},
        {invalid, invalid, invalid, invalid, marble, marble, marble, marble, marble,
        invalid, invalid, invalid, invalid}};

  }

  @Test
  public void CreateBoard() {
    for (int row = 0; row < game1.getBoardSize(); row++) {
      for (int col = 0; col < game1.getBoardSize(); col++) {
        assertEquals(defaultBoardex1[row][col], game1.getSlotAt(row, col));
      }
    }

    for (int row = 0; row < game1.getBoardSize(); row++) {
      for (int col = 0; col < game1.getBoardSize(); col++) {
        assertEquals(defaultBoardex2[row][col], game3.getSlotAt(row, col));
      }
    }
  }

  @Test
  public void CreateInvalidBoardOneArg() {
    assertThrows(IllegalArgumentException.class,
        () -> new EnglishSolitaireModel(4));
  }

  @Test
  public void CreateInvalidBoardTwoArgs() {
    assertThrows(IllegalArgumentException.class,
        () -> new EnglishSolitaireModel(15, 15));
    assertThrows(IllegalArgumentException.class,
        () -> new EnglishSolitaireModel(0, 0));
  }

  @Test
  public void CreateInvalidBoardThreeArgs() {
    assertThrows(IllegalArgumentException.class,
        () -> new EnglishSolitaireModel(3, 15, 15));
    assertThrows(IllegalArgumentException.class,
        () -> new EnglishSolitaireModel(4, 0, 0));
  }

  @Test
  public void InvalidMove() {
    // invalid to invalid
    assertThrows(IllegalArgumentException.class,
        () -> game1.move(0, 3, 2, 3));
    // empty to marble
    assertThrows(IllegalArgumentException.class,
        () -> game1.move(3, 3, 5, 3));
    // marble to marble
    assertThrows(IllegalArgumentException.class,
        () -> game1.move(2, 3, 4, 3));
    // out of board
    assertThrows(IllegalArgumentException.class,
        () -> game1.move(5, 2, 7, 2));
    assertThrows(IllegalArgumentException.class,
        () -> game1.move(7, 2, 5, 2));
    // distance is wrong
    assertThrows(IllegalArgumentException.class,
        () -> game1.move(4, 2, 7, 2));
    game1.move(5,3,3,3);
    assertThrows(IllegalArgumentException.class,
        () -> game1.move(3, 3, 5, 3));
  }

  @Test
  public void InvalidGetSlotAt() {
    assertThrows(IllegalArgumentException.class,
        () -> game1.getSlotAt(10, 10));
    assertThrows(IllegalArgumentException.class,
        () -> game1.getSlotAt(-1, -1));
  }

  @Test
  public void testMove() {
    // moves up
    game1.move(5, 3, 3, 3);
    for (int row = 0; row < game1.getBoardSize(); row++) {
      for (int col = 0; col < game1.getBoardSize(); col++) {
        assertEquals(moveBoardex1[row][col], game1.getSlotAt(row,col));
      }
    }
    // moves down
    game1.move(4, 1, 4, 3);
    for (int row = 0; row < game1.getBoardSize(); row++) {
      for (int col = 0; col < game1.getBoardSize(); col++) {
        assertEquals(moveBoardex2[row][col], game1.getSlotAt(row,col));
      }
    }
    game1.move(3,3,5,3);

    // moves left
    for (int row = 0; row < game1.getBoardSize(); row++) {
      for (int col = 0; col < game1.getBoardSize(); col++) {
        assertEquals(moveBoardex3[row][col], game1.getSlotAt(row,col));
      }
    }
    game1.move(4, 5, 4, 3);

    // moves right
    for (int row = 0; row < game1.getBoardSize(); row++) {
      for (int col = 0; col < game1.getBoardSize(); col++) {
        assertEquals(moveBoardex4[row][col], game1.getSlotAt(row,col));
      }
    }
  }

  @Test
  public void testIsGameOver() {

    game1.move(5,3,3,3);
    game1.move(4,1,4,3);
    game1.move(6,2,4,2);
    game1.move(3,2,5,2);
    game1.move(6,4,6,2);
    game1.move(6,2,4,2);

    assertFalse(game1.isGameOver());

    game1.move(1,2,3,2);
    game1.move(2,0,2,2);
    game1.move(2,3,2,1);
    game1.move(4,0,2,0);
    game1.move(2,0,2,2);
    game1.move(2,5, 2,3);
    game1.move(0,4,2,4);
    game1.move(3,4,1,4);
    game1.move(0,2,0,4);
    game1.move(0,4,2,4);
    game1.move(5,4,3,4);
    game1.move(4,6,4,4);
    game1.move(4,3,4,5);
    game1.move(2,6,4,6);
    game1.move(4,6,4,4);
    game1.move(2,3,2,5);
    game1.move(2,5,4,5);
    game1.move(4,5,4,3);
    game1.move(4,3,4,1);
    game1.move(4,1, 2, 1);
    game1.move(2,1,2,3);
    game1.move(3,3,3,5);
    game1.move(1,3,3,3);
    game1.move(3,2, 3, 4);
    game1.move(3,5,3,3);
    assertEquals(game1.getScore(), 1);
    assertTrue(game1.isGameOver());
  }

  @Test
  public void testGetBoardSize() {
    assertEquals(game1.getBoardSize(), 7);
  }

  @Test
  public void testGetSlotAtc() {
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid,
            game1.getSlotAt(0, 0));
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble,
            game1.getSlotAt(2, 2));
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty,
            game1.getSlotAt(3, 3));
  }

  @Test
  public void testGetScore() {
    EnglishSolitaireModel model = new EnglishSolitaireModel(5);
    System.out.print(model.getScore());
    assertEquals(32, game1.getScore());
    game1.move(5,3,3,3);
    game1.move(4,1,4,3);
    game1.move(6,2,4,2);
    assertEquals(29, game1.getScore());
  }


}