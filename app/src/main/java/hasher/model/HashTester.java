package hasher.model;

import java.util.ArrayList;

public class HashTester {
  private Hasher hasher = new Hasher();

  public HashTester() {
  }

  public TestResult testUniformity(ArrayList<String> inputs) {
    ArrayList<ArrayList<String>> hashTable = createHashTable();

    for (int i = 0; i < inputs.size(); i++) {
      String input = inputs.get(i);
      int hashCode = hasher.hash(input);
      hashTable.get(hashCode).add(input);
    }

    return new TestResult(hashTable);
  }

  public TestResult testRandomness(ArrayList<String> inputs) {
    ArrayList<ArrayList<String>> hashTable = createHashTable();

    for (int i = 0; i < inputs.size(); i++) {
      String input = inputs.get(i);
      int hashCode = hasher.hash(input);
      hashTable.get(hashCode).add(input);
    }

    return new TestResult(hashTable);
  }

  private ArrayList<ArrayList<String>> createHashTable() {
    ArrayList<ArrayList<String>> hashTable = new ArrayList<ArrayList<String>>();

    for (int i = 0; i < hasher.numberOfHashBuckets; i++) {
      hashTable.add(new ArrayList<String>());
    }

    return hashTable;
  }
}
