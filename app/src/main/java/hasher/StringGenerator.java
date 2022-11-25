package hasher;

import java.util.ArrayList;
import java.util.Random;

public class StringGenerator {
  private final String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private Random rand = new Random();

  public String generateRandomStringOfRandomSize(int maxLength) {
    StringBuffer buffer = new StringBuffer();
    int length = rand.nextInt(maxLength) + 1;
    for (int i = 0; i < length; i++) {
      int position = rand.nextInt(chars.length());
      char c = chars.charAt(position);
      buffer.append(c);
    }

    return buffer.toString();
  }

  public ArrayList<String> generateSimilarStrings(int numberOfStrings) {
    String original = generateRandomStringOfFixedSize(numberOfStrings);
    ArrayList<String> similars = new ArrayList<>();
    for (int i = 0; i < original.length(); i++) {
      char[] similar = original.toCharArray();
      int oldChar = (int) similar[i];
      int newChar = (oldChar ^ (1 << (0)));
      similar[i] = (char) newChar;
      similars.add(String.valueOf(similar));
    }

    return similars;
  }

  private String generateRandomStringOfFixedSize(int length) {
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < length; i++) {
      int position = rand.nextInt(chars.length());
      char c = chars.charAt(position);
      buffer.append(c);
    }

    return buffer.toString();
  }
}
