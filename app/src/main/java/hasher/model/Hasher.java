package hasher.model;

public class Hasher {
  public final int numberOfHashBuckets = 256;

  public int hash(String input) {
    byte[] bytes = input.getBytes();
    int total = 0;
    for (byte b : bytes) {
      total += (int) b;
    }

    return total % numberOfHashBuckets;
  }
}
