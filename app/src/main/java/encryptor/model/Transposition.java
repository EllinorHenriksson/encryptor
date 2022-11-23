package encryptor.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Transposition {

  public String encrypt(TranspositionKey keyobj, String plaintext) {
    String key = keyobj.getKey();

    char[][] plainChars = getCharsIn2d(plaintext, key.length());
    int[] permutationOrder = getPermutationOrder(key);

    char[][] cipherChars = permute(plainChars, permutationOrder);

    String cipher = convertToString(cipherChars);

    return cipher;
  }

  public String decrypt(TranspositionKey keyobj, String cipher) {
    String key = keyobj.getKey();

    char[][] cipherChars = getCharsIn2d(cipher, key.length());
    int[] permutationOrder = getPermutationOrder(key);

    char[][] plainChars = reversePermutation(cipherChars, permutationOrder);

    String plaintext = convertToString(plainChars);

    return plaintext;
  }

  private char[][] getCharsIn2d(String text, int columns) {
    int rows = (int) Math.ceil((float) text.length() / columns);
    char [][] chars = new char[rows][columns];

    for (int i = 0; i < chars.length; i++) {
      for (int j = 0; j < chars[i].length; j++) {
        if (i * columns + j < text.length()) {
          chars[i][j] = text.charAt(i * columns + j);
        }
      }
    }

    return chars;
  }

  private int[] getPermutationOrder(String key) {
    char[] keyChars = key.toCharArray();
    Arrays.sort(keyChars);
    ArrayList<Character> sortedChars = convertToArrayList(keyChars);

    int[] permutationOrder = new int[key.length()];

    for (int i = 0; i < key.length(); i++) {
      char c = key.charAt(i);
      int indexOfSortedChar = sortedChars.indexOf(c);
      sortedChars.set(indexOfSortedChar, null);
      permutationOrder[i] = indexOfSortedChar;
    }

    return permutationOrder;
  }

  private ArrayList<Character> convertToArrayList(char[] chars) {
    ArrayList<Character> converted = new ArrayList<>();
    for (char c : chars) {
      converted.add(c);
    }
    return converted;
  }

  private char[][] permute(char[][] chars, int[] order) {
    char[][] result = new char[chars.length][chars[0].length];
    for (int i = 0; i < chars.length; i++) {
      for (int j = 0; j < chars[i].length; j++) {
        result[i][j] = chars[i][order[j]];
      }
    }
    return result;
  }

  private char[][] reversePermutation(char[][] chars, int[] order) {
    char[][] result = new char[chars.length][chars[0].length];
    for (int i = 0; i < chars.length; i++) {
      for (int j = 0; j < chars[i].length; j++) {
        result[i][order[j]] = chars[i][j];
      }
    }
    return result;
  }

  private String convertToString(char[][] chars) {
    String result = "";
    for (int i = 0; i < chars.length; i++) {
      for (int j = 0; j < chars[i].length; j++) {
        result += chars[i][j];
      }
    }

    return result;
  }
}
