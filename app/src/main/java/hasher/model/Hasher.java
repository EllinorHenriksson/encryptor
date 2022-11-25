package hasher.model;

public class Hasher {
  public final int numberOfHashBuckets = 256;
  private final int factor = 7;

  public int hash(String input) {
    byte[] bytes = input.getBytes();
    int total = 0;
    for (byte b : bytes) {
      total += ((int) b) * factor;
    }

    return total % numberOfHashBuckets;
  }
}
