import org.junit.Test;

import java.io.IOException;


import cs3500.marblesolitaire.view.TriangleSolitaireTextView;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * Tests all of the view methods for triangle solitaire.
 */
public class TriangleSolitaireTextViewTest {

  TriangleSolitaireModel triangleModelDefaultConstructor = new TriangleSolitaireModel();
  TriangleSolitaireModel triangleModelDiffArmConstructor = new
          TriangleSolitaireModel(7);


  TriangleSolitaireModel triangleModelDiffRowColConstructor
          = new TriangleSolitaireModel( 2,2);
  TriangleSolitaireModel triangleModelDiffArmRowColConstructor
          = new TriangleSolitaireModel(7,5,5);

  Appendable outDC = new StringBuilder();
  Appendable outDAC = new StringBuilder();
  Appendable outDRC = new StringBuilder();
  Appendable outDARC = new StringBuilder();
  TriangleSolitaireTextView triangleViewDefaultConstructor = new
          TriangleSolitaireTextView(triangleModelDefaultConstructor, outDC);

  TriangleSolitaireTextView triangleViewDiffArmConstructor = new
          TriangleSolitaireTextView(triangleModelDiffArmConstructor, outDAC);

  TriangleSolitaireTextView triangleViewDiffRowColConstructor = new
          TriangleSolitaireTextView(triangleModelDiffRowColConstructor, outDRC);

  TriangleSolitaireTextView triangleViewDiffArmRowColConstructor = new
          TriangleSolitaireTextView(triangleModelDiffArmRowColConstructor, outDARC);
  String triangleViewDefaultConstructorToString =
            "    _\n"
          + "   O O\n"
          + "  O O O\n"
          + " O O O O\n"
          + "O O O O O";

  String triangleViewDefaultConstructorRenderBoard =
            "    _\n"
          + "   O O\n"
          + "  O O O\n"
          + " O O O O\n"
          + "O O O O O\n";
  String triangleViewDiffRowColConstructorToString =
            "    O\n"
          + "   O O\n"
          + "  O O _\n"
          + " O O O O\n"
          + "O O O O O";

  String triangleViewDiffRowColConstructorRenderBoard =
            "    O\n"
          + "   O O\n"
          + "  O O _\n"
          + " O O O O\n"
          + "O O O O O\n";
  String triangleViewDiffArmConstructorToString =
            "      _\n"
          + "     O O\n"
          + "    O O O\n"
          + "   O O O O\n"
          + "  O O O O O\n"
          + " O O O O O O\n"
          + "O O O O O O O";

  String triangleViewDiffArmConstructorRenderBoard =
            "      _\n"
          + "     O O\n"
          + "    O O O\n"
          + "   O O O O\n"
          + "  O O O O O\n"
          + " O O O O O O\n"
          + "O O O O O O O\n";
  String triangleViewDiffArmRowColConstructorToString =
            "      O\n"
          + "     O O\n"
          + "    O O O\n"
          + "   O O O O\n"
          + "  O O O O O\n"
          + " O O O O O _\n"
          + "O O O O O O O";

  String triangleViewDiffArmRowColConstructorRenderBoard =
            "      O\n"
          + "     O O\n"
          + "    O O O\n"
          + "   O O O O\n"
          + "  O O O O O\n"
          + " O O O O O _\n"
          + "O O O O O O O\n";


  @Test
  public void testTriangleView() {


    assertEquals(triangleViewDefaultConstructorToString,
            triangleViewDefaultConstructor.toString());

    assertEquals(triangleViewDiffArmConstructorToString,
            triangleViewDiffArmConstructor.toString());

    assertEquals(triangleViewDiffRowColConstructorToString,
            triangleViewDiffRowColConstructor.toString());

    assertEquals(triangleViewDiffArmRowColConstructorToString,
            triangleViewDiffArmRowColConstructor.toString());

  }

  @Test
  public void testRenderBoard() {
    try {
      triangleViewDefaultConstructor.renderBoard();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(triangleViewDefaultConstructorRenderBoard,
            outDC.toString());

    try {
      triangleViewDiffArmConstructor.renderBoard();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(triangleViewDiffArmConstructorRenderBoard,
            outDAC.toString());
    try {
      triangleViewDiffRowColConstructor.renderBoard();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(triangleViewDiffRowColConstructorRenderBoard,
            outDRC.toString());

    try {
      triangleViewDiffArmRowColConstructor.renderBoard();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(triangleViewDiffArmRowColConstructorRenderBoard,
            outDARC.toString());
  }


}