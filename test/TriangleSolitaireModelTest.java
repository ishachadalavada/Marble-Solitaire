import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

/**
 * tests a triangle marble solitaire game for all model methods.
 */
public class TriangleSolitaireModelTest {

  private MarbleSolitaireModel triangleModelDefaultConstructor;
  private MarbleSolitaireModel triangleModelDiffArmConstructor;
  private MarbleSolitaireModel triangleModelDiffRowColConstructor;
  private MarbleSolitaireModel triangleModelDiffArmRowColConstructor;

  private MarbleSolitaireModelState.SlotState invalid = MarbleSolitaireModelState.SlotState.Invalid;
  private MarbleSolitaireModelState.SlotState marble = MarbleSolitaireModelState.SlotState.Marble;
  private MarbleSolitaireModelState.SlotState empty = MarbleSolitaireModelState.SlotState.Empty;
  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructor;
  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMove1;

  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMove2;
  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMove3;
  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMove4;
  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMove5;

  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMove6;

  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMove7;
  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMove8;
  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMove9;
  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMove10;
  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMove11;

  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMove12;
  private MarbleSolitaireModelState.SlotState[][] boardDefaultConstructorMove13;

  private MarbleSolitaireModelState.SlotState[][] boardDiffArmConstructor;
  private MarbleSolitaireModelState.SlotState[][] boardDiffRowColConstructor;
  private MarbleSolitaireModelState.SlotState[][] boardDiffArmRowColConstructor;

