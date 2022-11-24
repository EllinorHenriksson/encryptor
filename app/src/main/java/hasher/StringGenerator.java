package hasher;

import java.util.Random;

public class StringGenerator {
  private final String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private Random rand = new Random();

  public String generateRandomString(int maxLength) {
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
