package hasher;

public class Hasher {
  public int hash(String input) {
    byte[] bytes = input.getBytes();
    int total = 0;
    for (byte b : bytes) {
      total += (int) b;
    }

    return total % 256;
  }
}
