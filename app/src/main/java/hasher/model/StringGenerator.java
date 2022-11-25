package hasher.model;

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
    similars.add(original);
    for (int i = 1; i < original.length(); i++) {
      char[] similar = similars.get(i - 1).toCharArray();
      int oldChar = (int) (byte) similar[i];
      int newChar = (oldChar ^ (1 << (rand.nextInt(7))));
      similar[i] = (char) (byte) newChar;
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
