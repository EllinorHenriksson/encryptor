package hasher;

import java.util.Random;

public class randomStringGenerator {
  private final String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private Random rand = new Random();
  private final int maxLength = 100;

  public String generateRandomString() {
    StringBuffer buffer = new StringBuffer();
    int length = rand.nextInt(maxLength) + 1;
    for (int i = 0; i < length; i++) {
      int position = rand.nextInt(chars.length());
      char c = chars.charAt(position);
      buffer.append(c);
    }

    return buffer.toString();
  }
}