  @Before
  public void testSetUp() {
    triangleModelDefaultConstructor = new TriangleSolitaireModel();
    triangleModelDiffArmConstructor = new TriangleSolitaireModel(7);
    triangleModelDiffArmRowColConstructor = new TriangleSolitaireModel(7, 5,5);
    triangleModelDiffRowColConstructor = new TriangleSolitaireModel(2,2);
    boardDefaultConstructor = new MarbleSolitaireModelState.SlotState[][]
        {{empty, invalid, invalid, invalid, invalid},
        {marble, marble, invalid, invalid, invalid},
        {marble, marble, marble, invalid, invalid},
        {marble, marble, marble, marble, invalid},
        {marble, marble, marble, marble, marble}};

    boardDiffRowColConstructor = new MarbleSolitaireModelState.SlotState[][]
        {{marble, invalid, invalid, invalid, invalid},
        {marble, marble, invalid, invalid, invalid},
        {marble, marble, empty, invalid, invalid},
        {marble, marble, marble, marble, invalid},
        {marble, marble, marble, marble, marble}};

    boardDiffArmConstructor = new MarbleSolitaireModelState.SlotState[][]
        {{empty, invalid, invalid, invalid, invalid, invalid, invalid},
        {marble, marble, invalid, invalid, invalid, invalid, invalid},
        {marble, marble, marble, invalid, invalid, invalid, invalid},
        {marble, marble, marble, marble, invalid, invalid, invalid},
        {marble, marble, marble, marble, marble, invalid, invalid},
        {marble, marble, marble, marble, marble, marble, invalid},
        {marble, marble, marble, marble, marble, marble, marble}};

    boardDiffArmRowColConstructor = new MarbleSolitaireModelState.SlotState[][]
        {{marble, invalid, invalid, invalid, invalid, invalid, invalid},
        {marble, marble, invalid, invalid, invalid, invalid, invalid},
        {marble, marble, marble, invalid, invalid, invalid, invalid},
        {marble, marble, marble, marble, invalid, invalid, invalid},
        {marble, marble, marble, marble, marble, invalid, invalid},
        {marble, marble, marble, marble, marble, empty, invalid},
        {marble, marble, marble, marble, marble, marble, marble}};

    boardDefaultConstructorMove1 = new MarbleSolitaireModelState.SlotState[][]
        {{marble, invalid, invalid, invalid, invalid},
        {empty, marble, invalid, invalid, invalid},
        {empty, marble, marble, invalid, invalid},
        {marble, marble, marble, marble, invalid},
        {marble, marble, marble, marble, marble}};

    boardDefaultConstructorMove2 = new MarbleSolitaireModelState.SlotState[][]
        {{marble, invalid, invalid, invalid, invalid},
        {empty, marble, invalid, invalid, invalid},
        {marble, empty, empty, invalid, invalid},
        {marble, marble, marble, marble, invalid},
        {marble, marble, marble, marble, marble}};

    boardDefaultConstructorMove3 = new MarbleSolitaireModelState.SlotState[][]
        {{marble, invalid, invalid, invalid, invalid},
        {empty, marble, invalid, invalid, invalid},
        {marble, marble, empty, invalid, invalid},
        {marble, empty, marble, marble, invalid},
        {marble, empty, marble, marble, marble}};

    boardDefaultConstructorMove4 = new MarbleSolitaireModelState.SlotState[][]
        {{marble, invalid, invalid, invalid, invalid},
        {empty, marble, invalid, invalid, invalid},
        {marble, marble, empty, invalid, invalid},
        {marble, empty, marble, marble, invalid},
        {marble, marble, empty, empty, marble}};

    boardDefaultConstructorMove5 = new MarbleSolitaireModelState.SlotState[][]
        {{marble, invalid, invalid, invalid, invalid},
        {empty, marble, invalid, invalid, invalid},
        {marble, marble, empty, invalid, invalid},
        {marble, empty, marble, marble, invalid},
        {empty, empty, marble, empty, marble}};

    boardDefaultConstructorMove6 = new MarbleSolitaireModelState.SlotState[][]
        {{marble, invalid, invalid, invalid, invalid},
        {empty, marble, invalid, invalid, invalid},
        {marble, marble, marble, invalid, invalid},
        {marble, empty, marble, empty, invalid},
        {empty, empty, marble, empty, empty}};

    boardDefaultConstructorMove7 = new MarbleSolitaireModelState.SlotState[][]
        {{marble, invalid, invalid, invalid, invalid},
        {empty, empty, invalid, invalid, invalid},
        {marble, marble, empty, invalid, invalid},
        {marble, empty, marble, marble, invalid},
        {empty, empty, marble, empty, empty}};

    boardDefaultConstructorMove8 = new MarbleSolitaireModelState.SlotState[][]
        {{marble, invalid, invalid, invalid, invalid},
        {empty, empty, invalid, invalid, invalid},
        {marble, marble, marble, invalid, invalid},
        {marble, empty, empty, marble, invalid},
        {empty, empty, empty, empty, empty}};

    boardDefaultConstructorMove9 = new MarbleSolitaireModelState.SlotState[][]
        {{marble, invalid, invalid, invalid, invalid},
        {marble, empty, invalid, invalid, invalid},
        {empty, marble, marble, invalid, invalid},
        {empty, empty, empty, marble, invalid},
        {empty, empty, empty, empty, empty}};

    boardDefaultConstructorMove10 = new MarbleSolitaireModelState.SlotState[][]
        {{marble, invalid, invalid, invalid, invalid},
        {marble, marble, invalid, invalid, invalid},
        {empty, marble, empty, invalid, invalid},
        {empty, empty, empty, empty, invalid},
        {empty, empty, empty, empty, empty}};

    boardDefaultConstructorMove11 = new MarbleSolitaireModelState.SlotState[][]
        {{empty, invalid, invalid, invalid, invalid},
        {empty, marble, invalid, invalid, invalid},
        {marble, marble, empty, invalid, invalid},
        {empty, empty, empty, empty, invalid},
        {empty, empty, empty, empty, empty}};

    boardDefaultConstructorMove12 = new MarbleSolitaireModelState.SlotState[][]
        {{empty, invalid, invalid, invalid, invalid},
        {empty, marble, invalid, invalid, invalid},
        {empty, empty, marble, invalid, invalid},
        {empty, empty, empty, empty, invalid},
        {empty, empty, empty, empty, empty}};

    boardDefaultConstructorMove13 = new MarbleSolitaireModelState.SlotState[][]
        {{marble, invalid, invalid, invalid, invalid},
        {empty, empty, invalid, invalid, invalid},
        {empty, empty, empty, invalid, invalid},
        {empty, empty, empty, empty, invalid},
        {empty, empty, empty, empty, empty}};
  }

