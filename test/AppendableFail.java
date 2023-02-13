import java.io.IOException;

/**
 * Class to test if an I/O Exception would be caught in the view/controller.
 */
public class AppendableFail implements Appendable {
  public AppendableFail() {
    // doesn't take in any arguments
  }

  /**
   * Overrides append to throw an IO Exception for exception testing.
   * @param csq
   *         The character sequence to append.  If {@code csq} is
   *         {@code null}, then the four characters {@code "null"} are
   *         appended to this Appendable.
   *
   * @return nothing, just a method to throw IOException.
   * @throws IOException always, used to test if IOexception is caught by try-catch methods
   */
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException();
  }

  /**
   * Overrides append to throw an IO Exception for exception testing.
   * @param csq
   *         The character sequence from which a subsequence will be
   *         appended.  If {@code csq} is {@code null}, then characters
   *         will be appended as if {@code csq} contained the four
   *         characters {@code "null"}.
   *
   * @param start
   *         The index of the first character in the subsequence
   *
   * @param end
   *         The index of the character following the last character in the
   *         subsequence
   *
   * @return nothing, just a method to throw IOException.
   * @throws IOException always, used to test if IOexception is caught by try-catch methods
   */
  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException();
  }

  /**
   * Overrides append to throw an IO Exception for exception testing.
   * @param c
   *         The character to append
   *
   * @return nothing, just a method to throw IOException.
   * @throws IOException always, used to test if IOexception is caught by try-catch methods
   */
  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException();
  }
}
