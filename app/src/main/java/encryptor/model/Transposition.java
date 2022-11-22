package encryptor.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Transposition {

  public String encrypt(TranspositionKey keyobj, String plaintext) {
    String key = keyobj.getKey();

    char[][] plainChars = getCharsIn2d(plaintext, key.length());
    int[] permutationOrder = getPermutationOrder(key);

    char[][] cipherChars = permute(plainChars, permutationOrder);

    // Convert 2d array to string

    return null;
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

  private char[][] getCharsIn2d(String text, int columns) {
    int rows = (int) Math.ceil(text.length() / columns);
    char [][] charsIn2d = new char[rows][columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        charsIn2d[i][j] = text.charAt(i * columns + j);
        System.out.print(charsIn2d[i][j] + "");
      }
      System.out.println();
    }

    return charsIn2d;
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

  public String decrypt(TranspositionKey key, String chipher) {
    // TODO Auto-generated method stub
    return null;
  }
}