  @Test
  public void testValidConstructors() {
    for (int row = 0; row < triangleModelDefaultConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDefaultConstructor.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructor[row][col],
                triangleModelDefaultConstructor.getSlotAt(row, col));
      }
    }

    for (int row = 0; row < triangleModelDiffArmConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDiffArmConstructor.getBoardSize(); col++) {
        assertEquals(boardDiffArmConstructor[row][col],
                triangleModelDiffArmConstructor.getSlotAt(row, col));
      }
    }

    for (int row = 0; row < triangleModelDiffRowColConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDiffRowColConstructor.getBoardSize(); col++) {
        assertEquals(boardDiffRowColConstructor[row][col],
                triangleModelDiffRowColConstructor.getSlotAt(row, col));
      }
    }

    for (int row = 0; row < triangleModelDiffArmRowColConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDiffArmRowColConstructor.getBoardSize(); col++) {
        assertEquals(boardDiffArmRowColConstructor[row][col],
                triangleModelDiffArmRowColConstructor.getSlotAt(row, col));
      }
    }

  }

  @Test
  public void CreateInvalidBoardOneArg() {
    assertThrows(IllegalArgumentException.class,
        () -> new TriangleSolitaireModel(-1));
  }

  @Test
  public void CreateInvalidBoardTwoArgs() {
    assertThrows(IllegalArgumentException.class,
        () -> new TriangleSolitaireModel(15, 15));
    assertThrows(IllegalArgumentException.class,
        () -> new TriangleSolitaireModel(3, 4));
  }

  @Test
  public void CreateInvalidBoardThreeArgs() {
    assertThrows(IllegalArgumentException.class,
        () -> new TriangleSolitaireModel(-1, 0, 0));
    assertThrows(IllegalArgumentException.class,
        () -> new TriangleSolitaireModel(3, 3,4));
    assertThrows(IllegalArgumentException.class,
        () -> new TriangleSolitaireModel(3, 15, 15));

  }

  @Test
  public void InvalidGetSlotAt() {
    // checks constructors which each parameter at different invalid get slots
    assertThrows(IllegalArgumentException.class,
        () -> triangleModelDefaultConstructor.getSlotAt(10, 10));
    assertThrows(IllegalArgumentException.class,
        () -> triangleModelDiffArmRowColConstructor.getSlotAt(-1, -1));
  }

  @Test
  public void InvalidMoveSlotState() {
    // invalid to invalid
    assertThrows(IllegalArgumentException.class,
        () -> triangleModelDefaultConstructor.move(0, 4, 2, 4));
    // invalid to empty
    assertThrows(IllegalArgumentException.class,
        () -> triangleModelDefaultConstructor.move(0, 2, 0, 0));
    //empty to invalid
    assertThrows(IllegalArgumentException.class,
        () -> triangleModelDefaultConstructor.move(0, 0, 0, 2));
    // invalid to marble
    assertThrows(IllegalArgumentException.class,
        () -> triangleModelDefaultConstructor.move(1, 3, 1, 1));
    // marble to invalid
    assertThrows(IllegalArgumentException.class,
        () -> triangleModelDefaultConstructor.move(1, 1, 1, 3));
    // marble, empty, empty
    triangleModelDefaultConstructor.move(2, 0, 0, 0);
    assertThrows(IllegalArgumentException.class,
        () -> triangleModelDefaultConstructor.move(3, 0, 1, 0));
    triangleModelDefaultConstructor = new TriangleSolitaireModel();
    // empty, empty, marble
    triangleModelDefaultConstructor.move(2, 0, 0, 0);
    assertThrows(IllegalArgumentException.class,
        () -> triangleModelDefaultConstructor.move(1, 0, 3, 0));
    triangleModelDefaultConstructor = new TriangleSolitaireModel();

  }

  @Test
  public void testInvalidMovesDistance() {
    // dist wrong left
    triangleModelDefaultConstructor.move(2, 0, 0, 0);
    triangleModelDefaultConstructor.move(4, 0, 2, 0);
    assertThrows(IllegalArgumentException.class,
        () -> triangleModelDefaultConstructor.move(4, 3, 4, 0));
    triangleModelDefaultConstructor = new TriangleSolitaireModel();
    // dist wrong right
    triangleModelDefaultConstructor.move(2, 2, 0, 0);
    triangleModelDefaultConstructor.move(4, 4, 2, 2);
    assertThrows(IllegalArgumentException.class,
        () -> triangleModelDefaultConstructor.move(4, 1, 4, 4));
    triangleModelDefaultConstructor = new TriangleSolitaireModel();
    // dist wrong diag up right
    assertThrows(IllegalArgumentException.class,
        () -> triangleModelDefaultConstructor.move(3, 3, 0, 0));
    // dist wrong diag up right
    assertThrows(IllegalArgumentException.class,
        () -> triangleModelDefaultConstructor.move(3, 0, 0, 0));
    // dist wrong diag down left
    assertThrows(IllegalArgumentException.class,
        () -> triangleModelDefaultConstructor.move(0, 0, 3, 0));
    // dist wrong diag down right
    assertThrows(IllegalArgumentException.class,
        () -> triangleModelDefaultConstructor.move(0, 0, 3, 3));
  }

  @Test
  public void testValidMoves() {
    TriangleSolitaireModel triangleModel = new TriangleSolitaireModel();
    // diagonal up left
    triangleModel.move(2, 0, 0, 0);
    for (int row = 0; row < triangleModelDefaultConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDefaultConstructor.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructorMove1[row][col],
                triangleModel.getSlotAt(row, col));
      }
    }
    triangleModel.move(2, 2, 2, 0);

    // left
    for (int row = 0; row < triangleModelDefaultConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDefaultConstructor.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructorMove2[row][col],
                triangleModel.getSlotAt(row, col));
      }
    }

    // diagonal up right
    triangleModel.move(4, 1, 2, 1);

    for (int row = 0; row < triangleModelDefaultConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDefaultConstructor.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructorMove3[row][col],
                triangleModel.getSlotAt(row, col));
      }
    }
    // left
    triangleModel.move(4, 3, 4, 1);

    for (int row = 0; row < triangleModelDefaultConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDefaultConstructor.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructorMove4[row][col],
                triangleModel.getSlotAt(row, col));
      }
    }

    // right
    triangleModel.move(4, 0, 4, 2);

    for (int row = 0; row < triangleModelDefaultConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDefaultConstructor.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructorMove5[row][col],
                triangleModel.getSlotAt(row, col));
      }
    }

    // diagonal up left
    triangleModel.move(4, 4, 2, 2);

    for (int row = 0; row < triangleModelDefaultConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDefaultConstructor.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructorMove6[row][col],
                triangleModel.getSlotAt(row, col));


      }
      System.out.println("\n");
    }
    triangleModel.move(1, 1, 3, 3);
    for (int row = 0; row < triangleModelDefaultConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDefaultConstructor.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructorMove7[row][col],
                triangleModel.getSlotAt(row, col));
      }
    }
    triangleModel.move(4, 2, 2, 2);

    for (int row = 0; row < triangleModelDefaultConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDefaultConstructor.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructorMove8[row][col],
                triangleModel.getSlotAt(row, col));
      }
    }
    triangleModel.move(3, 0, 1, 0);

    for (int row = 0; row < triangleModelDefaultConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDefaultConstructor.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructorMove9[row][col],
                triangleModel.getSlotAt(row, col));
      }
    }
    triangleModel.move(3, 3, 1, 1);

    for (int row = 0; row < triangleModelDefaultConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDefaultConstructor.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructorMove10[row][col],
                triangleModel.getSlotAt(row, col));
      }
    }
    triangleModel.move(0, 0, 2, 0);

    for (int row = 0; row < triangleModelDefaultConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDefaultConstructor.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructorMove11[row][col],
                triangleModel.getSlotAt(row, col));
      }
    }
    triangleModel.move(2, 0, 2, 2);

    for (int row = 0; row < triangleModelDefaultConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDefaultConstructor.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructorMove12[row][col],
                triangleModel.getSlotAt(row, col));
      }
    }
    triangleModel.move(2, 2, 0, 0);
    for (int row = 0; row < triangleModelDefaultConstructor.getBoardSize(); row++) {
      for (int col = 0; col < triangleModelDefaultConstructor.getBoardSize(); col++) {

        assertEquals(boardDefaultConstructorMove13[row][col],
                triangleModel.getSlotAt(row, col));
      }
    }

  }

  @Test
  public void testGetBoardSize() {
    assertEquals(triangleModelDefaultConstructor.getBoardSize(), 5);
    assertEquals(triangleModelDiffArmConstructor.getBoardSize(), 7);
  }

  @Test
  public void testGetSlotAtc() {
    // default constructor
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty,
            triangleModelDefaultConstructor.getSlotAt(0, 0));
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble,
            triangleModelDefaultConstructor.getSlotAt(4, 4));
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid,
            triangleModelDefaultConstructor.getSlotAt(0, 4));
    // diff arm
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty,
            triangleModelDiffArmConstructor.getSlotAt(0, 0));
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble,
            triangleModelDiffArmConstructor.getSlotAt(6, 6));
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid,
            triangleModelDiffArmConstructor.getSlotAt(3, 6));

    // diff row and col
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty,
            triangleModelDiffRowColConstructor.getSlotAt(2, 2));
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble,
            triangleModelDiffRowColConstructor.getSlotAt(2, 1));
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid,
            triangleModelDiffRowColConstructor.getSlotAt(2, 4));

    // diff arm, row, and col
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty,
            triangleModelDiffArmRowColConstructor.getSlotAt(5, 5));
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble,
            triangleModelDiffArmRowColConstructor.getSlotAt(5, 4));
    assertEquals(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid,
            triangleModelDiffArmRowColConstructor.getSlotAt(2, 6));
  }


  @Test
  public void testIsGameOver() {
    TriangleSolitaireModel triangleModelL = new TriangleSolitaireModel();
    triangleModelL.move(2, 0, 0, 0);
    triangleModelL.move(2, 2, 2, 0);
    triangleModelL.move(4, 2, 2, 2);
    assertFalse(triangleModelL.isGameOver());
    triangleModelL.move(2, 0, 4, 2);
    triangleModelL.move(4, 0, 2, 0);
    triangleModelL.move(4, 2, 4, 0);
    triangleModelL.move(4, 4, 4, 2);
    triangleModelL.move(2, 2, 4, 4);
    triangleModelL.move(0, 0, 2, 2);
    assertTrue(triangleModelL.isGameOver());

    TriangleSolitaireModel triangleModel = new TriangleSolitaireModel();
    triangleModel.move(2, 0, 0, 0);
    triangleModel.move(2, 2, 2, 0);
    triangleModel.move(4, 1, 2, 1);
    triangleModel.move(4, 3, 4, 1);
    assertFalse(triangleModel.isGameOver());
    triangleModel.move(4, 0, 4, 2);
    triangleModel.move(4, 4, 2, 2);
    triangleModel.move(1, 1, 3, 3);
    triangleModel.move(4, 2, 2, 2);
    triangleModel.move(3, 0, 1, 0);
    triangleModel.move(3, 3, 1, 1);
    triangleModel.move(0, 0, 2, 0);
    triangleModel.move(2, 0, 2, 2);
    triangleModel.move(2, 2, 0, 0);
    assertTrue(triangleModel.isGameOver());
  }

  @Test
  public void getScore() {
    TriangleSolitaireModel triangleModel = new TriangleSolitaireModel();
    assertEquals(14, triangleModel.getScore());
    triangleModel.move(2, 0, 0, 0);
    assertEquals(13, triangleModel.getScore());
    triangleModel.move(2, 2, 2, 0);
    assertEquals(12, triangleModel.getScore());
    triangleModel.move(4, 1, 2, 1);
    assertEquals(11, triangleModel.getScore());
    triangleModel.move(4, 3, 4, 1);
    assertEquals(10, triangleModel.getScore());
    triangleModel.move(4, 0, 4, 2);
    assertEquals(9, triangleModel.getScore());
    triangleModel.move(4, 4, 2, 2);
    assertEquals(8, triangleModel.getScore());
    triangleModel.move(1, 1, 3, 3);
    assertEquals(7, triangleModel.getScore());
    triangleModel.move(4, 2, 2, 2);
    assertEquals(6, triangleModel.getScore());
    triangleModel.move(3, 0, 1, 0);
    assertEquals(5, triangleModel.getScore());
    triangleModel.move(3, 3, 1, 1);
    assertEquals(4, triangleModel.getScore());
    triangleModel.move(0, 0, 2, 0);
    assertEquals(3, triangleModel.getScore());
    triangleModel.move(2, 0, 2, 2);
    assertEquals(2, triangleModel.getScore());
    triangleModel.move(2, 2, 0, 0);
    assertEquals(1, triangleModel.getScore());
    assertTrue(triangleModel.isGameOver());
  }



}