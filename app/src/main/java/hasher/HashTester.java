package hasher;

import java.util.ArrayList;

public class HashTester {
  private HashCodeGenerator hashCodeGenerator = new HashCodeGenerator();
  private randomStringGenerator randomStringGenerator = new randomStringGenerator();
  private ArrayList<String> inputs;
  private final int numberOfInput = 10;
  private final int numberOfHashCodes = 256;

  public HashTester() {
    inputs = new ArrayList<>();
    generateInput();
  }

  private void generateInput() {
    for (int i = 0; i < numberOfInput; i++) {
      inputs.add(randomStringGenerator.generateRandomString());
    }
  }

  public void run() {
    ArrayList<ArrayList<String>> hashTable = createHashTable();

    for (int i = 0; i < inputs.size(); i++) {
      String input = inputs.get(i);
      int hashCode = hashCodeGenerator.hash(input);
      hashTable.get(hashCode).add(input);
    }

    printHashTable(hashTable);
  }

  private ArrayList<ArrayList<String>> createHashTable() {
    ArrayList<ArrayList<String>> hashTable = new ArrayList<ArrayList<String>>();

    for (int i = 0; i < numberOfHashCodes; i++) {
      hashTable.add(new ArrayList<String>());
    }

    return hashTable;
  }

  private void printHashTable(ArrayList<ArrayList<String>> hashTable) {
    System.out.println("***** Hash table *****");
    for (int i = 0; i < hashTable.size(); i++) {
      System.out.println("Hash code: " + i);
      for (int j = 0; j < hashTable.get(i).size(); j++) {
        System.out.println("  Input: " + hashTable.get(i).get(j));
      }
    }
  }
}
